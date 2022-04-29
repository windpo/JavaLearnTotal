package javaLearn_chapter6.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * 用4种方法实现Timer定时器
 *  1、内部类：见InnerClassTest.java
 *  2、局部内部类：在方法中定义一个内部类来实现ActionListener
 *  3、匿名内部类：简化局部内部类，直接实现AciontListener
 *  4、lambda表达式：利用lambda表达式实现ActionListenner接口（函数式接口）
 * @author 风之诗
 * @version 1.0
 */
public class FourTypesOfInner {
    public static void main(String[] args) {
        TalkingClock2 talkingClock2 = new TalkingClock2();
        talkingClock2.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}

/**
 * 方法二：局部内部类实现
 */
//class TalkingClock2{
//    public void start(int interval,boolean beep){
//        class TimePrinter implements ActionListener{
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("At the time,the time is"
//                + Instant.ofEpochMilli(e.getWhen()));
//                if(beep){
//                    Toolkit.getDefaultToolkit().beep();
//                }
//            }
//        }
//        TimePrinter timePrinter = new TimePrinter();
//        new Timer(interval,timePrinter).start();
//    }
//}
/**
 * 方法三：匿名内部类实现
 */
//class TalkingClock2{
//    public void start(int inverval,boolean beep){
//        ActionListener actionListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("At the tone,the time is"
//                +Instant.ofEpochMilli(e.getWhen()));
//                if(beep){
//                    Toolkit.getDefaultToolkit().beep();
//                }
//            }
//        };
//        new Timer(inverval,actionListener).start();
//    }
//}
/**
 * 方法四：lambda表达式实现（最简单)
 */
class TalkingClock2{
    public void start(int inverval,boolean beep){
        new Timer(inverval,e -> {
            System.out.println("At the tone,the time is"+Instant.ofEpochMilli(e.getWhen()));
            if(beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }).start();
    }
}
