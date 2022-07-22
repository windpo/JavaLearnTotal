package LXYjavaLearn_socket.fileUpload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 风之诗
 * @version 1.0
 * 实现步骤：
 *  *          1、创建一个本地输入流FileInputStream对象，构造方法中要绑定读取的数据源
 *  *          2、创建一个客户端Socket对象，构造方法中绑定IP地址和端口号
 *  *          3、使用Socket中的方法getOutputStream,获取输出流对象
 *  *          4、使用本地字节输入流FileInputStream对象中的方法read，读取本地文件
 *  *          5、使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传至服务器
 *  *          6、使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
 *  *          7、使用网络字节对象InputStream中的方法read读取服务器回写的数据
 *  *          8、释放资源（FileInputStream,Socket）
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端
        final Socket socket = new Socket("127.0.0.1", 8080);
        System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"启动完毕，准备发送...");
        //将客户端的文件发到服务器上
        final FileInputStream fis = new FileInputStream("D:\\course.txt");
        final OutputStream os = socket.getOutputStream();
        int readLen;
        final byte[] bytes = new byte[1024];
        while ((readLen = fis.read(bytes)) != -1) {
            os.write(bytes, 0, readLen);
        }
        System.out.println("文件已发送");
        ////相当于给服务器一个标志说上传完毕了，服务器不要再继续接收客户端的文件
        socket.shutdownOutput();
        //客户端接收服务器的消息
        final InputStream is = socket.getInputStream();
        readLen = is.read(bytes);
        System.out.println(new String(bytes,0,readLen));
        //释放资源
        socket.close();
        fis.close();
        System.out.println("文件上传已保存");
    }
}
