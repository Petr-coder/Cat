package HM_2_1_1;

public class CheckResult {
    public static void main(String[] args) throws InterruptedException {

        BankCreditAccount bankCreditAccount = new BankCreditAccount();
        bankCreditAccount.depositSum(1000);

        BankDebitAccount bankDebitAccount = new BankDebitAccount(1000);
        bankDebitAccount.depositSum(1000);
        System.out.println("bankCreditAccount.getAccountBalance() = " + bankCreditAccount.getAccountBalance());
        System.out.println("bankDebitAccount.getAccountBalance() = " + bankDebitAccount.getAccountBalance());
        bankCreditAccount.send(bankDebitAccount, 200);
        System.out.println("bankCreditAccount.getAccountBalance() = " + bankCreditAccount.getAccountBalance());
        System.out.println("bankDebitAccount.getAccountBalance() = " + bankDebitAccount.getAccountBalance());

        System.out.println("______________________________________________________________________________________");

        bankDebitAccount.send(bankCreditAccount, 500);
        bankDebitAccount.withdrawMoney(100);
        System.out.println(bankDebitAccount.send(bankCreditAccount, 100));
        System.out.println("bankCreditAccount.getAccountBalance() = " + bankCreditAccount.getAccountBalance());
        System.out.println("bankDebitAccount.getAccountBalance() = " + bankDebitAccount.getAccountBalance());
    }
}
