package javaLearn_chapter7.logging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 风之诗
 * @version 1.0
 *  记录器
 *  日志打印的基础操作：
 *      一、设置日志级别（默认为INFO以上）
 *          1、logger.setLevel(Level.CONFIG);   将日志等级设置为CONFIG以上
 *          2、logger.setLevel(Level.ALL);     将日志等级设置为所有
 *      二、日志记录方法
 *          1、logger.log(Level.FINE,"First login the website");  第一个参数指定日志级别，第二个参数传入信息
 *          //或者
 *          2、logger.fine("Second login the website");
 *      三、在日志中记录异常
 *          1、//日志打印异常方法1
 *         try {
 *             throw new IOException("输入异常");
 *         } catch (IOException e) {
 *             //getLogger 获取一个记录器，并传入一个名字并打印日志Reading image以及异常
 *             Logger.getLogger("com.myCompany.myapp").log(Level.WARNING,"Reading image",e);
 *         }
 *          2、//日志打印异常方法2 (记录一条FINER级别的日志记录和一条THROW开始的消息)
 *         if(true){
 *             final IOException e = new IOException("第二次输入异常");
 *             logger.throwing("com.mycompany.mylib.Reader","read",e);
 *             throw e;
 *         }
 */
public class LoggingBasic {
    public static void main(String[] args) throws IOException {
        //获取一个记录器
        final Logger logger = Logger.getGlobal();
        //将日志打印等级设置到CONFIG以上
        logger.setLevel(Level.CONFIG);
        //将日志打印等级设置为所有
        logger.setLevel(Level.ALL);
        //调回默认等级
        logger.setLevel(Level.INFO);
        //记录日志（指定日志级别）
        logger.log(Level.INFO,"First login the website");
        //或者
        logger.fine("Second login the website");
        //日志打印异常方法1
        try {
            throw new IOException("输入异常");
        } catch (IOException e) {
            //getLogger 获取一个记录器，并传入一个名字并打印日志Reading image以及异常
            Logger.getLogger("com.myCompany.myapp").log(Level.WARNING,"Reading image",e);
        }
        //日志打印异常方法2 (记录一条FINER级别的日志记录和一条THROW开始的消息)
        if(true){
            final IOException e = new IOException("第二次输入异常");
            logger.throwing("com.mycompany.mylib.Reader","read",e);
            throw e;
        }
    }
}
