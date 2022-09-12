package HM_5_5;

import java.util.Set;
import java.util.StringJoiner;

public class Utils {

    static int MIN_NUMBER = 0;
    static int MAX_NUMBER = 9;
    static String[] ARRAY_OF_VALID_LETTERS = new String[]{"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};

    public static String[] generateRussianLicensePlate() {
        String[] region = generateRegion();

        String[] licensePlate = new String[6];
        licensePlate[0] = generateLetter();
        licensePlate[1] = String.valueOf(generateDigit());
        licensePlate[2] = String.valueOf(generateDigit());
        licensePlate[3] = String.valueOf(generateDigit());
        licensePlate[4] = generateLetter();
        licensePlate[5] = generateLetter();

        return (String.join("", licensePlate) + String.join("", region)).split("");
    }


    static String generateLetter() {
        int index = (int) ((Math.random() * ((ARRAY_OF_VALID_LETTERS.length - 1 - 0) + 1)) + 0);
        return ARRAY_OF_VALID_LETTERS[index];
    }

    public static int generateDigit() {
        return (int) ((Math.random() * ((MAX_NUMBER - MIN_NUMBER) + 1)) + MIN_NUMBER);
    }

    static String[] generateRegion() {
        String region = String.valueOf((int) ((Math.random() * ((199 - 1 - 0) + 1)) + 1));
        if (Integer.parseInt(region) < 10) {
            region = "0" + region;
        }
        return region.split("");
    }

    static String extractLettersFromPlate(String[] plate) {
        StringJoiner joiner = new StringJoiner("");
        return joiner
                .add(plate[0])
                .add(plate[4])
                .add(plate[5]).toString();
    }

    static String getClassOfSet(Set<String> set) {
        String className = set.getClass().toString();

        if (className.contains("TreeSet")) {
            className = "TreeSet";
        } else if (className.contains("HashSet")) {
            className = "HashSet";
        }
        return className;
    }
}
