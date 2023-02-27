package part4.HM_4_5;

import com.opencsv.bean.CsvBindByName;

import java.util.Arrays;
import java.util.List;

public class CityUpgraded {
    @CsvBindByName(column = "ID", required = true)
    private int id;
    @CsvBindByName(column = "Name", required = true)
    private String name;
    @CsvBindByName(column = "CountryCode", required = true)
    private String CountryCode;
    @CsvBindByName(column = "District", required = false)
    private String District;
    @CsvBindByName(column = "Population", required = true)
    private int Population;
    private List<Language> listOfLanguage;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }


    public void setListOfLanguage(List<Language> listOfLanguage) {
        this.listOfLanguage = listOfLanguage;
    }

    public List<Language> getListOfLanguage() {
        return listOfLanguage;
    }

    @Override
    public String toString() {
        return "CityUpgraded{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                ", listOfLanguage=" + listOfLanguage +
                '}' + '\n';
    }
}
