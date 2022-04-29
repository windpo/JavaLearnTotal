package javaLearn_chapter6.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * 内部类的使用演示
 *     1、内部类用来为外面的类提供一些代码块的实现（比如继承一些接口实现一些特定功能），它含有外部类的引用，能直接使用外部类的数据
 *     2、现在经常用lambda表达式在这些方面代替内部类
 * @author 风之诗
 * @version 1.0
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
class TalkingClock{
    private int interval;
    private boolean beep;

    /**
     * Constructs of TalkingClock
     * @param interval  每隔一段时间执行的信息
     * @param beep  是否响铃
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * 执行计时器
     * 局部内部类：在一个方法中局部地定义这个内部类，局部类的作用域仅在这个方法之中
     */
    public void start(){
        TimePrinter timePrinter = new TimePrinter();
        //其中interval为外部类的私有变量，用来设置打印的间隔时间
        new Timer(interval,timePrinter).start();
    }
    public class TimePrinter implements ActionListener{
        /**
         * 打印目前时间以及判断是否响铃
         *      其中beep为外部类的私有变量
         * @param e 记录事件具体信息
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At rhe tone,the time is"
                    + Instant.ofEpochMilli(e.getWhen()));
            if (beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}