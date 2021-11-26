package HM_2_1_1;
/*2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
Карточный счёт, при снятии денег с которого будет взиматься комиссия 1 % */

public class BankCreditAccount extends BankAccount {
    static double commission = 1.01;

    public BankCreditAccount() {
    }

    public BankCreditAccount(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static void main(String[] args) {
        System.out.println(100 * 1.01);
    }


    @Override
    void withdrawMoney(double sum) {
        if (this.accountBalance - (sum * commission) < 0) {
            System.out.println("Insufficient funds in the account!!");
            System.out.println("sum * commission " + sum * commission);
            System.out.println("this.accountBalance - (sum * commission) = " + (this.accountBalance - (sum * commission)));
            System.out.println("(this.accountBalance - (sum * commission) < 0) is " + (this.accountBalance - (sum * commission) < 0));
            System.out.println("accountBalance in BankCreditAccount class = " + this.accountBalance);
        } else
            this.accountBalance -= (sum * commission);
    }
}
