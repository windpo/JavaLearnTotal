package javaLearn_chapter5.abstractclasses;

/**
 * @author 风之诗
 * 抽象类以及抽象方法:
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

    }
}
