package HM_2_1_1;
/*2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
Карточный счёт, при снятии денег с которого будет взиматься комиссия 1 % */

public class BankCreditAccount extends BankAccount {
    static double commission = 1.01;

    public BankCreditAccount() {

    }

    @Override
    boolean withdrawMoney(double sum) {
        System.out.println("This is withdrawMoney from BankCreditAccount");
        if (isWithdrawPossible(sum)) {
            this.accountBalance -= (sum * commission);
            return true;
        } else {
            System.out.println("Insufficient funds in the account!!");
            return false;
        }
    }

    @Override
    boolean send(BankAccount receiver, double amount) throws InterruptedException {
        return super.send(receiver, amount);
    }

    @Override
    boolean isWithdrawPossible(double amount) {
        return this.accountBalance - (amount * commission) >= 0;
    }
}
