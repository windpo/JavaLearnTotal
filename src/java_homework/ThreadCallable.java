package java_homework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author 风之诗
 * @version 1.0
 * 使用Callable和FutureTask实现有返回值的多线程
 * 1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值（该类仅仅为实现了线程执行方法的类，而非一个Thread线程类）；
 * 2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值；
 * 3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程（作为new Thread（）的第一次参数对象）；
 * 4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值
 */
public class ThreadCallable implements Callable<Integer> {
        private int num;

        public ThreadCallable(int num) {
                this.num = num;
        }

        @Override
        public Integer call() throws Exception {
                int result=0,a=1,b=1;
                if(num==1||num==2){
                        result=1;
                }else {
                        for (int i = 0; i < num - 2; i++) {
                                a+=b;
                                b=a-b;
                        }
                        result=a;
                }
                return result;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
                final FutureTask<Integer> future = new FutureTask<>(new ThreadCallable(5));
                new Thread(future,"有返回值的线程").start();
                System.out.println(future.get());
        }
}
