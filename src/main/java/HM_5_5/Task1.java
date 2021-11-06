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

import static HM_5_5.GenerateCollectionOfLicensePlate.generateHashSetOfPlates;
import static HM_5_5.Searches.*;


public class Task1 {

    static final int NUMBER_OF_PLATES = 2_500_000;

    public static void main(String[] args) {
        HashSet<String> hashSet = generateHashSetOfPlates(NUMBER_OF_PLATES);
        ArrayList<String> arrayList = new ArrayList<>(hashSet);
        Collections.sort(arrayList);
        int a = Collections.binarySearch(arrayList, "X203OP199");
        System.out.println(a);
        Set<String> treeSet = new TreeSet<>(hashSet);
        //stream фигня оказался. Убрал его

        linearSearchArrayList(arrayList, "X203OP199");
        binaryHandMadeSearch(arrayList, "X203OP199");
        binaryCollectionsSearch(arrayList, "X203OP199");
        linearSearchInSet(hashSet, "X203OP199");
        linearSearchInSet(treeSet, "X203OP199");
        searchSetContains(hashSet, "X203OP199");
        searchSetContains(treeSet, "X203OP199");
    }
//3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.
    //Ответ:
    //  Быстрее всего в рамках этой задачи - линейный (перебором) поиск
    // Но наверняка есть подводные камни. Поэтому это заслуживает отдельного изучения
    //update
    // бинарный из Collections и Set.contains самые быстрые
}
