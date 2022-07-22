package java_homework.frameoflogin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author 风之诗
 */
public class Login extends JFrame{
    private JTextField logName ;
    private JPasswordField Password;
    public Login(String title) {
        Container contentPane=getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));


        JPanel picturePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {  //paintComponent方法会自动执行，在构造方法后
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("images/机器猫.jpg");
                g.drawImage(icon.getImage(), 0, 0,
                        getWidth(), getHeight(), icon.getImageObserver());
            }
        };


        JPanel rightPanel = new JPanel(new GridLayout(6, 1));
        rightPanel.setBackground(new java.awt.Color(255,255,255));

        JPanel logPanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel wordLabel1 = new JLabel("", JLabel.CENTER);
        JLabel wordLabel = new JLabel("Java课程学习小组", JLabel.CENTER);
        wordLabel.setFont(new Font("黑体",Font.BOLD,17));
        JLabel logLabel = new JLabel("用户名：");
        JLabel PasswordLabel = new JLabel("密   码：");
        logName = new JTextField(15);
        Password = new JPasswordField(15);
        JButton logButton = new JButton("登陆");
        JButton exitButton = new JButton("退出");

        logPanel.add(logLabel);
        logPanel.add(logName);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(Password);
        buttonPanel.add(logButton);
        buttonPanel.add(exitButton);

        logPanel.setOpaque(false);
        PasswordPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        rightPanel.add(wordLabel1);
        rightPanel.add(wordLabel);
        rightPanel.add(logPanel);
        rightPanel.add(PasswordPanel);
        rightPanel.add(buttonPanel);

        logButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(logName.getText().equals("Java") &&
                        new String(Password.getPassword()).equals("2022")) {
                    JOptionPane.showMessageDialog(null, " 登陆成功",
                            "", JOptionPane.PLAIN_MESSAGE);
                    new MyFirstGUI();
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
                else if(!logName.getText().equals("Java")) {
                    JOptionPane.showMessageDialog(null, "用户名错误",
                            "", JOptionPane.ERROR_MESSAGE);
                    clearAndFocus();
                }
                else if(!new String(Password.getPassword()).equals("2022")) {
                    JOptionPane.showMessageDialog(null, "密码错误",
                            "", JOptionPane.ERROR_MESSAGE);
                    clearAndFocus();
                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(picturePanel);
        add(rightPanel);
        initJFrame(title);
    }

    public static void main(String[] args) {
        new Login("登陆");
    }

    private void initJFrame(String title){
        setTitle(title);
        Image icon = Toolkit.getDefaultToolkit().getImage("images\\机器猫.jpg");
        setIconImage(icon);
        setSize(480,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void clearAndFocus() {
        logName.setText("");
        Password.setText("");
        logName.requestFocus();
    }
}
