package HM_4_1_stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
среднюю зарплату сотрудника;
 */
public class Task2 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee("John", 33, 20000),
                new Employee("Sarah", 18, 13123),
                new Employee("Ivan", 55, 30000),
                new Employee("Vasya", 44, 40000),
                new Employee("Serg", 22, 50000),
                new Employee("Oleg", 23, 60000)
        ));

        double averageSalary = employeeList.stream().mapToDouble(Employee::getSalary).summaryStatistics().getAverage();
    }
}
