package part4.HM_4_5;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/*
Создать новый класс, на основании City (без наследования), в котором language это не строковое поле,
а список из объектов класса Language. Пример: город Willemstad содержит список из объектов класса Language:
Dutch, English, Papiamento, потому что этому городу в табл. city соответствует CountryCode ANT,
а в табл. countrylanguage этому же коду страны соответствуют 3 языка.
 */
public class Task2 {

    private static final String cityFilePath = "src/main/resources/part4/city.csv";
    private static final String countryLanguageFilePath = "src/main/resources/part4/countrylanguage.csv";

    public static void main(String[] args) throws IOException {

        List<Language> languageList = new CsvToBeanBuilder(new FileReader(countryLanguageFilePath))
                .withType(Language.class)
                .build()
                .parse();

        Map<String, List<Language>> languageMap = languageList.stream()
                .collect(Collectors.groupingBy(Language::getCountryCode));

        for (Map.Entry<String, List<Language>> entry : languageMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        List<CityUpgraded> cityList = new CsvToBeanBuilder(new FileReader(cityFilePath))
                .withType(CityUpgraded.class)
                .build()
                .parse();

        cityList.forEach(city -> languageMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(city.getCountryCode()))
                .findFirst()
                .ifPresent(entry -> city.setListOfLanguage(entry.getValue())));

        System.out.println(cityList);
    }
}


