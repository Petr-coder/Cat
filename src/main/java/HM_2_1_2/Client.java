package HM_2_1_2;

/*
Что нужно сделать
    1. Создайте классы, представляющие клиентов банка:
абстрактный класс Client, классы для физических лиц, юридических лиц и индивидуальных предпринимателей.
У каждого клиента есть сумма денег на счету (число).
Деньги можно положить на счёт, снять и вернуть остаток на счёте.
Каждый класс должен содержать метод, который выводит информацию в консоль о счёте: условие пополнения, условие снятия
и баланс.
    2. Реализуйте методы, при которых:
У физических лиц пополнение и снятие происходит без комиссии.
У юридических лиц — снятие с комиссией 1%.
У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна
1000 рублей.

 */
abstract class Client {
    static double commissionOnePercent = 0.01;


    double accountBalance;

    abstract void getAccountInfo();

    abstract void withdrawMoney(double sum);

    abstract void depositSum(double sum);

    abstract boolean isWithdrawPossible(double amount);
}


