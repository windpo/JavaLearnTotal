package java_homework.ATMdesign;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * @author 风之诗
 */
public class Login extends JFrame{
    //登录名以及账户
    private JTextField logName ;
    private JPasswordField Password;
    private Account account;
    /**
     * 构造方法，初始化登录窗口
     */
    public Login(Account account) {
        this.account=account;
        Container contentPane=getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        /**
         * 设置图片
         */
        JPanel picturePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {  //paintComponent方法会自动执行，在构造方法后
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("images/Child.jpg");
                g.drawImage(icon.getImage(), 0, 0,
                        getWidth(), getHeight(), icon.getImageObserver());
            }
        };

        //设置背景
        JPanel rightPanel = new JPanel(new GridLayout(6, 1));
        rightPanel.setBackground(new java.awt.Color(255,255,255));

        /**
         * 右边按钮
         */
        JPanel logPanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel wordLabel1 = new JLabel("", JLabel.CENTER);
        JLabel wordLabel = new JLabel("璃月至冬银行", JLabel.CENTER);
        wordLabel.setFont(new Font("黑体",Font.BOLD,17));
        JLabel logLabel = new JLabel("卡   号：");
        JLabel PasswordLabel = new JLabel("密   码：");
        logName = new JTextField(15);
        Password = new JPasswordField(15);
        JButton logButton = new JButton("登陆");
        JButton exitButton = new JButton("退出");
         JButton refactButton = new JButton("修改密码");

        logPanel.add(logLabel);
        logPanel.add(logName);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(Password);
        buttonPanel.add(logButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(refactButton);

        logPanel.setOpaque(false);
        PasswordPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        rightPanel.add(wordLabel1);
        rightPanel.add(wordLabel);
        rightPanel.add(logPanel);
        rightPanel.add(PasswordPanel);
        rightPanel.add(buttonPanel);

        /**
         * 登录按钮的功能实现
         */
        logButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(logName.getText().equals(account.getID()) &&
                        new String(Password.getPassword()).equals(account.getPassword())) {
                    JOptionPane.showMessageDialog(null, " 登陆成功",
                            "", JOptionPane.PLAIN_MESSAGE);
                    new ATMUI(account);
                    dispose();
                }
                else if(logName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空",
                            "",JOptionPane.ERROR_MESSAGE);
                    clearAndFocus();
                }
                else if(new String(Password.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "密码不能为空",
                            "", JOptionPane.ERROR_MESSAGE);
                    clearAndFocus();
                }
                else if(!logName.getText().equals(account.getID())) {
                    JOptionPane.showMessageDialog(null, "用户名错误",
                            "", JOptionPane.ERROR_MESSAGE);
                    clearAndFocus();
                }
                else if(!(new String(Password.getPassword()).equals(account.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "密码错误",
                            "", JOptionPane.ERROR_MESSAGE);
                    clearAndFocus();
                }

            }
        });
        /**
         * 修改密码功能
         */
        refactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Modify();
            }
        });
        /**
         * 离开按钮的功能实现
         */
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(picturePanel);
        add(rightPanel);
        initJFrame("银行登录系统");
    }


    /**
     * 初始化界面
     * @param title
     */
    private void initJFrame(String title){
        setTitle(title);
        Image icon = Toolkit.getDefaultToolkit().getImage("images/Child.jpg");
        setIconImage(icon);
        setSize(460,230);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void clearAndFocus() {
        logName.setText("");
        Password.setText("");
        logName.requestFocus();
    }

    /**
     * 该类为内部类，用来实现修改密码的界面以及功能
     */
    class Modify extends JFrame implements ActionListener{
        JButton jb1, jb2, jb3;  //按钮
        JPanel jp1,jp2,jp3, jp4;        //面板
        JPasswordField jtf1,jtf2;   //文本框
        JLabel jlb1, jlb2, jlb3; //标签

        String name = "123";   //账号密码
        String pwd = "123";
        String countname;

        public Modify() {
            // TODO Auto-generated constructor stub
            jb1 = new JButton("确定");
            jb2 = new JButton("重置");
            //设置按钮监听
            jb1.addActionListener(this);
            jb2.addActionListener(this);

            jp1 = new JPanel();  //创建面板
            jp2 = new JPanel();
            jp3 = new JPanel();

            jlb1 = new JLabel("    新密码");  //添加标签
            jlb2 = new JLabel("重复密码");

            jtf1 = new JPasswordField(10);  //创建文本框
            jtf2 = new JPasswordField(10);

            //加入面板中
            jp1.add(jlb1);
            jp1.add(jtf1);

            jp2.add(jlb2);
            jp2.add(jtf2);

            jp3.add(jb1);
            jp3.add(jb2);

            //将JPane加入JFrame中
            this.add(jp1);
            this.add(jp2);
            this.add(jp3);

            //设置布局
            this.setTitle("用户登录");
            this.setLayout(new GridLayout(3,1));  //利用网格布局
            this.setSize(300, 200);   //设置窗体大小
            this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

            this.setVisible(true);  //设置可见
            this.setResizable(false);   //设置不可拉伸大小
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand()=="确定")
            {

                try {
                    modify();  //进行信息核对
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if (e.getActionCommand()=="重置")
            {
                clear();   //清楚信息
            }

        }

        private void modify() throws IOException {
            // TODO Auto-generated method stub
            if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty())  //判断信息是否为空
            {
                JOptionPane.showMessageDialog(null, "信息未填写完成！","消息提示",JOptionPane.WARNING_MESSAGE);
            }
            else if (jtf1.getText().equals(jtf2.getText()))
            {
                account.setPassword(jtf1.getText());   //调用account的setPassword()函数更新密码
                JOptionPane.showMessageDialog(null, "修改成功！","消息提示",JOptionPane.WARNING_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "2次密码不一致，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
                clear();
            }

        }
        //清空密码框
        private void clear()
        {
            // TODO Auto-generated method stub
            jtf1.setText("");    //设置为空
            jtf2.setText("");
        }
    }
}



