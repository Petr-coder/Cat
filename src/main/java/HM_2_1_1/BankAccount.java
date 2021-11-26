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
Карточный счёт, при снятии денег с которого будет взиматься комиссия 1 %

Напишите метод в классе BankAccount:
boolean send(BankAccount receiver, double amount)
для отправки денег с одного счёта на другой. Метод должен вернуть true, если деньги успешно переведены.
Примечание
В методе для аргумента amount используйте тип данных, который применили в классе BankAccount. Тип double дан для примера.
 */
abstract class BankAccount {

    double accountBalance;

    void withdrawMoney(double sum) {
        if (this.accountBalance - sum < 0) {
            System.out.println("Insufficient funds in the account.");
        } else
            this.accountBalance -= sum;
    }

    void depositSum(double sum) {
        this.accountBalance += sum;
        System.out.println("This is superClassMethod");
    }

    double getAccountBalance() {
        return this.accountBalance;
    }

    boolean send(BankAccount receiver, double amount) {
        double accountSum = receiver.getAccountBalance();
        withdrawMoney(amount);
        receiver.depositSum(amount);
        accountBalance = accountBalance - amount;

        return accountSum + amount == receiver.getAccountBalance();
    }
}
