package javaLearn_chapter7.logging;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * @author 风之诗
 * @version 1.0
 * 日志的使用
 *  一、选择一个日志记录器
 *      1、在主函数中获得一个记录器(名字设置为主应用包名)
 *      2、在对于有大量日志获得的类，为其增加一个记录器（静态字段）
 *  二、设置记录器默认配置以及处理器配置
 *      1、在main方法中配置记录器
 *      2、在main方法中添加处理器
 *  三、选择记录信息以及记录等级设置
 *      1、记录日志消息提示，如：将sout换成logger.fine("File open dialog canceled")
 *      2、记录异常
 *      3、对用户有意义的消息记录为“INFO”及以上，对程序员有意义的消息记录为”FINE“及以下
 *
 *
 *     实例如下：
 */

/**
 * A modification of the image viewer program that logs various events.
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
        if(System.getProperty("java.util.logging.config.class")==null
        &&System.getProperty("java.util.logging.config.file")==null){
            try{
                //配置日志记录器属性
                Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT=10;
                //为日志添加处理器
                final FileHandler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.horstmann.corejava").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE,
                        "Can`t create log file handler",e);
            }
        }

        EventQueue.invokeLater(()->{
            final WindowHandler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);

            final ImageViewerFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
            frame.setVisible(true);
        });
    }
}

/**
 * The frame that shows the image.
 */
class ImageViewerFrame extends JFrame{
    //基本框架
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=400;

    //获取该类的记录器
    private JLabel label;
    private static Logger logger=Logger.getLogger("com.horstmann.corejava");

    //构造器
    public ImageViewerFrame(){
        //打印日志，进入构造方法
        logger.entering("ImageViewerFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //设置菜单
        final JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        final JMenu menu = new JMenu("File");
        menuBar.add(menu);

        //添加打开选项以及实现打开的方法
        final JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        //实现打开的方法（实现ActionListener接口）
        openItem.addActionListener(new FileOpenListener());

        //添加离开选项以及实现离开的方法
        final JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        //实现离开的方法（实现ActionListener接口）
        //lambda表达式实现函数式接口ActionListener 直接找到接口中所需实现方法的变量(ActionEvent)重写,该变量执行事件的细节
        exitItem.addActionListener((ActionEvent actionEvent)->{
            //记录Exit日志
            logger.fine("Exiting.");
            System.exit(0);
        });
        //匿名内部类重写函数式接口ActionListener
//        exitItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                logger.fine("Exiting.");
//                System.exit(0);
//            }
//        });

        //use a label to display the images
        label=new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame","<init>");
    }

    /**
     * 创建一个私有类实现函数式接口ActionListener，完成打开选项的功能
     */
    private class FileOpenListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //打印日志，进入方法
            logger.entering("ImageViewerFrame.FileOpenListener","actionPerformed",e);

            //set up file chooser
            final JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            //accept all files ending with .gif （使用拦截器实现）
            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif")||f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });

            //show file chooser dialog
            final int r = chooser.showOpenDialog(ImageViewerFrame.this);

            //if image file accepted,set it as icon of the label
            if(r==JFileChooser.APPROVE_OPTION){
                 String name = chooser.getSelectedFile().getPath();
                 logger.log(Level.FINE,"Reading file {0}",name);
                 label.setIcon(new ImageIcon(name));
            } else {
                logger.fine("File open dialog canceled.");
            }
            logger.exiting("ImageViewerFrame.FileOpenListener","actionPerformed");
        }

    }
}
/**
 * A handler for displaying log records in a window.
 */
class WindowHandler extends StreamHandler{
    private  JFrame frame;

    public WindowHandler(){
        frame=new JFrame();
        final JTextArea output = new JTextArea();
        output.setEnabled(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
            @Override
            public void write(byte[] b,int off,int len){
                output.append(new String(b,off,len));
            }
        });
    }

    @Override
    public void publish(LogRecord record){
        if(!frame.isVisible()) {
            return;
        }
        super.publish(record);
        flush();
    }
}

