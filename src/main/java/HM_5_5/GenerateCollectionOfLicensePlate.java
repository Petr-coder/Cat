package HM_5_5;

import java.util.*;

import static HM_5_5.Utils.generateRussianLicensePlate;
import static HM_5_5.VerificationOfLicensePlate.checkResultIsLicensePlate;
import static HM_5_5.VerificationOfLicensePlate.verificationOfCoolness;

public class GenerateCollectionOfLicensePlate {

    @Deprecated
    //почему deprecated? назначение этой аннотации знаешь?
    //Используется разработчиками (видится что крупными разработчиками) для указания на увтаревшие методы,
    //которые не рекомендуется использоваться
    //Первоначально у меня реализация была иная. Пометил, чтобы вернуться в случае неудачи
    //Но в основном написал больше для "я и эту аннотацию знаю"
    static List<String[]> generateListOfPlates(int quantity) {
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {

            while (true) {
                String[] plate = generateRussianLicensePlate();
                if (checkResultIsLicensePlate(plate) && verificationOfCoolness(plate)) {
                    list.add(plate);
                    break;
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
                if (checkResultIsLicensePlate(plate) && verificationOfCoolness(plate)) {
                    set.add(Arrays.toString(plate));
                    break;
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
                if (checkResultIsLicensePlate(plate) && verificationOfCoolness(plate)) {
                    set.add(plate);
                    break;
                }
            }
        }

        return set;
    }

}