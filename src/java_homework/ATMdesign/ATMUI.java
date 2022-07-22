package java_homework.ATMdesign;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author 风之诗
 * @version 1.0
 */

public class ATMUI extends JFrame{
    //设置计数器
    private JButton bt1,bt2,bt3;
    private final JTextArea ta;
    private Account account=new Account();
    /**
     * 在构造方法里直接调用initJFrame来初始化窗体
     * @throws HeadlessException
     */
    public ATMUI(Account account) throws HeadlessException {
        //初始化account对象
        this.account=account;
        //2、窗体的内容面板设置
        final Container contentPane = getContentPane();

        //3、创建组件对象，并加入内容面板
        bt1 = new JButton("查询余额");
        bt2 = new JButton("存入金额");
        bt3 = new JButton("取出金额");

        final JPanel northPanl = new JPanel();
        northPanl.add(bt1);
        northPanl.add(bt2);
        northPanl.add(bt3);
        contentPane.add(northPanl,BorderLayout.NORTH);

        ta = new JTextArea(10, 20);
        ta.setFont(new Font("黑体",Font.BOLD,40));
        ta.setBackground(Color.GREEN);
        contentPane.add(new JScrollPane(ta));

        /**
         * 组件对象的事件处理
         */
        //1、查询余额
        bt1.addActionListener(e -> {
            try {
                ta.append(String.valueOf(account.getDeposit())+"\n");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
        //2、存入余额
        bt2.addActionListener(e -> {
            new Transfer("1");
        });
        //3、取出余额
        bt3.addActionListener(e -> {
            new Draw("2");
        });

        //1、初始化
        initJFrame("ATM系统",480,320, "images/机器猫.jpg",true,
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



    public static void main(String[] args) {
        new ATMUI(new Account());
    }

    /**
     * 该类实现一个转账页面
     */
    class Transfer extends JFrame implements ActionListener {
        String countname;
        JButton jb1, jb2;  //按钮
        JLabel jlb1; //标签
        JTextField jta1;    //文本框

        public Transfer(String countname) {
            this.countname = countname;

            // TODO Auto-generated constructor stub
            jb1 = new JButton("确定");
            jb2 = new JButton("重置");
            //设置按钮监听
            jb1.addActionListener(this);
            jb2.addActionListener(this);


            jlb1 = new JLabel("请输入存入金额：");  //添加标签

            //创建文本框
            jta1 = new JTextField();   //存储金额


            //设置布局
            this.setTitle("存款");
            this.setLayout(null);
            this.setSize(300, 300);

            //创建对方账户的标签

            //存入标签和文本框
            jlb1.setBounds(20, 80, 200, 20);
            jta1.setBounds(20, 110, 250, 50);
            jta1.setFont(new java.awt.Font("Dialog", 0, 15));

            //确定和重置按钮
            jb1.setBounds(60, 180, 62, 28);
            jb2.setBounds(160, 180, 62, 28);


            this.add(jlb1);
            this.add(jta1);
            this.add(jb1);
            this.add(jb2);

            this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

            this.setVisible(true);  //设置可见
            this.setResizable(false);    //设置不可拉伸大小

        }

        //清空账号和密码框
        private void clear() {
            // TODO Auto-generated method stub
            jta1.setText("");    //设置为空

        }

        //存款操作实现
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            final Integer depositeNum = Integer.valueOf(jta1.getText());
            if (e.getActionCommand() == "确定") {
                if (jta1.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
                }
                else if(depositeNum<0){
                    JOptionPane.showMessageDialog(null, "取款金额小于0","消息提示",JOptionPane.WARNING_MESSAGE);
                }
                    else {
                    try {
                        account.addDeposit(depositeNum);
                        JOptionPane.showMessageDialog(null, "存储成功！","消息提示",JOptionPane.WARNING_MESSAGE);
                        dispose();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (e.getActionCommand() == "重置") {
                clear();
            }

        }
    }

    class Draw extends JFrame implements ActionListener {
        String countname;
        JButton jb1, jb2;  //按钮
        JLabel jlb1; //标签
        JTextField jta1;    //文本框

        public Draw(String countname) {
            this.countname = countname;

            // TODO Auto-generated constructor stub
            jb1 = new JButton("确定");
            jb2 = new JButton("重置");
            //设置按钮监听
            jb1.addActionListener(this);
            jb2.addActionListener(this);


            jlb1 = new JLabel("请输入取出金额：");  //添加标签

            //创建文本框
            jta1 = new JTextField();   //转出金额


            //设置布局
            this.setTitle("取款");
            this.setLayout(null);
            this.setSize(300, 300);

            //创建对方账户的标签

            //存入标签和文本框
            jlb1.setBounds(20, 80, 200, 20);
            jta1.setBounds(20, 110, 250, 50);
            jta1.setFont(new java.awt.Font("Dialog", 0, 15));

            //确定和重置按钮
            jb1.setBounds(60, 180, 62, 28);
            jb2.setBounds(160, 180, 62, 28);


            this.add(jlb1);
            this.add(jta1);
            this.add(jb1);
            this.add(jb2);

            this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

            this.setVisible(true);  //设置可见
            this.setResizable(false);    //设置不可拉伸大小

        }

        //清空账号和密码框
        private void clear() {
            // TODO Auto-generated method stub
            jta1.setText("");    //设置为空

        }

        //存款操作实现
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            final Integer value = Integer.valueOf(jta1.getText());
            if (e.getActionCommand() == "确定") {
                if (jta1.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
                }
                else if(value%100!=0){
                    JOptionPane.showMessageDialog(null, "取款金额不为100的倍数","消息提示",JOptionPane.WARNING_MESSAGE);
                }
                else if(value<0){
                    JOptionPane.showMessageDialog(null, "取款金额为负数","消息提示",JOptionPane.WARNING_MESSAGE);
                }
                else if(value>5000){
                JOptionPane.showMessageDialog(null, "取款总额大于5000元","消息提示",JOptionPane.WARNING_MESSAGE);
                }else if((value-value)<0){
                JOptionPane.showMessageDialog(null, "余额不足","消息提示",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    try {
                        account.drawMoney(value);
                        JOptionPane.showMessageDialog(null, "取款成功！","消息提示",JOptionPane.WARNING_MESSAGE);
                        dispose();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (e.getActionCommand() == "重置") {
                clear();
            }

        }
    }
}
