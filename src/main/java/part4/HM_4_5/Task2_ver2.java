package part4.HM_4_5;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
Создать новый класс, на основании City (без наследования), в котором language это не строковое поле,
а список из объектов класса Language. Пример: город Willemstad содержит список из объектов класса Language:
Dutch, English, Papiamento, потому что этому городу в табл. city соответствует CountryCode ANT,
а в табл. countrylanguage этому же коду страны соответствуют 3 языка.
 */
public class Task2_ver2 {
    private static final String cityFilePath = "src/main/resources/part4/city.csv";
    private static final String countryLanguageFilePath = "src/main/resources/part4/countrylanguage.csv";

    public static void main(String[] args) throws IOException {

        List<Language> languageList = new CsvToBeanBuilder(new FileReader(countryLanguageFilePath))
                .withType(Language.class)
                .build()
                .parse();

        List<City> cityList = new CsvToBeanBuilder(new FileReader(cityFilePath))
                .withType(City.class)
                .build()
                .parse();

        Map<String, List<Language>> languageMap = languageList.stream()
                .collect(Collectors.groupingBy(Language::getCountryCode));

        List<CityFull> cityFullList = cityList.stream()
                .map(city -> {
                    CityFull cityFull = new CityFull();
                    cityFull.setId(city.getId());
                    cityFull.setName(city.getName());
                    cityFull.setCountryCode(city.getCountryCode());
                    cityFull.setDistrict(city.getDistrict());
                    cityFull.setPopulation(city.getPopulation());
                    Optional<List<Language>> optionalLanguages = Optional.ofNullable(languageMap.get(city.getCountryCode()));
                    optionalLanguages.ifPresent(cityFull::setListOfLanguage);
                    return cityFull;
                })
                .collect(Collectors.toList());

        System.out.println(cityFullList);
    }
}


