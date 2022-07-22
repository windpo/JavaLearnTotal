package HSPjavaLearn_threadLearn.threaduse;

/**
 * @author 风之诗
 * @version 1.0
 * 演示通过实现Runnable接口的方法开启线程
 */
public class Thread02 {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Dog());
        //底层使用代理模式 :Thread类中含有一个Runnable的属性 可以接收一个实现了Runnable接口的实现类，再通过Thread类中的start方法开启线程
        //先创建一个Thread对象，将dog对象（实现Runnable）放进去，再调用start
        thread.start();
    }
}

class Dog implements Runnable{
    int count=0;
    //通过实现Runnable接口，开发线程
    @Override
    public void run() {
        while (true){
            System.out.println("小狗汪汪叫...hi"+(++count)+" 线程名称="+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count==10){
                break;
            }
        }

    }
}
