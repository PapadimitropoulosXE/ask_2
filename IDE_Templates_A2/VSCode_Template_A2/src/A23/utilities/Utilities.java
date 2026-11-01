package A23.utilities;

import java.util.Random;

public class Utilities {
    private static final Random random = new Random();

    public static int getRandomVal(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than max.");
        }
        return random.nextInt((max - min) + 1) + min;
    }
}