package java_homework.frameoflogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 风之诗
 * @version 1.0
 */

public class MyFirstGUI extends JFrame implements ActionListener{
    //设置计数器
    private static int count=1;
    private JButton bt1,bt2,bt3;
    private final JTextArea ta;
    /**
     * 在构造方法里直接调用initJFrame来初始化窗体
     * @throws HeadlessException
     */
    public MyFirstGUI() throws HeadlessException {
        //2、窗体的内容面板设置
        final Container contentPane = getContentPane();

        //3、创建组件对象，并加入内容面板
        bt1 = new JButton("为高考助力");
        final ImageIcon img1 = new ImageIcon("images/BUG1.GIF");
        final ImageIcon img2 = new ImageIcon("images/BUG2.GIF");
        bt2 = new JButton(img1);
        bt2.setRolloverIcon(img2);

        bt3 = new JButton("退出");

        final JPanel northPanl = new JPanel();
        northPanl.add(bt1);
        northPanl.add(bt2);
        northPanl.add(bt3);
        contentPane.add(northPanl,BorderLayout.NORTH);

        ta = new JTextArea(10, 20);
        ta.setFont(new Font("黑体",Font.BOLD,50));
        ta.setBackground(Color.GREEN);
        contentPane.add(new JScrollPane(ta));

        //4、组件对象的事件处理
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);

        //1、初始化
        initJFrame("我的窗体",480,320, "images/机器猫.jpg",true,
                JFrame.EXIT_ON_CLOSE);
    }
    private void initJFrame(String title,int width,int height,String titleFileName,boolean isVisible,int closeMode){
        setTitle(title);
        setSize(width, height);
        final Image icon = Toolkit.getDefaultToolkit().getImage(titleFileName);
        setIconImage(icon);
        setVisible(isVisible);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(closeMode);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==bt1){
                ta.setText(ta.getText()+"\nbt1被按下！");
            }
            if(e.getSource()==bt2){
                ta.setText(ta.getText()+"\nbt2被按下！");
            }
            if(e.getSource()==bt3){
                JOptionPane.showMessageDialog(null,"Bye!");
                System.exit(0);
            }
        }

    public static void main(String[] args) {
        new MyFirstGUI();
    }
}
