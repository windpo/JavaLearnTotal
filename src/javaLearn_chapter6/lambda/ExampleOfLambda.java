package javaLearn_chapter6.lambda;

import java.util.function.IntConsumer;

/**
 * @author 风之诗
 * @version 1.0
 * 演示使用lambda表达式来实现一些功能（重复执行一些特定的动作）
 * 小知识：@FunctionalInterface注解能将自己写的仅含一个抽象方法的接口标记为函数式接口
 */
public class ExampleOfLambda {
    /**
     * 重复执行动作n次
     * @param n
     * @param action
     */
    public static void repeat(int n,Runnable action){
        for(int i=0;i<n;i++){
            action.run();
        }
    }

    /**
     * 重复执行动作n次，并向动作实时返回当前进行的步骤
     * @param n
     * @param action
     */
    public static void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
    public static void main(String[] args) {
        //传入runnable一个lambda表达式实现函数式接口，实现重复执行的动作
        repeat(10,()-> System.out.println("Hello World"));
        repeat(10,i-> System.out.println("Countdown:"+(9-i)));
    }
}
