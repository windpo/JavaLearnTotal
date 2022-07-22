package HSPjavaLearn_threadLearn.ticket;

/**
 * @author 风之诗
 * @version 1.0
 * 使用多线程，模拟三个窗口同时售票100张,未使用同步机制，出现多售票的问题
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

class SellTicket01 implements Runnable {
    //static，所有类共享该变量
    private static int sticketNum = 100;

    /**
     * 问题：当三个线程休眠过后同时进行判断/售卖工作时，会出现两个窗口同时卖一张票，或者当票卖完了还在卖的情况
     */
    @Override
    public void run() {
        while (true) {

            if (sticketNum <= 0) {
                System.out.println("售票完成");
                break;
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + " 剩余票数=" + (--sticketNum));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}