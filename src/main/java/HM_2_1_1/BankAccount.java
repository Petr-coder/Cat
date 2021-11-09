package HM_2_1_1;

/*
Цель задания
Освоить на практике наследование классов.
Что нужно сделать
1. Создайте класс BankAccount, который представляет собой расчётный счёт в банке. У класса необходимо написать методы:
     a. Снять со счёта сумму денег (без комиссии).
     b. Вносить на счёт сумму денег (без комиссии).
     c. Получить остаток на счёте.
2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
Карточный счёт, при снятии денег с которого будет взиматься комиссия 1
 */
public class BankAccount {

    private double accountBalance;

    void withdrawMoneyFromAccount(double sum) {
        if (this.accountBalance - sum < 0) {
            System.out.println("Insufficient funds in the account.");
        } else
            this.accountBalance -= sum;
    }

    void depositSumOfMoney(double sum) {
        this.accountBalance += sum;
    }

    double getAccountBalance() {
        return this.accountBalance;
    }

}
