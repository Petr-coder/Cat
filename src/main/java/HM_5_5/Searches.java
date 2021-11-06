package HM_5_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Searches {

    public static int linearSearchArrayList(ArrayList<String> arrayList, String elementToSearch) {
        long start = System.nanoTime();
        String result = "не найден";

        for (int index = 0; index < arrayList.size(); index++) {

            if (arrayList.get(index).equals(elementToSearch))
                result = "номер найден";
            break;
        }

        long finish = System.nanoTime();
        System.out.println("Поиск перебором: номер " + result + ", поиск занял " + (finish - start) + " нс");
        return -1;
    }

    public static int binarySearch(List<String> list, String searchValue) {
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
        System.out.println("Поиск бинарный: номер " + result + ", поиск занял " + (finish - start) + " нс");

        return mid;

    }


    public static int searchHashSet(Set<String> set, String elementToSearch) {
        long start = System.nanoTime();
        String result = "не найден";
        String className = set.getClass().toString();
        if (className.contains("TreeSet")) {
            className = "TreeSet";
        } else if(className.contains("HashSet")) {
            className = "HashSet";
        }

        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String stringArray = iterator.next();
            if (stringArray.equals(elementToSearch))
                result = "найден";

        }

        long finish = System.nanoTime();
        System.out.println("Поиск в " + className + ": номер " + result + ", поиск занял " + (finish - start) + " нс");

        return -1;
    }

}
