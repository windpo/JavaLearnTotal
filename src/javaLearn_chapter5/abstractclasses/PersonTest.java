package javaLearn_chapter5.abstractclasses;

/**
 * @author 风之诗
 * 一、抽象类以及抽象方法:
 *      1、抽象方法的使用：为什么要使用抽象类
 *          我们可以把子类的一些共有属性（如名字），以及该属性的get方法放在父类当中。如：student类和employee类都含有名字
 *          但我们想定义一个描述子类的一些属性的方法时，Person中提供不同子类的内容不一样，此时，我们不能在父类当中实现该方法
 *          那么我们就需要一种抽象方法来先定义一个方法，然后在子类中实现
 *      2、抽象类
 *          （1）、类中定义有一个或多个抽象方法的类本身需要定义为抽象类，抽象类可以包含有普通字段和方法
 *          （2）、抽象方法在抽象类中仅仅是声明，并没有具体的实现：类似于c语言中的函数声明
 *          （3）、在子类中必须实现父类中所有的抽象方法，否则就必须将子类定义为抽象类
 *          （4）、抽象类不能实例化，我们不能创建一个抽象类的对象（但可以作为变量接受子类对象）
 *      3、抽象类的使用
 *      见下方代码
 * 二、对象间的比较--->equals方法
 *      1、== 仅仅比较两个对象是否为同一个引用，两者的地址是否相同  如：定义两个Employee的对象1和一个对象2，则两者比较是不相同的
 *      2、Object.equals（）,在我们没有重写，或者java自带类中没有替我们重写时，和1的比较方式相同，均是直接比较两者的引用是否引用的是同一个对象
 *      3、在java中进行比较，我们需要根据比较的类型来选择合适的比较方式，这个时候我们就需要在子类中自己重写equals方法：
 *          @Override
 *     public boolean equals(Object otherObject) {//注意：此处一定要用Object作为参数类型，否则无法覆盖Object方法
 *         //（1）若为同一引用，则两个对象肯定相等
 *         if(this==otherObject){ return true;}
 *         //（2）若比较对象为空，返回false
 *         if(otherObject==null){ return false;}
 *         //（3）如果equals的方法实现需要在子类中改变，用getClass比较，否则用instanceof比较
 *         if(getClass()!=otherObject.getClass()) { return false; }
 *         //（4）转化为相同类型变量
 *         Employee other = (Employee) otherObject;
 *         //（5）定制化需要，比较自己自定义的字段 比如Arrays.equals方法检测对应数组元素是否相等，如果是子类重新定义equals
 *         //则需要在其中包含一个super.equals(other)
 *         return this.getName().equals(other.getName())
 *                 &&this.getSalary()==other.getSalary()
 *                 &&this.getHireDay().equals(other.getHireDay());
 *     }
 *
 */
public class PersonTest {
    public static void main(String[] args) {
        //我们在此处定义了一个抽象父类的数组
        Person[] people = new Person[2];
        //将父类数组分别接受两个子类（多态）
        people[0]=new Employee("Harry Hacker",5000,1989,10,1);
        people[1]=new Student("Maria Morris","computer science");
        //父类自动调用子类重写的方法（多态）
        //为什么此处父类的方法不会被调用？ 因为父类为抽象类，无法实例化，所以变量p永远无法引用Person类的对象，而是引用子类的对象
        for (Person p :
                people) {
            System.out.println(p.getName()+","+p.getDescription());
        }

        //测试重写的equals方法
        Employee employee = new Employee("Harry Hacker",5000,1989,10,1);
        Employee employee1 = new Employee("Harry Hacker",5000,1989,10,1);
        //直接比较
        System.out.println(employee.getClass()==employee1.getClass());//比较两者是否为同一对象，正确
        System.out.println(employee.equals(employee1));
    }
}
