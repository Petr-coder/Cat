package HM_5_5;

import static HM_5_5.Utils.extractLettersFromPlate;

public class VerificationOfLicensePlate {

    static String LICENSE_FORMATE = "[ABEKMHOPCTYX]{1}[0-9]{1}[0-9]{1}[0-9]{1}[ABEKMHOPCTYX]{2}[0-9]{1}[0-9]{1}[0-9]?";

    /*
Красивый номер:
+ 1 и 3 цифра совпадают
+ 1 и 2 цифры совпадают
+ 2 и 3 цифры совпадают
+ все буквы совпадают
+ 1 и 3 буква совпадают
- PYC, XEP, HET, MKA, KEK, XAM, BOP, TAK, KAK, TYT
 */
    static String[] COOL_WORDS = new String[]{"PYC", "XEP", "HET", "MKA", "KEK", "XAM", "BOP", "TAK",
            "HEX", "BOP", "PEB", "POK", "KOT", "TOK", "POM", "MOP", ""};

    static boolean verificationOfCoolness(String[] plate) {
        return checkIfDigitsMatch(plate) || checkLettersMatch(plate) || checkCoolWords(plate);
    }


    static boolean checkIfDigitsMatch(String[] plate) {
        return checkFirstAndThirdDigitsMatch(plate) | checkFirstAndThirdDigitsMatch(plate) |
                checkSecondAndThirdDigitsMatch(plate);
    }

    static boolean checkFirstAndThirdDigitsMatch(String[] plate) {
        return plate[1].equals(plate[3]);
    }

    static boolean checkFirstAndSecondDigitsMatch(String[] plate) {
        return plate[1].equals(plate[2]);
    }

    static boolean checkSecondAndThirdDigitsMatch(String[] plate) {
        return plate[2].equals(plate[3]);
    }

    static boolean checkLettersMatch(String[] plate) {
        return checkAllLettersMatch(plate) || checkFirstAndThirdLettersMatch(plate);
    }

    static boolean checkAllLettersMatch(String[] plate) {
        return plate[0].equals(plate[4]) && plate[0].equals(plate[5]);
    }

    static boolean checkFirstAndThirdLettersMatch(String[] plate) {
        return plate[0].equals(plate[5]);
    }

    static boolean checkCoolWords(String[] plate) {
        String plateLetters = extractLettersFromPlate(plate);
        boolean result = false;

        for (int i = 0; i < COOL_WORDS.length; i++) {
            if (plateLetters.equals(COOL_WORDS[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    static boolean checkResultIsLicensePlate(String[] plate) {
        String result = String.join("", plate);
        return result.matches(LICENSE_FORMATE);
    }
}
