/*
Что нужно сделать
1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:
- прямым перебором по ArrayList,
- бинарным поиском по отсортированному ArrayList,
- поиском в HashSet,
- поиском в TreeSet.
2. Измерьте и сравните длительность каждого метода поиска.
Формат вывода результатов поиска:
- Поиск перебором: номер найден/не найден, поиск занял 34нс
- Бинарный поиск: номер найден/не найден, поиск занял 34нс
- Поиск в HashSet: номер найден/не найден, поиск занял 34нс
- Поиск в TreeSet: номер найден/не найден, поиск занял 34нс
3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.

Рекомендации:
Сортировка не входит в учёт времени для бинарного поиска.
Для детального сравнения методов поиска используйте время в наносекундах:
     System.nanoTime()
Используйте правила генерации номеров для получения более 2 млн номеров:
XYZ — различные буквы, N — цифры, R — регион (от 01 до 199);
XNNNYZR — пример, A111BC197, Y777HC66,
таким образом, количество номер будет достаточно для оценки времени поиска даже в миллисекундах.

 */
package HM_5_5;

import java.util.*;
import java.util.stream.Collectors;

import static HM_5_5.Searches.*;
import static HM_5_5.generateCollectionOfLicensePlate.generateHashSetOfPlates;

public class task1 {

    static final int NUMBER_OF_PLATES = 2_500_000;

    public static void main(String[] args) {

        HashSet<String> hashSet = generateHashSetOfPlates(NUMBER_OF_PLATES);
        ArrayList<String> arrayList = new ArrayList<>(hashSet);

        Collections.sort(arrayList);
        Set<String> treeSet = new TreeSet<>();
        hashSet.stream()
                .map(String::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));

        linearSearchArrayList(arrayList, "X203OP199");
        binarySearch(arrayList, "X203OP199");
        searchHashSet(hashSet, "X203OP199");
        searchHashSet(treeSet, "X203OP199");

    }
//3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.
  //Ответ:
  //  Быстрее всего в рамках этой задачи - линейный (перебором) поиск
  // Но наверняка есть подводные камни. Поэтому это заслуживает отдельного изучения
}
