package HM_2_1_1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
 */
public class BankDebitAccount extends BankAccount {

    private Date dateOfLastDeposit;

    public BankDebitAccount(double accountBalance) {
        super(accountBalance);
    }


    @Override
    void depositSum(double sum) throws InterruptedException {
        accountBalance += sum;
        dateOfLastDeposit = new Date();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(dateOfLastDeposit);
    }

    @Override
    boolean withdrawMoney(double sum) {
        System.out.println("This is withdrawMoney from BankDebitAccount");

        if (isWithdrawPossible(sum)) {
            this.accountBalance -= sum;
            return true;
        } else {
            if (this.accountBalance - sum < 0) {
                System.out.println("Insufficient funds in the debit account.");
            } else {
                System.out.println("No money can be withdrawn from the current account within a month after the last " +
                        "deposit");
            }
            return false;
        }
    }

    @Override
    boolean isWithdrawPossible(double amount) {
        Date currentDate = new Date();
        long milliseconds;

        if (dateOfLastDeposit != null) {
            milliseconds = currentDate.getTime() - dateOfLastDeposit.getTime();
        } else {
            milliseconds = 0;
        }

        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        return this.accountBalance - amount >= 0 && (days > 30 || milliseconds == 0);
    }
}
