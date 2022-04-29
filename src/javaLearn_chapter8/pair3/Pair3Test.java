package javaLearn_chapter8.pair3;

import javaLearn_chapter5.inheritance.Employee;
import javaLearn_chapter5.inheritance.Manager;

/**
 * @author 风之诗
 * @version 1.0
 * 演示泛型和通配符的应用
 *  泛型： 是一个形参，可以理解为一个占位符，被使用时，会在程序运行的时候替换成具体的类型，比如替换成String，Integer之类的。
 * 	故：泛型一般用于在设计类的泛型、泛型方法的时使用
 * 	通配符： 是一个实参，这是Java定义的一种特殊类型，比Object更特殊，就像一个无所不能的对象更胜于object。比如List和List是没有父子关系的两个类型，但是List<?> 更似于是所以java中所有对象的的父类。
 * 	故：泛型通配符一般用于想在一个方法中捕获类似"含有一个泛型参数的类Pair<? extends Employee>或者表（List<? super Manager>）"的形式参数
 */
public class Pair3Test {
    public static void main(String[] args) {
        final Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        final Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
        //用一个Pair<Manager>对象来存一对经理
        final Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        //设置一个经理数组
        Manager[] managers={ceo,cfo};

        //用Employee来创建一组结果对象，用result来保存一对结果
        final Pair<Employee> result = new Pair<>();
        minmaxSalary(managers,result);
        System.out.println("MINMAXsalary: first: "+result.getFirst().getName()+", second: "+result.getSecond().getName());
        maxminSalary(managers,result);
        System.out.println("MAXMINsalary: first: "+result.getFirst().getName()+", second: "+result.getSecond().getName());

    }

    /**
     * 打印一对公司的员工
     * 因为要获取值，所以要用通配符？ extends
     * @param p
     */
    public static void printBuddies(Pair<? extends Employee> p){
        final Employee first = p.getFirst();
        final Employee second = p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+"are buddies.");
    }

    /**
     * 获取最小和最大的工资
     * 因为要改变值，所以要用通配符? super
     * @param a
     * @param result
     */
    public static void minmaxSalary(Manager[] a,Pair<? super Manager> result){
        if(a.length==0){
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min.getSalary()>a[i].getSalary()){
                min=a[i];
            }
            if(max.getSalary()<a[i].getSalary()){
                max=a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    /**
     * 获取最大和最小的工资
     * 先获取最小和最大的工资，再进行交换
     * @param a
     * @param result
     */
    public static void maxminSalary(Manager[] a,Pair<? super Manager> result){
        minmaxSalary(a,result);
        PairAlg.swapHelper(result);
    }
}
class PairAlg{
    /**
     * 判断是否为空，可以用Pair<?>，为Pair中的任意类型，
     * @param p
     * @return
     */
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst()==null||p.getSecond()==null;
    }

    /**
     * 通配符?无法进行写操作，泛型可以，所以可以先封装一层通配符来捕获内容，再用泛型方法进行操作，当然也可以用Pair<? super Manager>来代替
     * @param p
     */
    public static void swap(Pair<?> p){
        swapHelper(p);
    }
    public static <T> void swapHelper(Pair<T> p){
        T t=p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
class Pair <T>{
    private T first;
    private T second;

    public Pair(){
        first=null;
        second=null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}