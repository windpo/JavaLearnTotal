package net.com.itxuyang.demo02.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 风之诗
 * @version 1.0
 *      文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给服务器回写“上传成功”
 *          明确：
 *             数据源：客户端上传的文件
 *             目的地：服务器的硬盘：D:\\upload\\1.jpg
 *       实现步骤：
 *       1、创建一个服务器ServerSocket对象，给系统要指定的端口号
 *       2、使用ServerSocket对象中的accept方法，获取请求到的客户端Socket对象
 *       3、使用Socket中的getInputStream获取网络字节输入流的对象
 *       4、！判断D:\\upload文件夹是否存在，若不存在，则需创建一个
 *       5、创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
 *       6、使用网络字节输入流中的read方法，读取从客户端发送过来的数据
 *       7、使用网路字节输入流FileOutputStream对象的write方法，把读取到的文件绑定到服务器的硬盘上
 *       8、使用Socket对象中的方法getOutputStream，获取到网络字节输出流对象OutputStream
 *       9、使用网络输出流对象中的方法write，给客户端回写上传成功
 *       10、释放资源（FileOutputStream，Socket，ServerSocket）
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建一个服务器ServerSocket对象，给系统要指定的端口号
        final ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器 启动.....");
        //2、使用ServerSocket对象中的accept方法，获取请求到的客户端Socket对象
        final Socket socket = serverSocket.accept();

        //3、使用Socket中的getInputStream获取网络字节输入流的对象
        final InputStream is = socket.getInputStream();

        //4、！判断D:\\upload文件夹是否存在，若不存在，则需创建一个
        final File file = new File("d:\\upload");
        if(!file.exists()){
            file.mkdirs();
        }
        //5、创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
        final FileOutputStream fileOutputStream = new FileOutputStream(file + "\\1.jpg");

        //6、使用网络字节输入流中的read方法，读取从客户端发送过来的数据
        int len=0;
        final byte[] bytes = new byte[1024];
        while((len=is.read(bytes))!=-1){
            //7、使用网路字节输入流FileOutputStream对象的write方法，把读取到的文件绑定到服务器的硬盘上
            fileOutputStream.write(bytes,0,len);
        }

        //8、使用Socket对象中的方法getOutputStream，获取到网络字节输出流对象OutputStream
        final OutputStream os = socket.getOutputStream();

        //9、使用网络输出流对象中的方法write，给客户端回写上传成功
        os.write("上传成功".getBytes());
        System.out.println("文件发送完毕");
        //10、释放资源（FileOutputStream，Socket，ServerSocket）
        serverSocket.close();
        socket.close();
        fileOutputStream.close();
        System.out.println("文件上传完毕");
    }
}
