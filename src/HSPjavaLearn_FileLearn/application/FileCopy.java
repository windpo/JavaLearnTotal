package HSPjavaLearn_FileLearn.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 完成文件的拷贝，将 e:\\venti.jpg 拷贝到 e:\\test\\venti.jpg
 *
 * 思路：
 * 1、创建文件的输入流，将文件读入程序
 * 2、创建文件的输出流，将读取到的文件数据，写入到指定的文件。
 */
public class FileCopy {
    public static void main(String[] args) {
        //创建文件路径以及输入输出流
        final String secPath = "e:\\venti.jpg";
        final String destPath = "e:\\test\\venti.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream=null;
        //读取操作
        try {
            fileInputStream= new FileInputStream(secPath);
            fileOutputStream= new FileOutputStream(destPath);
            //定义字节数组，提高读取效率
            byte[] buf = new byte[1024];
            int readLen=0;
            //一遍从文件中读入，一边将其写入另一个文件
            while ((readLen=fileInputStream.read(buf))!=-1){
                //当字节数组最后一次读取时，后面可能会出现空白内容，此时必须只读前面的一部分
                fileOutputStream.write(buf,0,readLen);
            }
            System.out.println("成功拷贝~");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭输入流和输出流，释放资源
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
}
