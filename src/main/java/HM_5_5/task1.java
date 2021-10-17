///*
//Что нужно сделать
//1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:
//- прямым перебором по ArrayList,
//- бинарным поиском по отсортированному ArrayList,
//- поиском в HashSet,
//- поиском в TreeSet.
//2. Измерьте и сравните длительность каждого метода поиска.
//Формат вывода результатов поиска:
//- Поиск перебором: номер найден/не найден, поиск занял 34нс
//- Бинарный поиск: номер найден/не найден, поиск занял 34нс
//- Поиск в HashSet: номер найден/не найден, поиск занял 34нс
//- Поиск в TreeSet: номер найден/не найден, поиск занял 34нс
//3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.
//
//Рекомендации:
//Сортировка не входит в учёт времени для бинарного поиска.
//Для детального сравнения методов поиска используйте время в наносекундах:
//     System.nanoTime()
//Используйте правила генерации номеров для получения более 2 млн номеров:
//XYZ — различные буквы, N — цифры, R — регион (от 01 до 199);
//XNNNYZR — пример, A111BC197, Y777HC66,
//таким образом, количество номер будет достаточно для оценки времени поиска даже в миллисекундах.
//
// */
//package HM_5_5;
//
//
//import java.util.ArrayList;
//
//public class task1 {
//
//
//    public static int linearSearch(ArrayList<String> arrayList, String elementToSearch) {
//
//        for (int index = 0; index < arrayList.size(); index++) {
//            if (arrayList.get(index).matches(elementToSearch))
//                return index;
//        }
//        return -1;
//    }
//
//    public static int binarySearch(ArrayList<String> arrayList, String elementToSearch) {
//
//        int firstIndex = 0;
//        int lastIndex = arrayList.size() - 1;
//
//        // условие прекращения (элемент не представлен)
//        while (firstIndex <= lastIndex) {
//            int middleIndex = (firstIndex + lastIndex) / 2;
//            // если средний элемент - целевой элемент, вернуть его индекс
//            if (arrayList.get(middleIndex).matches(elementToSearch)) {
//                return middleIndex;
//            }
//
//            // если средний элемент меньше
//            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
//            else if (arrayList.get(middleIndex) < elementToSearch)
//                firstIndex = middleIndex + 1;
//
//                // если средний элемент больше
//                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
//            else if (arr[middleIndex] > elementToSearch)
//                lastIndex = middleIndex - 1;
//
//        }
//        return -1;
//    }
//}
