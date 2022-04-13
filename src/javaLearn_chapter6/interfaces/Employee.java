package javaLearn_chapter6.interfaces;

/**
 * @author 风之诗
 * @version 1.0
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary *byPercent/100;
        salary+=raise;
    }

    /**
     * 实现如何该类对象的比较，重写该类的compareTo方法
     * @param other
     * @return
     */
    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary,other.salary);
    }
    //注：在继承中：如果仅仅使用强转来比较父类与子类，则a.compareTo(b)不会抛出异常，但b.compareTo(a)就可能抛出异常
    //解决方法：1、如果不同子类的比较有不同的含义，则将属于不同类的对象之间的比较规定为非法，抛出异常
    //@Override
    //public  int compareTo(Employee other) {
    //    if(getClass()!=other.getClass()) {
    //        throw new ClassCastException();
    //    }
    //    return Double.compare(salary,other.salary);
    //}
    //解决方法：2、如果存在一个比较子类对象的通用算法，那可以在超类中提供一个compareTo方法，且将该方法设置为final
    //@Override
    //public  final int compareTo(Employee other) {
    //    return Double.compare(salary,other.salary);
    //}
//

}
