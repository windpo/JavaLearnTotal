package varParameter;

/**
 * @author 风之诗
 *      可变参数细节：
 *      1、可变参数的参数可以有0个到多个
 *      2、可变参数的本质就是数组
 *      3、可变参数的实参可以为数组
 *      4、可变参数可以和非可变参数可以放在一起，但需保证可变参数在参数列表最后
 *      5、一个形参列表中只能有一个可变参数
 */
public class VarParameter02 {
    public static void main(String[] args) {
        //数组声明方式
        //int[] numbers = new int[4];
        //数组声明并初始化方式
        int[] arr={3,4,5};
        T t = new T();
        //3、将数组作为可变参数的实参
        t.f1(arr);
        int num1=1;
        t.add(num1,arr);
    }
}
class T{
    public void f1(int... nums){
        System.out.println("长度=" +nums.length);
    }

    /**
     * 可变参数可以和非可变参数可以放在一起，但需保证可变参数在参数列表最后
     * 而且当它们类型相同时，传入的值首先先接受普通参数，最后再接收可变参数
     * @param a1
     * @param nums
     */
    void add(int a1,int... nums){
        System.out.println("第一个参数="+a1);
        System.out.println("可变参数长度："+nums.length);
    }
}
