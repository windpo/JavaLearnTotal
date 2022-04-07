package javaLearn_chapter5.equals_hashcode_toString;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author 风之诗
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise=salary*byPercent/100;
        salary+=raise;
    }

    /**
     * 重写Object的equals方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        //引用是否相等
        if (this == o) {
            return true;
        }
        //传入对象是否为空或者两对象是否相等
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        //强转
        Employee employee = (Employee) o;
        //比较具体细节
        return Double.compare(employee.salary, salary) == 0
                && name.equals(employee.name)
                && hireDay.equals(employee.hireDay);
    }

    @Override
    public int hashCode() {
        //返回由Object自动组装的hashCode码
        return Objects.hash(name, salary, hireDay);
    }

    /**
     * 重写toString方法格式化输出
     * @return
     */
    @Override
    public String toString() {
        //getClass().getName()方便子类调用
        return  getClass().getName()+
                "{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
