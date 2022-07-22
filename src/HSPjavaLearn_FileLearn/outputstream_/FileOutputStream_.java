package HSPjavaLearn_FileLearn.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 风之诗
 * @version 1.0
 * 文件字节输出流
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示如何将字节、字符串通过文件输出流存储到文件中
     * 1、写入一个字节
     * fileOutputStream.write('H');
     * 2、写入一个字符串
     * fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
     * 3、写入截取的一截字符串
     * fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8),0,3);
     * 4、如何实现将写入文件的内容追加到文件末尾，而不是覆盖原来的文件
     * fileOutputStream=new FileOutputStream(filePath,true);
     */
    @Test
    public void writefile01(){
        //创建FileOutputStream对象
        final String filePath = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;

//        //写入一个字节
//        try {
//            fileOutputStream=new FileOutputStream(filePath,true);
//            fileOutputStream.write('H');
//        } catch (IOException e) {
//            System.out.println("写入失败");
//            e.printStackTrace();
//        }finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                System.out.println("关闭失败");
//                e.printStackTrace();
//            }
//        }

        //写入一个字符串(str.getBytes可用将字符串化成字符数组)
        final String str = "芜湖~起飞";
        try {
            fileOutputStream=new FileOutputStream(filePath,true);
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("写入失败");
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("关闭失败");
                e.printStackTrace();
            }
        }

//        //写入一段字符串
//        try {
//            fileOutputStream=new FileOutputStream(filePath,true);
//            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8),0,3);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                System.out.println("关闭失败");
//                e.printStackTrace();
//            }
//        }


    }
}
