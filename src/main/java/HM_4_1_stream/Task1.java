package HM_4_1_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Практическое задание
1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто встречающееся;
 */
public class Task1 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList(
                "Жаба", "Жаба", "Корова", "Бык", "Змея","Змея","Змея","Змея","Змея", "Кот", "Кот", "Кот"
        ));

        Map< String, Long > wordsByCount = words.stream()
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        String frequentWord = wordsByCount.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println(frequentWord);



    }

}
