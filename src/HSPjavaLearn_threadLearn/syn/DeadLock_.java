package HSPjavaLearn_threadLearn.syn;

/**
 * @author 风之诗
 * @version 1.0
 * 演示线程死锁问题
 */
public class DeadLock_ {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(new T(true));
        final Thread thread2 = new Thread(new T(false));
        thread1.setName("A");
        thread2.setName("B");
        thread1.start();
        thread2.start();
    }
}
class T implements Runnable{
    static Object o1=new Object();//保证多线程，共享一个对象，这里使用static
    static Object o2=new Object();
    boolean flag;

    public T(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //逻辑分析
        //1、如果flag为 T，线程A 首先持有o1对象锁，然后尝试去获得o2对象锁
        //2、如果线程A得不到o2对象锁，就会blocked
        //3、如果flag为 F，线程B 首先持有o1对象锁，然后尝试去获得o2对象锁
        //4、如果线程B得不到o1对象锁，就会blocked
        if(flag){
            synchronized (o1){//对象互斥锁，下面就是同步代码
                System.out.println(Thread.currentThread().getName()+"进入1");
                synchronized (o2){//这里获得里对象的监视权
                    System.out.println(Thread.currentThread().getName()+"进入2");
                }
            }
        }else {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"进入3");
                synchronized (o1){//这里获得里对象的监视权
                    System.out.println(Thread.currentThread().getName()+"进入4");
                }
            }
        }
    }
}
