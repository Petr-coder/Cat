package HM_4_2;

import HM_3_2_2.Customer;
import HM_3_2_2.IncorrectMailException;
import HM_3_2_2.IncorrectPhoneException;
import HM_3_2_2.InvalidFormatException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Utils.StringUtils.isEmailCorrect;
import static Utils.StringUtils.isPhoneNumberFormatCorrect;

/*
Используя файл src/main/resources/part4/employeeSort/staff.txt:
Сделайте сортировку сотрудников одновременно по заработной плате и алфавиту.
Выведите в консоль с помощью Stream API сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году.
 */
public class Task {
    private static String dataFile = "src/main/resources/part4/staff.txt";
    private static Scanner scanner;
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");


    public void addEmployee(String data) {
        String[] components = data.split("\\s+");
        try {
            Date docDate = format.parse(components[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
