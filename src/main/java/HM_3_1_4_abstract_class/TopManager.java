package HM_3_1_4_abstract_class;

public class TopManager extends Employee {

    private static int fixedSalary = 500_000;

    TopManager() {
        setSalary(fixedSalary);
        setCompany(null);
    }

    int getIncomeForCompany() {
        return 0;
    }

    void incomeCompanyGreatSuccess() {
        setSalary((int) (fixedSalary * 2.5));
    }
}
