package stream_file_IO;

import java.io.*;

/**
 * @author 风之诗
 */
public class ByteStreamTest{
    public static void main(String[] args)throws IOException {

/**
 * ByteArrayOutputStream
 *     内含属性：protected byte buf[];
 *      构造器需要一个数字，用来指定创造ByteArrayOutputStream对象中的字节缓冲数组
 *      字节缓冲数组：用来储存输入bOutput对象中的流
 */
        //输入字节的大小，自动创建一个大小为12byte的字节数组
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);
        while( bOutput.size()!= 10 ) {
            // 获取用户输入值
            bOutput.write(System.in.read());
        }

        byte[] b = bOutput.toByteArray();
        System.out.println("Print the content");
        for(int x= 0 ; x < b.length; x++) {
            // 打印字符
            System.out.print((char)b[x]  + "   ");
        }
        System.out.println("   ");

        int c;

        ByteArrayInputStream bInput = new ByteArrayInputStream(b);

        System.out.println("Converting characters to Upper case " );
        for(int y = 0 ; y < 1; y++ ) {
            while(( c= bInput.read())!= -1) {
                System.out.println(Character.toUpperCase((char)c));
            }
            bInput.reset();
        }
    }
}