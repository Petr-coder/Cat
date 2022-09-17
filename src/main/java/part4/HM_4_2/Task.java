package part4.HM_4_2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task {


    private static final String filePath = "src/main/resources/part4/staff.txt";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws IOException {
        File file = new File(filePath);
        List<Employee> list = Files.lines(file.toPath())
                .map(l -> addEmployee(l))
                .collect(Collectors.toList());

//Сделайте сортировку сотрудников одновременно по заработной плате и алфавиту.
        list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
                .forEach(s -> System.out.println(s));
        System.out.println("__________");
//Выведите в консоль с помощью Stream API сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году. */
        System.out.println(list.stream()
                .filter(employee -> employee.getHireDate().get(Calendar.YEAR) == 2017)
                .max(Comparator.comparing(Employee::getSalary))
                .get());
    }

    public static Employee addEmployee(String data) {
        String[] components = data.split("\\s+");
        String name = components[1] + " " + components[0];
        int salary = Integer.parseInt(components[2]);

        return new Employee(name, salary, components[3]);
    }
}
