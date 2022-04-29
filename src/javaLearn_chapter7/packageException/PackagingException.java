package javaLearn_chapter7.packageException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 风之诗
 * @version 1.0
 * 再次抛出异常与异常链：将低层次异常封装为高层次异常
 * 在该方法的catch处理中再次抛出一个异常，该异常封装子类异常的信息，并且在调用方法的地方得到异常s.getCause
 */
public class PackagingException {
    public static void main(String[] args) throws ServletException, SQLException {
        try {
            PackagingTest.test();
        }catch (ServletException s){
            //得到ServletException异常的引发原因
            System.out.println(s.getCause());
        }
    }
}

/**
 * 自己定义的一个ServletExcption
 */
class ServletException extends Exception{
    public ServletException() {
    }

    public ServletException(String message) {
        super(message);
    }
}

/**
 * 测试在catch中再次抛出封装的高层次异常
 */
class PackagingTest{
    public static void test() throws SQLException, ServletException {
        try{
            throw new SQLException("database error!");
        }catch (SQLException sqlException){
            //创建高层次异常
            ServletException servletExcption = new ServletException();
            //将低层次异常封装在高层次异常中
            servletExcption.initCause(sqlException);
            throw servletExcption;
        }
    }
}
