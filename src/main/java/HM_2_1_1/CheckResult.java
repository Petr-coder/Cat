package HM_2_1_1;

public class CheckResult {
    public static void main(String[] args) {

        BankCreditAccount bankCreditAccount = new BankCreditAccount();
        bankCreditAccount.depositSum(1000);

        BankDebitAccount bankDebitAccount = new BankDebitAccount();
        System.out.println("bankCreditAccount.getAccountBalance() = " + bankCreditAccount.getAccountBalance());
        System.out.println("bankDebitAccount.getAccountBalance() = " + bankDebitAccount.getAccountBalance());
        bankCreditAccount.send(bankDebitAccount, 200);
        System.out.println("bankCreditAccount.getAccountBalance() = " + bankCreditAccount.getAccountBalance());
        System.out.println("bankDebitAccount.getAccountBalance() = " + bankDebitAccount.getAccountBalance());
    }
}
