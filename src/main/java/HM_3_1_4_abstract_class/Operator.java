package HM_3_1_4_abstract_class;

public class Operator extends Employee {

    private static int fixedSalary = 50_000;

    Operator() {
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
}
