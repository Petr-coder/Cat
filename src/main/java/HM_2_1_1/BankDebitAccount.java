package HM_2_1_1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/*
2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
 */
public class BankDebitAccount extends BankAccount {

    public static void main(String[] args) {
        double accountBalance;
        int Date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse("28.01.2009", formatter);
        LocalDate endDate = LocalDate.parse("05.03.2013", formatter);
        Period period = Period.between(startDate, endDate);
        System.out.println(period.getYears());      // 4
        System.out.println(period.getMonths());     // 1
        System.out.println(period.getDays());       // 5

    }

}
