package HSPjavaLearn_threadLearn.method;

/**
 * @author 风之诗
 * @version 1.0
 * 线程常用方法：插队
 */
public class ThreadMethod2 {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new T2());
        thread.start();
        for (int i = 1; i <= 20; i++) {
            System.out.println("主线程（小弟）吃了"+i+"个包子");
            Thread.sleep(1000);
            if(i==5){
                System.out.println("主线程（小弟）让子线程（老大）先吃");
                thread.join();
                System.out.println("子线程（老大）吃完了，主线程（小弟）继续吃");
            }
        }
    }
}
class T2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("子线程（老大）吃了"+i+"个包子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
