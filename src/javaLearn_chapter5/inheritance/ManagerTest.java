package javaLearn_chapter5.inheritance;

/**
 * @author 风之诗
 * 1、继承
 * 2、多态
 * 3、对象的强转：当一个父类接受了子类对象，则无法调用子类对象方法\调用的为父类的方法，如果此时我们想把它当子类对象使用，则需要使用类类型的强转
 *      例：
 *      employees数组为父类的数组，接受了一个子类manager对象。
 *      employees[0].setBonus(100);  错！父类类型不能调用子类对象的方法
 *
 *         if(employees[0] 1 Manager){//条件判断，判断employees是否为Manager的实例对象
 *             ((Manager)employees[0]).setBonus(100); 对！将父类的类型转化为子类类型
 * 4、final字段：
 *      final修饰类：类无法被继承
 *      final修饰方法：方法无法被子类重写
 *      final修饰变量：常量
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 8000, 1987, 12, 15);
        boss.setBonus(500);
        //使用一个对象数组来储存一系列对象
        Employee[] employees = new Employee[3];
        employees[0]=boss;
        //多态：程序中的超类对象任何时候都能使用子类对象替换
        //      1、不能调用子类对象方法（除非强转为子类）
        //employees[0].setBonus(100);  错！
//        if(employees[0] instanceof Manager){//条件判断，判断employees是否为Manager的实例对象
//            ((Manager)employees[0]).setBonus(100);
//        }
        //      2、调用子类父类共有方法，以子类方法为准(除非强转为父类)
        employees[1]=new Employee("Harry",50000,1987,12,15);
        employees[2]=new Employee("Tommy",40000,1990,3,15);
        //多态中的特性：当父类接收了一个子类对象时，若子类重写了方法，调用该方法会调用子类重写的方法
        for (Employee e :
                employees) {
            System.out.println("name="+e.getName()+",salary="+e.getSalary());
        }
    }
}
