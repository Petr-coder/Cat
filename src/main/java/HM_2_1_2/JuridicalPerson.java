package HM_2_1_2;

public class JuridicalPerson extends Client {

    String accountInfo = "Withdrawal with a fee of 1%.";

    @Override
    void getAccountInfo() {
        System.out.println(accountInfo + "\nAccount balance is " + this.accountBalance);
    }

    @Override
    void withdrawMoney(double sum) {
        if (isWithdrawPossible(sum)) {
            this.accountBalance -= sum + (sum * commissionOnePercent);
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
        if ((this.accountBalance - amount - (amount * commissionOnePercent)) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
