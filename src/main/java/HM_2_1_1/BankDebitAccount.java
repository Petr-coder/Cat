package HM_2_1_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
 */
public class BankDebitAccount extends BankAccount {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private Date dateOfLastDeposit;

    @Override
    void depositSum(double sum) {
        accountBalance += sum;
        dateOfLastDeposit = new Date();
    }

    @Override
    void withdrawMoney(double sum) {
        Date currentDate = new Date();
        long milliseconds = currentDate.getTime() - dateOfLastDeposit.getTime();
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));

        if (this.accountBalance - sum >= 0) {
            if (days > 30) {
            } else if (days <= 30) {
                System.out.println("No money can be withdrawn from the current account within a month after the last " +
                        "deposit");
            }
        } else {
            System.out.println("Insufficient funds in the account.");
        }
    }
}
