package HM_5_5;

import java.util.*;

import static HM_5_5.Utils.generateRussianLicensePlate;
import static HM_5_5.VerificationOfLicensePlate.checkIfResultIsLicensePlate;
import static HM_5_5.VerificationOfLicensePlate.verificationOfCoolness;

public class generateCollectionOfLicensePlate {

    @Deprecated
    static List<String[]> generateListOfPlates(int quantity) {
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            String[] plate;

            while (true) {
                plate = generateRussianLicensePlate();
                if (checkIfResultIsLicensePlate(plate)) {
                    if (verificationOfCoolness(plate)) {
                        list.add(plate);
                        break;
                    }
                }
            }
        }

        return list;
    }

    static HashSet<String> generateHashSetOfPlates(int quantity) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < quantity; i++) {
            String[] plate;

            while (true) {
                plate = generateRussianLicensePlate();
                if (checkIfResultIsLicensePlate(plate)) {
                    if (verificationOfCoolness(plate)) {
                        set.add(Arrays.toString(plate));
                        break;
                    }
                }
            }
        }

        return set;
    }

    @Deprecated
    static TreeSet<String[]> generateTreeSetOfPlates(int quantity) {
        TreeSet<String[]> set = new TreeSet<>();
        for (int i = 0; i < quantity; i++) {
            String[] plate;

            while (true) {
                plate = generateRussianLicensePlate();
                if (checkIfResultIsLicensePlate(plate)) {
                    if (verificationOfCoolness(plate)) {
                        set.add(plate);
                        break;
                    }
                }
            }
        }

        return set;
    }

}