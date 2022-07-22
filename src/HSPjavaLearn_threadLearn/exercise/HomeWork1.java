package HSPjavaLearn_threadLearn.exercise;

import java.util.Scanner;

/**
 * @author 风之诗
 * @version 1.0
 * 开启两个线程，第一个线程循环输出100内的随机数，直到第二个线程读取了”Q“
 *
 * 通知控制线程结束问题
 * 1、如何让一个线程控制另一个线程的退出（通知）
 * 2、如何设置随机数    (int) (Math.random()*100+1)
 * 3、如何优雅的接收Q并判断
 */
public class HomeWork1 {
    public static void main(String[] args) {
        final Thread1 thread1 = new Thread1();
        final Thread2 thread2 = new Thread2(thread1);

        new Thread(thread2).start();
        new Thread(thread1).start();
    }
}

class Thread1 implements Runnable {
    private boolean judge = true;

    /**
     * 线程一：循环打印100以内随机数
     *
     * @param judge 控制线程循环结束与否
     */
    public void setJudge(boolean judge) {
        this.judge = judge;
    }

    @Override
    public void run() {
        while (judge) {
            try {
                //Math.random()返回一个0到1.0的浮点数（左闭右开）,整个式子代表1-100的数
                System.out.println((int) (Math.random() * 100 + 1));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A线程退出");
    }
}

/**
 * 线程二：读取”Q“，当读取到Q时，停止第一个线程（通过通知方式）
 * 1、设置一个线程1的对象值
 * 2、将线程1的对象传入线程2中
 */
class Thread2 implements Runnable {
    //对象属性
    private Thread1 thread1;
    private Scanner scanner = new Scanner(System.in);


    //一定要吧thread1传进去，保证后面thread1.setJudge(false)改变了thread1对象的属性（对象为传指针，普通变量为传值）
    //此方法可以代替c++中的友元变量
    public Thread2(Thread1 thread1) {
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令（Q）表示退出");
            //读取字符串，无论小写q还是大写Q都可以，再转化为char判断
            if ('Q' == (scanner.next().toUpperCase().charAt(0))) {
                //以通知方式结束线程
                thread1.setJudge(false);
                System.out.println("b线程退出");
                break;
            }

        }
    }

}