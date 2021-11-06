package HM_5_5;

import java.util.*;

import static HM_5_5.Utils.getClassOfSet;

public class Searches {

    public static void linearSearchArrayList(ArrayList<String> arrayList, String elementToSearch) {
        long start = System.nanoTime();
        String result = "не найден";

        for (int index = 0; index < arrayList.size(); index++) {

            if (arrayList.get(index).equals(elementToSearch))
                result = "номер найден";
            break;
        }

        long finish = System.nanoTime();
        System.out.println("Поиск перебором: номер " + result + ", поиск занял " + (finish - start) + " нс");
    }

    public static void binaryHandMadeSearch(List<String> list, String searchValue) {
        long start = System.nanoTime();
        String result = "найден";

        int low = 0;
        int high = list.size() - 1;
        int mid = (low + high) / 2;

        while (low <= high && !list.get(mid).equalsIgnoreCase(searchValue)) {

            if (list.get(mid).compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;

            if (low > high) {
                result = "не найден";
            }

        }
        long finish = System.nanoTime();
        System.out.println("Поиск бинарный (мой): номер " + result + ", поиск занял " + (finish - start) + " нс");
    }

    public static void binaryCollectionsSearch(List<String> list, String searchValue) {
        long start = System.nanoTime();
        String result = "найден";

        if(Collections.binarySearch(list, searchValue)==-1){
            result = "не найден";
        }

        long finish = System.nanoTime();
        System.out.println("Поиск бинарный из Collections: номер " + result + ", поиск занял " + (finish - start) + " нс");
    }

    public static void linearSearchInSet(Set<String> set, String elementToSearch) {
        long start = System.nanoTime();
        String result = "не найден";

        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String stringArray = iterator.next();
            if (stringArray.equals(elementToSearch))
                result = "найден";
        }

        long finish = System.nanoTime();
        System.out.println("Поиск в " + getClassOfSet(set) + ": номер " + result + ", поиск занял " + (finish - start) + " нс");
    }

    static void searchSetContains(Set<String> set, String elementToSearch) {
        long start = System.nanoTime();
        String result = "не найден";

        if (set.contains(elementToSearch)) {
            result = "найден";
        }

        long finish = System.nanoTime();
        System.out.println("Поиск в " + getClassOfSet(set) + ".contains: номер " + result + ", поиск занял " + (finish - start) + " нс");
    }
}
