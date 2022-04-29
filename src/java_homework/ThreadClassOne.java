package java_homework;

/**
 * @author 风之诗
 * @version 1.0
 *  两种方法：
 *      一、继承`Thread`类；
 *      我们可以使用继承`Thread`类的方式来创建一个线程。
 *      创建一个类来继承`Thread`类，重写父类的`run`方法，就实现了创建我们自己的线程了。之后调用线程的`start`方法，就算是开启了一个线程了。
 *      二、实现`Runnable`接口。
 *      最简单创建线程的方法就是实现一个`Runnable`接口了，实际上所有的线程都是直接或者间接实现了`Runnable`接口的，
 *      上一个例子中`Thread`类其实就实现了`Runnable`接口。
 *
 *
 */
public class ThreadClassOne extends Thread{
    private String name;

    public ThreadClassOne(String name){
        super();
        this.name=name;
    }
    @Override
    public void run(){
        for(int i=1;i<10;i+=2){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        final ThreadClassOne t1 = new ThreadClassOne("a");
        t1.run();
        final ThreadClassTwo threadClassTwo = new ThreadClassTwo("b");
        threadClassTwo.start();
    }
}

class ThreadClassTwo implements Runnable{
    private String name;
    private Thread mythread;

    public ThreadClassTwo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i+=2) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
    public void start(){
        if(mythread==null){
            mythread = new Thread(this, name);
        }
        mythread.start();
    }

}
