package javaLearn_chapter6.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 风之诗
 * @version 1.0
 */
//注意此处一定要实现cloneable的标记接口
public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay=new Date();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee clone = (Employee) super.clone();
        clone.hireDay=(Date) hireDay.clone();
        return clone;
    }

    public void setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary+=raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
