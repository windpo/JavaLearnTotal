package net.com.itxuyang.demo03.FileUpload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 风之诗
 * @version 1.0
 *    文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据
 *    明确：
 *         数据源：D:\\1.jpg
 *         目的地：服务器
 *
 *    实现步骤：
 *          1、创建一个本地输入流FileInputStream对象，构造方法中要绑定读取的数据源
 *          2、创建一个客户端Socket对象，构造方法中绑定IP地址和端口号
 *          3、使用Socket中的方法getOutputStream,获取输出流对象
 *          4、使用本地字节输入流FileInputStream对象中的方法read，读取本地文件
 *          5、使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传至服务器
 *          6、使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
 *          7、使用网络字节对象InputStream中的方法read读取服务器回写的数据
 *          8、释放资源（FileInputStream,Socket）
 *
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动.....");
        //1、创建一个本地输入流FileInputStream对象，构造方法中要绑定读取的数据源
        final FileInputStream fis = new FileInputStream("D:\\1.jpg");

        //2、创建一个客户端Socket对象，构造方法中绑定IP地址和端口号
        final Socket socket = new Socket("127.0.0.1", 6666);

        //3、使用Socket中的方法getOutputStream,获取输出流对象
        final OutputStream outputStream = socket.getOutputStream();

        //4、使用本地字节输入流FileInputStream对象中的方法read，读取本地文件
        int len=0;
        final byte[] bytes = new byte[1024];
        while((len=fis.read(bytes))!=-1){
            //5、使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传至服务器
            outputStream.write(bytes,0,len);
        }

        //注意：read方法在未接受到一个-1的结束标志时，读取不会结束，会进入阻塞状态，此时需要用shutdown方法来关闭OutputStream流
        //禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
        // 如果在套接字上调用 shutdownOutput() 后写入套接字输出流，则该流将抛出 IOException。
        socket.shutdownOutput();
        //6、使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
        final InputStream inputStream = socket.getInputStream();

        //7、使用网络字节对象InputStream中的方法read读取服务器回写的数据
        while ((len=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        //8、释放资源（FileInputStream,Socket）
        fis.close();
        inputStream.close();
        System.out.println("文件上传已保存");
    }
}
