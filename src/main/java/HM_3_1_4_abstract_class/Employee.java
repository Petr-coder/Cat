package HM_3_1_4_abstract_class;

abstract class Employee implements Comparable {

    int salary;
    Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    abstract int getMonthSalary();

    abstract int getIncomeForCompany();

    public int compareTo(Object obj) {
        Employee tmp = (Employee) obj;
        if (this.salary < tmp.salary) {
            return -1;
        } else if (this.salary > tmp.salary) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
