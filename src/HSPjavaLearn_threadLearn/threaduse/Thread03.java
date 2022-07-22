package HSPjavaLearn_threadLearn.threaduse;

/**
 * @author 风之诗
 * @version 1.0
 * 演示创建多个线程
 */
public class Thread03 {
    public static void main(String[] args) {
        new Thread(new T1()).start();
        new Thread(new T2()).start();
    }
}

class T1 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello,world");
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}

class T2 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi");
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                break;
            }
        }
    }
}