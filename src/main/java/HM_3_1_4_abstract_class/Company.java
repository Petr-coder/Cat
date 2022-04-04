package HM_3_1_4_abstract_class;

import java.util.List;

abstract class Company {

    abstract void hire();

    abstract void voidhireAll();

    abstract void fire();

    abstract void getIncome();

    List<Employee> getTopSalaryStaff(int count){

    }

    List<Employee> getLowestSalaryStaff(int count){

    }
}
