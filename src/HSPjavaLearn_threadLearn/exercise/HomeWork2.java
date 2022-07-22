package HSPjavaLearn_threadLearn.exercise;

/**
 * @author 风之诗
 * @version 1.0
 * 两个用户分别从同一张卡上取钱（总额：10000）；每次取1000，当余额不足时，就不能取款了；不能出现超取的现象
 * 线程同步问题
 */
public class HomeWork2 {
    public static void main(String[] args) {
        //保证两个线程的锁使用的是同一个this对象
        final T t = new T();
        final Thread thread1 = new Thread(t);
        final Thread thread2 = new Thread(t);
        thread1.setName("A");
        thread2.setName("B");
        thread1.start();
        thread2.start();
    }
}

class T implements Runnable {
    private int accountNum = 10000;

    @Override
    public void run() {
        while (true) {
            //同步，保证只有一个线程操作
            synchronized (this) {
                if (accountNum < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                accountNum -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出" + 1000 + "块钱" + ",剩余：" + accountNum);
            }
            //休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}