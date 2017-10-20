package block.nlp;

import model.IBlock;

/**
 * Created by joris on 10/16/17.
 */
public class DetermineLanguageBlock extends IBlock {
    @Override
    public String getName() {
        return "determine language";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        String text = in[0].toString();
        return new Object[]{NLP.getLanguage(text)};
    }

}
