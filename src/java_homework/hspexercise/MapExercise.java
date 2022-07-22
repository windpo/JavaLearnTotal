package java_homework.hspexercise;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author 风之诗
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args) {
        final HashMap<String, Employee> map = new HashMap<>(3);
        map.put("1",new Employee("李明",100000));
        map.put("2",new Employee("李华",3000));
        map.put("3",new Employee("李明",150000));
        System.out.println("遍历方式1");
        map.forEach((k,v)->{
            if(v.getSalary()>18000){
                System.out.println(v);
            }
        });
        System.out.println("遍历方式2");
        final Collection<Employee> values = map.values();
        values.forEach((v)->{
            if(v.getSalary()>18000){
                System.out.println(v);
            }
        });
    }
}
class Employee{
    private String name;
    private int salary;

    public Employee( String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
