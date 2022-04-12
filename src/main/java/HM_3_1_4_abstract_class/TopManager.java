package HM_3_1_4_abstract_class;

public class TopManager extends Employee {

    private static int fixedSalary = 500_000;

    TopManager() {
        super.salary = fixedSalary;
        super.company = null;
    }


    @Override
    int getMonthSalary() {
        return super.salary;
    }

    @Override
    int getIncomeForCompany() {
        return 0;
    }

    void incomeCompanyGreatSuccess() {
        this.salary = (int) (this.salary * 2.5);
    }
}
