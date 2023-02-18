package part4.HM_4_5;

import com.opencsv.bean.CsvBindByName;

public class Language {
    @CsvBindByName(column = "CountryCode", required = true)
    private String CountryCode;
    @CsvBindByName(column = "Language", required = true)
    private String Language;
    @CsvBindByName(column = "IsOfficial", required = true)
    private boolean IsOfficial;

    @Override
    public String toString() {
        return "Language{" +
                "CountryCode='" + CountryCode + '\'' +
                ", Language='" + Language + '\'' +
                ", IsOfficial='" + IsOfficial + '\'' +
                '}';
    }
}
