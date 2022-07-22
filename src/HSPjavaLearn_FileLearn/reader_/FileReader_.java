package HSPjavaLearn_FileLearn.reader_;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 文件字符输入流
 *
 * 使用字符数组读取文件
 */
public class FileReader_ {
    public static void main(String[] args) {
        final String srcPath = "e:\\story.txt";
        FileReader fileReader=null;
        try {
            //1、创建字符输入流
            fileReader=new FileReader(srcPath);
            //创建字符数组以及每一次读取的长度
            int readLen;
            char[] buf = new char[8];
            //循环读取 返回实际读取到的字符数
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            System.out.println("创建字符输入流失败");
            e.printStackTrace();
        } finally {
            //关闭字符输入流
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("关闭字符输入流失败");
                e.printStackTrace();
            }
        }
    }
}
