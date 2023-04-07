package Factory;

import Model.Audio;
import Util.RandomGenerator;

import java.util.Random;

public class AudioFactory {

    public Audio createAudio() {
        Random random = new Random();

        var length = random.nextInt(1,300);

        return new Audio(RandomGenerator.randomStringGenerator(), length);
    }
}
