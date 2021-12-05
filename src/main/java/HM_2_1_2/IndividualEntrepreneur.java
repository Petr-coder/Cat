package HM_2_1_2;

/*
   2. Реализуйте методы, при которых:
У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна
1000 рублей. */

public class IndividualEntrepreneur extends Client {

    static double commissionHalfPercent = 0.005;

    String accountInfo = "Replenishment with a commission of 1%, if the amount on the account is less than 1000 rubles."
            + "\nAnd with a commission of 0.5% if the amount on the account is greater than or equal to 1000 rubles.";

    @Override
    void getAccountInfo() {
        System.out.println(accountInfo + "\nAccount balance is " + this.accountBalance);
    }

    @Override
    void withdrawMoney(double sum) {
        if (isWithdrawPossible(sum)) {
            System.out.println("Insufficient funds in the account.");
        } else {
            this.accountBalance -= sum;
        }
    }

    @Override
    void depositSum(double sum) {
        if (this.accountBalance < 1000) {
            this.accountBalance += (sum * (1 - commissionOnePercent));
        } else {
            this.accountBalance += (sum * (1 - commissionHalfPercent));
        }
    }

    @Override
    boolean isWithdrawPossible(double amount) {
        return false;
    }
}
