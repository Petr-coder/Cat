package part4.HM_4_5;

/*
Задание 4
Реализовать метод parse,на вход которого подается:
●	адрес до файла, который необходимо парсить
●	класс, которым будет параметризован список
Метод должен возвращать список из объектов типа переданного вторым аргументом.

Пример использования метода:
List<Language> languages = parser("src/main/resources/countrylanguage.csv", Language.class); */

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Task4 {

    public static <T> List<T> parse(String filePath, Class<T> clazz) throws IOException {
        Reader reader = new FileReader(filePath);
        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }

}
