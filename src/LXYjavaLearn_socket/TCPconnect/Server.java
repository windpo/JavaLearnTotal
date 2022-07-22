package LXYjavaLearn_socket.TCPconnect;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 风之诗
 * @version 1.0
 * TCP通信服务端
 * 实现步骤：
 *  *       1、创建一个服务器ServerSocket对象，给系统要指定的端口号
 *  *       2、使用ServerSocket对象中的accept方法，获取请求到的客户端Socket对象
 *  *       3、使用Socket中的getInputStream获取网络字节输入流的对象
 *  *       4、！判断D:\\upload文件夹是否存在，若不存在，则需创建一个
 *  *       5、创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
 *  *       6、使用网络字节输入流中的read方法，读取从客户端发送过来的数据
 *  *       7、使用网路字节输入流FileOutputStream对象的write方法，把读取到的文件绑定到服务器的硬盘上
 *  *       8、使用Socket对象中的方法getOutputStream，获取到网络字节输出流对象OutputStream
 *  *       9、使用网络输出流对象中的方法write，给客户端回写上传成功
 *  *       10、释放资源（FileOutputStream，Socket，ServerSocket）
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器
        final ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println(serverSocket.getInetAddress().getHostAddress());
        //创建服务器和客户端的连接
        final Socket socket = serverSocket.accept();
        //服务器接收信息
        final InputStream inputStream = socket.getInputStream();
        final byte[] bytes = new byte[1024];
        final int readLen = inputStream.read(bytes);
        System.out.println(new String(bytes,0,readLen));
        //服务器输出信息
        final OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到，谢谢客户端".getBytes(StandardCharsets.UTF_8));
        //释放资源
        serverSocket.close();
        socket.close();
    }
}
