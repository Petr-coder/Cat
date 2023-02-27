package part4.HM_4_5;

import java.util.List;

public class CityFull {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
    private List<Language> languages;

    public CityFull() {

    }

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
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setListOfLanguage(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "CityFull{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", languages=" + languages +
                '}';
    }
}

