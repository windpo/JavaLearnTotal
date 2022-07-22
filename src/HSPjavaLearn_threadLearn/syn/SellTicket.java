package HSPjavaLearn_threadLearn.syn;

/**
 * @author 风之诗
 * @version 1.0
 * 使用同步方法来实现多个窗口售票
 */
public class SellTicket {
    public static void main(String[] args) {
        //测试
        final SellTicket01 sellTicket01 = new SellTicket01();
        new Thread(sellTicket01).start();//第一个线程窗口
        new Thread(sellTicket01).start();//第二个线程窗口
        new Thread(sellTicket01).start();//第三个线程窗口
    }
}

//实现接口方式，使用synchronized实现线程同步
class SellTicket01 implements Runnable {
    //static，所有类共享该变量
    private static int sticketNum = 100;
    private static boolean loop = true;

    /**
     * 1、private static synchronized void m1(){}的锁是加在SellTicket01.class对象上的
     * 2、如果在静态方法中，实现一个同步代码块，锁应加在当前类本身
     */
    private static synchronized void m1() {

    }

    private static void m2() {
        synchronized (SellTicket01.class) {
            System.out.println("m2");
        }
    }

    /**
     * 1、private synchronized void sell()为一个同步方法，此时锁在this对象上
     * 2、也可以在代码块上写synchronize，同步代码块,互斥锁还是在this对象上
     * 3、还可以用其它对象来上锁（要求同一个对象）
     */
    private synchronized void sell() {//使用同步方法，在同一时刻，只能有一个线程来执行sell方法
        //或者synchronized (this){
        if (sticketNum <= 0) {
            System.out.println("售票完成");
            loop = false;
            return;
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + " 剩余票数=" + (--sticketNum));

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // }
    }

    @Override
    public void run() {
        while (loop) {
            sell();//sell为一个同步方法，多个线程都存在时，仅一个线程进入去执行该方法
        }

    }
}