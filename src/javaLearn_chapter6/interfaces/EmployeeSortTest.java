package javaLearn_chapter6.interfaces;

import java.util.Arrays;

/**
 * @author 风之诗
 * @version 1.0
 * 数组Array中的sort方法，Array.sort在对象中如何比较？---->实现comparable接口中的compareTo方法指定对象的比较方法
 * 从而能在对象数组中直接利用sort排序
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0]=(new Employee("Harry Hacker",35000));
        employees[1]=(new Employee("Carl Cracker",75000));
        employees[2]=(new Employee("Tony Tester",38000));
        //根据员工的工资排序
        Arrays.sort(employees);
        for (Employee e :
                employees) {
            System.out.println("name="+e.getName()+",salary="+e.getSalary());
        }
    }
}
