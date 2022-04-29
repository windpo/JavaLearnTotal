package javaLearn_chapter7.creatException;

import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 创建自己的异常类
 * 异常类中需要包含两个构造器，一个无参构造器，一个带String的构造器，用来指定抛出异常的具体信息
 */
public class FileFormatException extends IOException {
    public FileFormatException() {
    }

    public FileFormatException(String message) {
        super(message);
    }


    public static void main(String[] args) throws FileFormatException {
        //该语句出现异常,将其捕获并打印异常
        try {
            Test.TestException();
        }catch (FileFormatException f){
            f.printStackTrace();
            //输出异常信息
            System.out.println(f.getMessage());
        }
        System.out.println("测试完成");
    }
}

class Test {
    /**
     * 该方法抛出FileFormatException异常，并输出异常的信息，其中throw的地方为异常出现的地方
     *
     * @throws FileFormatException
     */
    public static void TestException() throws FileFormatException {
        throw new FileFormatException("测试异常");
    }
}
