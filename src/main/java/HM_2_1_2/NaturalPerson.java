package HM_2_1_2;

/*      У каждого клиента есть сумма денег на счету (число). Деньги можно положить на счёт, снять и вернуть остаток на счёте.
        Каждый класс должен содержать метод, который выводит информацию в консоль о счёте: условие пополнения, условие снятия
        и баланс.
        2. Реализуйте методы, при которых:
        У физических лиц пополнение и снятие происходит без комиссии.*/

public class NaturalPerson extends Client {

    String accountInfo = "Withdrawal with no fee.";

    @Override
    void getAccountInfo() {
        System.out.println(accountInfo + "\nAccount balance is " + this.accountBalance);
    }

    @Override
    void withdrawMoney(double sum) {
        if (isWithdrawPossible(sum)) {
            this.accountBalance -= sum;
        } else {
            System.out.println("Insufficient funds in the account.");
        }
    }

    @Override
    void depositSum(double sum) {
        this.accountBalance += sum;
    }

    @Override
    boolean isWithdrawPossible(double amount) {
        return this.accountBalance - amount >= 0;
    }
}
