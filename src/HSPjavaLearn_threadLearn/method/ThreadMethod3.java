package HSPjavaLearn_threadLearn.method;

/**
 * @author 风之诗
 * @version 1.0
 * 演示将一个用户线程设置为守护线程(监管其它线程，或者获取其它线程的信息)
 */
public class ThreadMethod3 {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new MyDaemenThread());
        //如果我们希望当main线程结束后，子线程自动结束，只需要将子线程设置为守护线程即可
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("奶泡在吃晚饭");
            Thread.sleep(1000);
        }
    }
}
class MyDaemenThread implements Runnable{
    @Override
    public void run() {
        //无限循环
        while (true){
            System.out.println("hanser和三无在直播聊天哈哈哈~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
