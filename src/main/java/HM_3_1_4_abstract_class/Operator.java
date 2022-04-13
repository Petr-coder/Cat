package HM_3_1_4_abstract_class;

public class Operator extends Employee {

    private static int fixedSalary = 50_000;

    Operator() {
        setSalary(fixedSalary);
        setCompany(null);
    }

    @Override
    int getIncomeForCompany() {
        return 0;
    }
}
