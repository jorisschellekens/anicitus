package block.nlp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NLP {

    private static Map<String, Double> MODEL_NL  = loadMap("nlp/nl_languagemodel");
    private static Map<String, Double> MODEL_EN = loadMap("nlp/en_languagemodel");
    private static Map<String, Double> MODEL_DE = loadMap("nlp/de_languagemodel");

    private static Map<String, Integer> countNGrams(String text)
    {
        text = text.toLowerCase();
        Map<String, Integer> ngramFrequency = new HashMap<>();
        int[] ngramSizes = {1,2,3};
        for(int i=0;i<text.length() - ngramSizes[ngramSizes.length - 1];i++)
        {
            for(int s : ngramSizes)
            {
                String subs = text.substring(i, i+s);
                if(!subs.matches("[a-zA-Z0-9]+"))
                    continue;
                if(!ngramFrequency.containsKey(subs))
                    ngramFrequency.put(subs, 0);
                ngramFrequency.put(subs, ngramFrequency.get(subs) + 1);
            }
        }
        return ngramFrequency;
    }

    private static Map<String, Double> trimMap(Map<String, Integer> inputMap)
    {
        // count total (to determine relative weight)
        int total = 0;
        for(Integer i : inputMap.values())
            total += i;

        // sort
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(inputMap.entrySet());
        java.util.Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        // truncate
        double totalMass = 0.0;
        int toIndex = 0;
        while(totalMass < 0.95)
        {
            totalMass += ((double) entryList.get(toIndex).getValue() / (double) total);
            toIndex++;
        }

        // return
        Map<String, Double> retval = new HashMap<>();
        for(int i=0;i<toIndex;i++)
        {
            String key = entryList.get(i).getKey();
            double val = (double) entryList.get(i).getValue() / (double) total;
            retval.put(key, val);
        }

        return retval;
    }

    private static Map<String, Double> loadMap(String path)
    {
        Map<String, Double> retval =  new HashMap<>();
        Scanner sc = new Scanner(NLP.class.getClassLoader().getResourceAsStream(path));
        while (sc.hasNextLine())
        {
            String[] line = sc.nextLine().split("\t");
            retval.put(line[0], Double.parseDouble(line[1]));
        }
        return retval;
    }

    private static double compareModels(Map<String, Double> m0, Map<String, Double> m1, double alpha)
    {
        Set<String> keys = new HashSet<>();
        keys.addAll(m0.keySet());
        keys.addAll(m1.keySet());

        // consine similarity
        double aa = 0;
        double bb = 0;
        double ab = 0;
        for(String key : keys)
        {
            double f0 = m0.containsKey(key) ? m0.get(key) * (1.0 - alpha) : alpha;
            double f1 = m1.containsKey(key) ? m1.get(key) * (1.0 - alpha) : alpha;

            aa += java.lang.Math.pow(f0, 2);
            bb += java.lang.Math.pow(f1, 2);
            ab += (f0 * f1);
        }
        return (ab / (java.lang.Math.sqrt(aa) * java.lang.Math.sqrt(bb)));
    }

    public static String getLanguage(String text)
    {
        Map<String, Double> textModel = trimMap(countNGrams(text));
        String[] lngs = {"DE", "EN", "NL"};
        double[] cmps = {compareModels(textModel, MODEL_DE, 0.01),
                        compareModels(textModel, MODEL_EN, 0.01),
                        compareModels(textModel, MODEL_NL, 0.01)};
        int bestIndex = 0;
        for(int i=0;i<lngs.length;i++)
        {
            if(cmps[i] > cmps[bestIndex])
                bestIndex = i;
        }
        return lngs[bestIndex];
    }
}
