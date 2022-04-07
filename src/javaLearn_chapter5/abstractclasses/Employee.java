package javaLearn_chapter5.abstractclasses;

import java.time.LocalDate;

/**
 * @author 风之诗
 */
public class Employee extends Person{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year,int month,int day) {
        super(name);
        this.salary = salary;
        hireDay= LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }
    //重写父类的抽象方法
    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f",salary);
    }
    public  void raiseSalary(double byPercent){
        double raise=salary*byPercent/100;
        salary+=raise;
    }
    /**
     * 重写Object类equals方法
     *
     */
    @Override
    public boolean equals(Object otherObject) {
        //若为同一引用，则两个对象肯定相等
        if(this==otherObject){ return true;}
        //若比较对象为空，返回false
        if(otherObject==null){ return false;}
        //如果equals的方法实现需要在子类中改变，用getClass比较，否则用instanceof比较
        if(getClass()!=otherObject.getClass()) { return false; }
        //转化为相同类型变量
        Employee other = (Employee) otherObject;
        //定制化需要，比较自己自定义的字段 比如Arrays.equals方法检测对应数组元素是否相等，如果是子类重新定义equals
        //则需要在其中包含一个super.equals(other)
        return this.getName().equals(other.getName())
                &&this.getSalary()==other.getSalary()
                &&this.getHireDay().equals(other.getHireDay());
    }
}
