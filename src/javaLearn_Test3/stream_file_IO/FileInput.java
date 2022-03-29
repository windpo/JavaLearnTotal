package stream_file_IO;

import java.io.*;

public class FileInput {
    public static void main(String[] args) throws IOException {
        //多种构造方法创建一个输入流对象，等同于以下两个
        //        File file = new File();
        //      FileInputStream fileInputStream = new FileInputStream(f);
        FileInputStream fileInputStream = new FileInputStream("D:\\workspace\\CODE\\IDEA\\Java_LearnTest3\\src\\test");
        System.out.println("请输入名字");
        fileInputStream.read();
    }
}
