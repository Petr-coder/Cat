package part4.HM_4_5;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/*
Посчитать количество городов, в которых русский язык является не официальным.
Получить список из названий городов (List<String> cityName), которые относятся к странам, в которых более
трех официальных языков.
 */
public class Task3 {

    private static final String cityFilePath = "src/main/resources/part4/city.csv";
    private static final String countryLanguageFilePath = "src/main/resources/part4/countrylanguage.csv";

    public static void main(String[] args) throws IOException {

        List<Language> languageList = new CsvToBeanBuilder(new FileReader(countryLanguageFilePath))
                .withType(Language.class)
                .build()
                .parse();

        int count = 0;
        for (CityUpgraded city : getCityList()) {
            boolean russianOfficial = false;
            for (Language language : languageList) {
                if (city.getCountryCode().equals(language.getCountryCode()) &&
                        language.getLanguage().equalsIgnoreCase("Russian") &&
                        language.isOfficial()) {
                    russianOfficial = true;
                    break;
                }
            }
            if (!russianOfficial) {
                count++;
            }
        }
        System.out.println("Number of cities where Russian is not an official language: " + count);

        List<String> cityName = getCityList().stream()
                .filter(city -> getOfficialLanguageCount(city.getCountryCode(), languageList) > 3)
                .map(CityUpgraded::getName)
                .collect(Collectors.toList());

        System.out.println("List of city names belonging to countries with more than three official languages: " + cityName);
    }

    private static List<CityUpgraded> getCityList() throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(cityFilePath))
                .withType(CityUpgraded.class)
                .build()
                .parse();
    }

    private static int getOfficialLanguageCount(String countryCode, List<Language> languageList) {
        return (int) languageList.stream()
                .filter(language -> countryCode.equals(language.getCountryCode()))
                .filter(Language::isOfficial)
                .count();
    }
}

