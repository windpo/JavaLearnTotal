package javaLearn_chapter6.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author 风之诗
 * @version 1.0
 * ActionListener接口
 * 程序使用swing中的Timer，将一个可操作的方法封装成对象传入Timer构造方法中，实现每隔一段时间就更新时间并响铃
 *      1、ActionListener接口，传入Timer的对象必须实现该接口，该接口中的actionPerformed方法为Timer每隔一段时间调用的方法
 *      2、ActionEvent e参数，获取事件的一些信息，如目前的时间等
 */
public class TimerTest {
    public static void main(String[] args) {
        TimePrinter timePrinter = new TimePrinter();
        Timer timer = new Timer(1000, timePrinter);
        timer.start();
        //显示一个包含提示消息和ok的对话框，这个对话框位于parent中间，如果parent为null则在屏幕中间
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

    }
}
class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //Instant.ofEpochMilli：得到一个更可读的描述
        System.out.println("At the tone,the time is"+ Instant.ofEpochMilli(e.getWhen()));
        //获取默认工具箱，并且调用响铃方法
        Toolkit.getDefaultToolkit().beep();
    }
}
