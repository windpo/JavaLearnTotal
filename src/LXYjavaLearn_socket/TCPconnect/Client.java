package LXYjavaLearn_socket.TCPconnect;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 风之诗
 * @version 1.0
 * TCP通信客户端
 * 实现步骤：
 *  *  1、创建一个客户端对象Socket，构造方法创建一个流套接字并将其连接到指定 IP 地址的指定端口号
 *  *  2、使用Socket对象中的方法getOutputStream（）获取网络字节输出流OutputStream对象
 *  *  3、使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
 *  *  4、使用Socket对象中的方法getInputStream（）获取网络字节输入流InputStream对象
 *  *  5、使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
 *  *  6、释放资源（Socket的close方法）
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端与服务器的连接
        final Socket socket = new Socket("127.0.0.1", 6666);
        System.out.println(socket.getInetAddress().getHostAddress());
        //给服务器发送信息
        final OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，服务器".getBytes(StandardCharsets.UTF_8));
        //接收服务器发送的信息
        final InputStream inputStream = socket.getInputStream();
        final byte[] bytes = new byte[1024];
        final int readLen = inputStream.read(bytes);
        System.out.println(new String(bytes,0,readLen));
        //释放资源
        socket.close();
    }
}
