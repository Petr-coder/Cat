package part3.HM_3_1_4_abstract_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class Company {

    private int income;
    private String name;


    public Company(String name) {
        this.name = name;
    }

    private List<Employee> employeeList = new ArrayList();

    void hire(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Info about new employee does not exist");
        }

        if (employee.getCompany() != null && employee.getCompany().equals(this)) {
            System.out.println("This person is already employee of company");
        } else {
            employee.setCompany(this);
            employeeList.add(employee);
            if (employee instanceof Manager) {
                this.income = this.income + employee.getIncomeForCompany();
            } else if (employee instanceof TopManager) {
                if (this.income > 10_000_000) {
                    ((TopManager) employee).incomeCompanyGreatSuccess();
                }
            }
        }
    }

    void hireAll(List<Employee> potentionalEmployeeList) {
        if (potentionalEmployeeList == null) {
            throw new NullPointerException("List of new employees is empty");
        }
        for (Employee employee : potentionalEmployeeList) {
            this.hire(employee);
        }
    }


    void fire(Employee employee) {
        employee.setCompany(null);
        employeeList.remove(employee);
    }

    void fire(int numberOfStaff) {
        for (int i = 0; i < numberOfStaff; i++) {
            employeeList.remove(i);
        }
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    List<Employee> getTopSalaryStaff(int count) {

        if (count > employeeList.size() || count < 0) {
            throw new IllegalArgumentException();
        }

        Collections.sort(employeeList);
        Collections.reverse(employeeList);
        List<Employee> listTopSalaryStaff = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            listTopSalaryStaff.add(employeeList.get(i));
        }

        return listTopSalaryStaff;
    }

    List<Employee> getLowestSalaryStaff(int count) {

        if (count > employeeList.size() || count < 0) {
            throw new IllegalArgumentException();
        }

        Collections.sort(employeeList);
        List<Employee> listLowestSalaryStaff = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            listLowestSalaryStaff.add(employeeList.get(i));
        }

        return listLowestSalaryStaff;
    }

    void printTopSalary(List<Employee> employees) {
        System.out.println("Список из " + employees.size() + " самых высоких зарплат по убыванию:");
        for (Employee unit : employees) {
            System.out.println(" - " + String.format(Locale.CANADA_FRENCH, "%,d", unit.getMonthSalary()) + " руб.");
        }
    }

    void printBottomSalary(List<Employee> employees) {
        System.out.println("Список из " + employees.size() + " самых низких зарплат по возрастанию:");
        for (Employee unit : employees) {
            System.out.println(" - " + String.format(Locale.CANADA_FRENCH, "%,d", unit.getMonthSalary()) + " руб.");
        }
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Company " + name;
    }
}
