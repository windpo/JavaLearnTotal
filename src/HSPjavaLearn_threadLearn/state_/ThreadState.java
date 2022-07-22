package HSPjavaLearn_threadLearn.state_;

/**
 * @author 风之诗
 * @version 1.0
 * 演示线程运行状态
 * NEW      刚创建线程
 * Runnable 线程start
 * Blocked  线程阻塞
 * Waiting  等待另一个线程执行完毕（join等）
 * Timed_Waiting    超时等待（sleep等）
 * Terminated   已退出的线程
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new T());
        //输出状态:刚创建，还未启动，为New状态
        System.out.println(thread.getName() + " 状态 " + thread.getState());
        thread.start();

        //创建后，进入Runnable状态
        //当线程未到终点时，输出状态
        while(Thread.State.TERMINATED!=thread.getState()){
            System.out.println(thread.getName() + "状态" + thread.getState());
            //线程暂停，进入TimedWaiting状态
            Thread.sleep(1000);
        }
        //线程运行结束，进入TERMINATED运行状态,输出状态
        System.out.println(thread.getName() + "状态" + thread.getState());
    }
}
class T implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
