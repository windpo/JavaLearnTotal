package net.com.itxuyang.demo01.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 风之诗
 * @version 1.0
 * TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，然后读取服务器回写的数据
 * 表示客户端的类：
 *      java.net.Socket:该类实现了客户端嵌套字（也叫做套接字）。套接字是两台机器间通信的端点。
 *      套接字：包含了IP地址和端口号的网络单位
 *
 *  构造方法：
 *  Socket（String host,int port）创建一个流套接字并将其连接到指定 IP 地址的指定端口号
 *  参数：
 *      String host：服务器主机的名称/服务器的IP地址
 *      int port：服务器的端口号
 *
 *  成员方法：
 *  OutputStream getOutputStream（）返回次套接字的输出流
 *  InputStream getInputStream（）返回套接字的输入流
 *  void close（）关闭套接字。
 *
 *  实现步骤：
 *  1、创建一个客户端对象Socket，构造方法创建一个流套接字并将其连接到指定 IP 地址的指定端口号
 *  2、使用Socket对象中的方法getOutputStream（）获取网络字节输出流OutputStream对象
 *  3、使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
 *  4、使用Socket对象中的方法getInputStream（）获取网络字节输入流InputStream对象
 *  5、使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
 *  6、释放资源（Socket的close方法）
 *  注意：
 *      1、客户端和服务器端进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
 *      2、当我们创建客户端对象Socket的时候，就会去请求服务器和服务器经过三次握手建立连接通路
 *      如果此时服务器没有启动，就会抛出异常
 *      如果服务器已经启动，则就可以进行交互了
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建一个客户端对象Socket，构造方法创建一个流套接字并将其连接到指定 IP 地址的指定端口号
        final Socket socket = new Socket("10.165.164.220", 8888);
        System.out.println(socket.getInetAddress());
        //2、使用Socket对象中的方法getOutputStream（）获取网络字节输出流OutputStream对象
        final OutputStream outputStream = socket.getOutputStream();

        //3、使用网络字节输出流OutputStream对象中的方法write，给服务器发送数据
        outputStream.write("你好服务器".getBytes());

        //4、使用Socket对象中的方法getInputStream（）获取网络字节输入流InputStream对象
        final InputStream inputStream = socket.getInputStream();
        //=====解析回写数据=====
        //5、使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
        final byte[] bytes = new byte[1024];
        final int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6、释放资源（Socket的close方法）
        socket.close();
    }
}
