package HSPjavaLearn_threadLearn.exit;

/**
 * @author 风之诗
 * @version 1.0
 * 使用通知方式 在main线程控制 子线程t1线程的结束
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        final T t = new T();
        new Thread(t).start();

        //先让主线程休眠10s，再通知t1线程退出
        Thread.sleep(10*1000);

        //如果希望main线程去控制t1线程的终止，必须修改loop
        //让t1退出run方法，从而终止t1线程--->通知方式
        t.setLoop(false);
    }
}

class T implements Runnable{
    private int count=0;
    //设置一个控制变量，以便我们能在外部主线程控制该线程的结束
    private boolean loop=true;
    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中..."+(++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
