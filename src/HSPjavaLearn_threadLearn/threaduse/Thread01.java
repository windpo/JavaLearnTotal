package HSPjavaLearn_threadLearn.threaduse;

/**
 * @author 风之诗
 * @version 1.0
 * 演示通过 继承Thread类创建线程以及多线程的机制
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建cat对象，可以当作线程来使用
        final Cat cat = new Cat();
        //启动线程
        cat.start();

        //注意：当main线程启动的为一个子线程 (Thread-0)，主线程不会阻塞，会继续执行
        //这时 主线程和子线程为交替执行
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i="+i+" 线程名="+Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
//1、当一个类继承Thread类，该类就可以当作线程使用
//2、我们将自己的逻辑在run方法中实现
//3、Thread类的run方法 是实现了Runnable接口的run方法，但没有具体实现

class Cat extends Thread{
    int times=0;
    @Override
    //重写run方法，实现自己的业务逻辑
    public void run() {

        while (true) {
            //线程每隔1s打印"喵喵，我是小猫咪"
            System.out.println("喵喵，我是小猫咪"+(++times)+" 线程名="+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //当打印8只后，结束循环,线程执行完毕
            if(times==8){
                break;
            }
        }
    }
}
