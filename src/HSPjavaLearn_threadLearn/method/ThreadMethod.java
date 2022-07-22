package HSPjavaLearn_threadLearn.method;

/**
 * @author 风之诗
 * @version 1.0
 * 线程的一些相关方法：
 * thread1.setName("老六")                         设置线程名称
 * thread1.setPriority(Thread.MIN_PRIORITY);      设置线程优先级
 * thread1.start();                               开始线程
 * thread1.interrupt();                           打断子线程（不是停止）
 * Thread.currentThread().getName()               获取当前线程名称
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        final Thread thread1 = new Thread(new T());
        thread1.setName("老六");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();

        //在子线程休眠时，主线程先打印5个hi，然后再打断子线程的休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi"+(i+1));
        }
        System.out.println(thread1.getPriority());
        thread1.interrupt();
    }
}

class T implements Runnable {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子~~~" + i);
            }

            //休眠20s
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中~~~");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //当线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException是捕获到一个中断异常
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}