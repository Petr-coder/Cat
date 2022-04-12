package HM_3_1_4_abstract_class;

public class Manager extends Employee {

    private static int fixedSalary = 100_000;
    private int MAX_INCOME = 140_000;
    private int MIN_INCOME = 115_000;
    private int incomeForCompany = (int) ((Math.random() * ((MAX_INCOME - MIN_INCOME) + 1)) + MIN_INCOME);

    Manager() {
        super.salary = (int) (fixedSalary + (incomeForCompany * 0.05));
        super.company = null;
    }
    
    int getIncomeForCompany() {
        return incomeForCompany;
    }

    @Override
    int getMonthSalary() {
        return super.salary;
    }
}
