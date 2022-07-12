package Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {


    @Test
    void validateFirstNull(String input) {

        Assertions.assertEquals(true, validate(null, "Asfgsddfg_23"),"The value of \"login\" " +
                "cannot be null");
    }

    @Test
    void validateSecondNull(String input) {

        Assertions.assertEquals(true, validate("Asfgsddfg_23", null),"The value of \"password\" \" +\n" +
                "                \"cannot be null");
    }
}