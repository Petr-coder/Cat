package part4.HM_4_5;

import com.opencsv.bean.CsvBindByName;

public class Language {
    @CsvBindByName(column = "CountryCode", required = true)
    private String CountryCode;
    @CsvBindByName(column = "Language", required = true)
    private String Language;
    @CsvBindByName(column = "IsOfficial", required = true)
    private boolean IsOfficial;

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public boolean isOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(boolean official) {
        IsOfficial = official;
    }

    @Override
    public String toString() {
        return "Language{" +
                "CountryCode='" + CountryCode + '\'' +
                ", Language='" + Language + '\'' +
                ", IsOfficial='" + IsOfficial + '\'' +
                '}';
    }
}
