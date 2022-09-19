package part4.HM_4_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    private static SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");
    private static SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
    String name;
    int salary;
    Calendar hireDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public Employee(String name, int salary, String hireDate) {
        this.name = name;
        this.salary = salary;

        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(formatter.parse(hireDate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.hireDate = calendar;
    }

    @Override
    public String toString() {
        return name + ", salary = " + salary +
                ", hireDate = " + dayFormatter.format(hireDate.getTime()) + "." + monthFormatter.format(hireDate.getTime()) + "."
                + hireDate.get(Calendar.YEAR);
    }
}
