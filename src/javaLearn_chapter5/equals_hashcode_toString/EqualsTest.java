package javaLearn_chapter5.equals_hashcode_toString;

import java.util.ArrayList;

/**
 * @author 风之诗
 *  Object类中的equals  hashCode 以及toSting方法
 *  对象间的比较--->equals方法
 *        1、== 仅仅比较两个对象是否为同一个引用，两者的地址是否相同  如：定义两个Employee的对象1和一个对象2，则两者比较是不相同的
 *        2、Object.equals（）,在我们没有重写，或者java自带类中没有替我们重写时，和1的比较方式相同，均是直接比较两者的引用是否引用的是同一个对象
 *        3、在java中进行比较，我们需要根据比较的类型来选择合适的比较方式，这个时候我们就需要在子类中自己重写equals方法：
 *            @Override
 *       public boolean equals(Object otherObject) {//注意：此处一定要用Object作为参数类型，否则无法覆盖Object方法
 *           //（1）若为同一引用，则两个对象肯定相等
 *           if(this==otherObject){ return true;}
 *           //（2）若比较对象为空，返回false
 *           if(otherObject==null){ return false;}
 *           //（3）如果equals的方法实现需要在子类中改变，用getClass比较，否则用instanceof比较
 *           if(getClass()!=otherObject.getClass()) { return false; }
 *           //（4）转化为相同类型变量
 *           Employee other = (Employee) otherObject;
 *           //（5）定制化需要，比较自己自定义的字段 比如Arrays.equals方法检测对应数组元素是否相等，如果是子类重新定义equals
 *           //则需要在其中包含一个super.equals(other)
 *           return this.getName().equals(other.getName())
 *                   &&this.getSalary()==other.getSalary()
 *                   &&this.getHireDay().equals(other.getHireDay());
 *       }
 *  由对象导出一个整数值---->hashCode方法
 *  返回表示对象值的一个字符串---->toString方法
 *  getClass():返回包含对象信息的类对象
 *  getName():返回类的名字
 *  getSuperclass():返回这个类的超类
 */
public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
        System.out.println("alice1==alice2:"+(alice1==alice2));
        System.out.println("alice1==alice3:"+(alice1==alice3));
        System.out.println("alice1.equals(alice3):"+alice1.equals(alice3));
        System.out.println("alice1.equals(bob):"+alice1.equals(bob));
        System.out.println("bob.toString()"+bob);
        System.out.println("===========");
        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        System.out.println("boss.toString():"+boss);
        System.out.println("carl.equals(boss):"+carl.equals(boss));
        System.out.println("alice1.hashCode():"+alice1.hashCode());
        System.out.println("alice3.hashCode():"+alice3.hashCode());
        System.out.println("bob.hashCode():"+bob.hashCode());
        System.out.println("carl.hashCode():" + carl.hashCode());
    }
}
