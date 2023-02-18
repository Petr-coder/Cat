package part4.HM_4_5;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/*
Задание 1.
Создать два списка из объектов City и Language соответственно, на основании двух приложенных файлов
(city.csv и countrylanguage.csv).
Подсказка - используя чтение в массив строк, необходимо добавить
.withSkipLines(1) перед .build() для того чтобы была пропущена первая строка (“шапка” таблицы).
 */
public class Task1 {

    private static final String cityFilePath = "src/main/resources/part4/city.csv";
    private static final String countryLanguageFilePath = "src/main/resources/part4/countrylanguage.csv";

    public static void main(String[] args) throws IOException, CsvException {

        List<Language> languageList = new CsvToBeanBuilder(new FileReader(countryLanguageFilePath))
                .withType(Language.class)
                .build()
                .parse();

        List<City> cityList = new CsvToBeanBuilder(new FileReader(cityFilePath))
                .withType(City.class)
                .build()
                .parse();

        for (Language language : languageList) {
            System.out.println("Country Code: " + language);

        }

        System.out.println("_______________");
        System.out.println("_______________");
        System.out.println("_______________");
        System.out.println("_______________");
        System.out.println("_______________");
        System.out.println("_______________");

        for (City city : cityList) {
            System.out.println("Country Code: " + city);

        }
    }


}