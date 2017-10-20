package block.io;

import model.IBlock;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by joris on 10/17/17.
 */
public class BeepBlock extends IBlock {
    @Override
    public String getName() {
        return "beep";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 0;
    }

    @Override
    public Object[] process(Object[] in) {
        boolean playBeep = (Boolean) in[0];
        if(!playBeep)
            return new Object[0];
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("beep-06.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and binaryLoad samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return new Object[0];
    }

}
