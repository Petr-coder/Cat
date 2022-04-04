package HM_3_1_4_abstract_class;

/*
Цель задания
Научиться работать с абстрактным классом и взаимодействием классов.
Что нужно сделать:
1. Создайте класс компании Company, содержащей сотрудников и реализующей методы:
- найм одного сотрудника — hire(),
- найм списка сотрудников – hireAll(),
- увольнение сотрудника – fire(),
- получение значения дохода компании – getIncome().
Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.

2. Создайте два метода, возвращающие список указанной длины (count). Они должны содержать сотрудников, отсортированных
по убыванию и возрастанию заработной платы:
- List<Employee> getTopSalaryStaff(int count),
- List<Employee> getLowestSalaryStaff(int count).

3. Создайте классы сотрудников с информацией о зарплатах и условиями начисления зарплаты:
- Manager — зарплата складывается из фиксированной части (оклад) и бонуса в виде 5% от заработанных для компании денег.
Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
- TopManager — зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы, если доход
компании более 10 млн рублей.
- Operator — зарплата складывается только из фиксированной части.

В каждом классе сотрудника должен быть объявлен метод, возвращающий зарплату сотрудника:
- getMonthSalary()
Аргументы и возвращаемое значение метода выберите в соответствии с логикой начисления зарплат.

Для демонстрации и тестирования работы ваших классов:
- Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager.
- Распечатайте список из 10–15 самых высоких зарплат в компании.
- Распечатайте список из 30 самых низких зарплат в компании.
- Увольте 50% сотрудников.
- Распечатайте список из 10–15 самых высоких зарплат в компании.
- Распечатайте список из 30 самых низких зарплат в компании.

Примеры вывода списка зарплат
Список из пяти зарплат по убыванию:
- 230 000 руб.
- 178 000 руб.
- 165 870 руб.
- 123 000 руб.
- 117 900 руб.

Рекомендации
Можно создавать разные экземпляры компании со своим списком сотрудников и доходом.
Чтобы получить данные компании внутри класса сотрудника, настройте хранение ссылки на Company и передавайте объект
Company с помощью конструктора или сеттера.
Учтите, в методы получения списков зарплат могут передаваться значения count, превышающие количество сотрудников
в компании, или отрицательные.
 */
public class Task {
}
