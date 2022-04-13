package javaLearn_chapter5.ArrayList;

import javaLearn_chapter5.equals_hashcode_toString.Employee;
import java.util.ArrayList;

/**
 * 通过ArrayList来代替使用数组实现动态数组
 * 实例引用equals_hashcode_toString包下的EqualsTest进行修改
 * @author 风之诗
 * ArrayList的相关操作
 * 1、初始化：通过构造器
 *  var staff = new ArrayList<Employee>();
 *  ArrayList<Employee> staff = new ArrayList<>();
 * 2、预分配空间：加快add操作所需的工作量，不提前分配空间内的元素（区别于数组）
 * var staff = new ArrayList<Employee>(3);
 *         staff.ensureCapacity(3);
 * 3、添加元素（可以插入）
 * staff.add(new Employee("Carl Cracker",75000,1987,12,15));
 * 4、修改得到的元素：
 * staff.set(0,new Employee("Harry Hacker",50000,1989,10,1));
 * 5、得到数组列表内的元素
 * staff.get(0)
 * 6、将数列列表转化为数组
 * staff.toArray()
 * 7、删除元素
 * staff.remove(0);
 * 8、遍历
 * foreach或者fori
 * 9、得到数组列表长度
 * staff.size()
 * 10、删除额外分配的空间到目前的空间大小（确保不会再增加数组列表个数）
 *
 */
public class ArrayListEqualsTest {
    public static void main(String[] args) {
        //ArrayList构造器初始化:注：ArrayList中无法使用基本数据类型，仅能用包装类如：Integer
        var staff = new ArrayList<Employee>();
        staff.add(new Employee("Carl Cracker",75000,1987,12,15));
        staff.add(new Employee("Harry Hacker",50000,1989,10,1));
        staff.add(new Employee("Tony Tester",40000,1990,3,15));
        staff.set(0,new Employee("Harry Hacker",50000,1989,10,1));
        System.out.println(staff.size());
        //给每个人张5%的工资
        for (Employee e :
                staff) {
            e.raiseSalary(5);
        }

        //循环打印
        for (Employee e :
                staff) {
            System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
        }
    }
}
