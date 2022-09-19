package part4.HM_4_1_stream;

import java.util.*;

/*
Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
имя1, имя2, имяN;”.
 */
public class Task3 {

    public static void main(String[] args) {

        Employee[] employeeList = new Employee[]{
                new Employee("John", 33, 20000),
                new Employee("Sarah", 18, 13123),
                new Employee("Ivan", 55, 30000),
                new Employee("Vasya", 44, 40000),
                new Employee("Serg", 22, 50000),
                new Employee("Oleg", 23, 60000)
        };
        printLargestSalaryList(employeeList, 3);
    }

    static void printLargestSalaryList(Employee[] list, int number) {
        System.out.println(number + " самых старших сотрудников зовут:");
        Arrays.stream(list).sorted(Comparator.comparing(Employee::getAge).reversed()).limit(number).forEach(e ->
                System.out.print(e.getName() + ", "));
    }
}
