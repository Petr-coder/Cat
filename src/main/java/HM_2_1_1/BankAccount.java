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
public abstract class BankAccount {

    double accountBalance;

    public BankAccount() {
    }

    public BankAccount(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    boolean withdrawMoney(double sum) {
        if (isWithdrawPossible(sum)) {
            System.out.println("Insufficient funds in the account.");
            return false;
        } else {
            this.accountBalance -= sum;
            return true;
        }
    }

    void depositSum(double sum) throws InterruptedException {
        this.accountBalance += sum;
    }

    double getAccountBalance() {
        return this.accountBalance;
    }

    boolean send(BankAccount receiver, double amount) throws InterruptedException {
        double senderAccountSum = getAccountBalance();
        double receiverAccountSum = receiver.getAccountBalance();

        withdrawMoney(amount);
        if (isWithdrawPossible(amount)) {
            receiver.depositSum(amount);
        }

        return (receiverAccountSum + amount == receiver.getAccountBalance()) && (getAccountBalance() + amount) == senderAccountSum;
    }

    boolean isWithdrawPossible(double amount) {
        return this.accountBalance - amount < 0;
    }

}
