package javaLearn_chapter6.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator中的静态方法
 *
 * ?????：以后再来理解
 * Comparator接口包含很多方便的静态方法来创建比较器。这些方法可以用lambda表达式或方法引用
 *  Comparator中的静态方法：
 *  1、comparing：将comparator中的参数来作为比较的依据，可以传入多个值，中间用逗号隔开来
 *  2、thenComparing：跟在comparing方法之后，用来作为comparing比较之后的比较依据
 * @author 风之诗
 * @version 1.0
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0]=new Person("Crack",10);
        people[1]=new Person("Alice",200);
        people[2]=new Person("Atomatic Jim",3000);
        for (Person p :
                people) {
            System.out.println(p);
        }
        System.out.println("========");
        //静态comparing方法取一个"键提取器"，它将类型T映射为一个可比较的类型（如String）。对要比较的类型应用这个函数，然后对返回的键完成比较
        Arrays.sort(people,Comparator.comparing(Person::getName));
        for (Person p :
                people) {
            System.out.println(p);
        }
        //把比较器与thenComparing方法串起来,先比较工资，再比较姓名
        Arrays.sort(people,Comparator.comparing(Person::getSalary).thenComparing(Person::getName));
        //根据人名长度完成比较，传入两类值，Person.getName以及Integer.compare
        Arrays.sort(people,Comparator.comparing(Person::getName,(s,t)->Integer.compare(s.length(),t.length())));
        //方法二:直接将p中的name中的长度作为参数来比较
        Arrays.sort(people,Comparator.comparingInt(p->p.getName().length()));
    }
}
class Person{
    private String name;
    private double salary;
    public Person(String name,double salary) {
        this.name = name;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
