package java_abstract;

/**
 * abstract修饰符：抽象类与抽象方法
 * 1、抽象类：
 *      抽象类不能用来实例化对象，在不知道某类的具体方法实现时，声明抽象类，将来对该类进行扩充
 *      一个类不能同时被 abstract 和 final 修饰
 * 2、抽象方法：
 *      抽象方法不能包含内容，类似c语言中的函数声明，先将方法确定，再在子类中实现其方法
 *      抽象方法必须放在抽象类中（抽象类不一定需要抽象方法）
 */
public abstract class People {
    private String name;
    private int age;
    public abstract void eat();//抽象方法，不能含有内容，类似于函数声明，先把方法放在这，再在子类中实现
    public abstract void drink();
}
//继承抽象类，并实现其中的抽象方法
 class Kids extends People{
    @Override
    public  void eat(){
        System.out.println("Eat....");
    }
    @Override
    public void drink(){
        System.out.println("Drink....");
    }
}