package javaLearn_chapter6.clone;

/**
 * @author 风之诗
 * @version 1.0
 * clone克隆方法、深拷贝与浅拷贝
 *  对象克隆
 *  当我们在将一个对象赋值给另一个对象时，要想创造一个新的对象，而不是仅仅复制引用，就需要实现Object类中的Clone方法
 *  但是Clone方法在Object中为protected修饰，无法直接调用，必须在子类中重写一遍
 *      1、Cloneable接口
 *          当我们在实现克隆方法时，必须让类实现Cloneable接口，才能正确实现该类的克隆方法，否则将会抛出异常，Cloneable接口仅仅作为标记接口，无实际的方法
 *      2、深拷贝和浅拷贝
 *          我们在实现类的克隆方法时，必须要考虑该类中所含有的数组、对象类型等，这些需要新建一个空间，需要用clone方法对它们进行克隆
 *      3、克隆方法的实现
 *          （1）、实现Cloneable接口
 *          （2）、重新定义clone方法，指定为public修饰符
 *          （3）、若只需浅拷贝，那么仅仅调用Object类中的克隆即可，如果需要对可变实例克隆，则需自己实现
 *
 *          @Override
 *     public Employee clone() throws CloneNotSupportedException {
 *         Employee clone = (Employee) super.clone();
 *         clone.hireDay=(Date) hireDay.clone();
 *         return clone;
 *     }
 *
 */

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("John Q.Public", 50000);
        original.setHireDay(2000,1,1);
        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002,12,31);
        System.out.println("original="+original);
        System.out.println("copy="+copy);
    }
}
