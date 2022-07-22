package HSPjavaLearn_FileLearn.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 演示FileInputStream的使用（字节输入流 文件-->程序）
 */
public class FileInputStream_ {
    public static void main(String[] args) {
    }

    /**
     * 演示读取文件
     * 单个字节的读取，效率比较低，且当遇到多个字节表示一个字时会出现乱码
     * -->使用read(byte[] b)一次读取多字节
     */
    @Test
    public void readFile01(){
        final String filePath = "e:\\hello.txt";
        FileInputStream fileInputStream =null;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            int readData=0;
            //从该输入流读取一个字节的数据。若无输入可用，此方法将阻止。
            //如果返回-1，表示读取完毕
            while((readData = fileInputStream.read())!=-1){
                System.out.print((char)readData);
            }
        } catch (IOException e) {
            System.out.println("读取文件错误");
            e.printStackTrace();
        }finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println("关闭文件错误");
                e.printStackTrace();
            }
        }
    }

    /**
     * 演示使用read(byte[] b)读取文件，一次读取8个字节,提升效率,但同样会存在中文字符读取错误的问题
     */
    @Test
    public void readFile02(){
        final String filePath = "e:\\a.txt";
        FileInputStream fileInputStream =null;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //一次读取字节数组的长度
            int readLen=0;
            //字节数组
            byte[] buf = new byte[8];//一次读取8个字节.
            //从该输入流读取最多b.length字节的数据到字节数组。此方法将阻塞，直到某些输入可以再次被读取
            //如果返回-1，表示读取完毕
            //如果读取正常，返回实际读取的字节数
            while((readLen = fileInputStream.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));//输出
            }
        } catch (IOException e) {
            System.out.println("读取文件错误");
            e.printStackTrace();
        }finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println("关闭文件错误");
                e.printStackTrace();
            }
        }
    }
}
