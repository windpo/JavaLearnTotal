package net.com.itxuyang.demo01.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 风之诗
 * @version 1.0
 *    TCP通信的服务器端：接收客户端请求，读取客户端发送的数据，给客户端回写数据
 *    表示服务器的类：
 *      java.net.ServerSocket:此类实现服务器套接字。
 *    构造方法：
 *      serverSocket（int port）创建绑定到特点端口的服务器套接字。
 *    服务器必须明确一件事，必须要知道是哪个客户端请求的服务器
 *    所以可以使用accept方法获取到请求的客户端对象Socket
 *    成员方法：
 *       Socket accept() 侦听并接受到此套接字的连接。
 *     服务器的实现步骤：
 *          1、创建服务器的ServerSocket对象和系统要指定的端口号
 *          2、使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
 *          3、使用Socket对象中的方法getInputStream（）获取网络字节输入流InputStream对象
 *          4、使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
 *          5、使用Socket对象中的方法getOutputStream（）获取网络字节输出流对象
 *          6、使用网络字节输出流OutputStream对象中的方法write，给客户端回写数据
 *          7、释放资源（Socket，ServerSocket）
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器的ServerSocket对象和系统要指定的端口号
        final ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println(serverSocket.getInetAddress());
        //2、使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
        final Socket socket = serverSocket.accept();

        //3、使用Socket对象中的方法getInputStream（）获取网络字节输入流InputStream对象
        final InputStream is = socket.getInputStream();

        //4、使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
        final byte[] bytes = new byte[1024];
        final int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        //======回写数据======
        //5、使用Socket对象中的方法getOutputStream（）获取网络字节输出流对象
        final OutputStream os = socket.getOutputStream();

        //6、使用网络字节输出流OutputStream对象中的方法write，给客户端回写数据
        os.write("收到谢谢".getBytes());

        //7、释放资源（Socket，ServerSocket）
        socket.close();
        serverSocket.close();
    }
}
