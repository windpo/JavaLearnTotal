package LXYjavaLearn_socket.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author 风之诗
 * @version 1.0
 * 1、创建一个服务器ServerSocket对象，给系统要指定的端口号
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
        //创建服务器端
        final ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务端"+serverSocket.getInetAddress().getHostAddress()+"启动完毕，等待接收...");
        /**
         * 升级：
         * 让服务器一直处于监听状态（死循环accept方法）
         * 有一个客户端上传文件，就保存一个文件
         */
        while (true){
            final Socket socket = serverSocket.accept();
            /**
             * 升级
             * 使用多线程，提高程序效率
             * 有一个客户端上传文件，就开启一个线程，完成文件上传
             */
            new Thread(new Runnable() {
                //完成文件上传
                @Override
                public void run() {
                    try {
                        //创建本地文件夹
                        final File file = new File("D:\\upload");
                        if(!file.exists()){
                            file.mkdirs();
                        }

                        /**
                         * 升级：
                         * 创建一个文件的命名规则，防止同名的文件相互覆盖
                         * 规则：域名+毫秒值+随机数
                         */
                        final String fileName = "itwindPo" + System.currentTimeMillis() + new Random().nextInt(999999) + ".txt";

                        //接收客户端文件并保存在本地
                        final InputStream is = socket.getInputStream();
                        final FileOutputStream fos = new FileOutputStream(file +"\\" +fileName);
                        final byte[] bytes = new byte[1024];
                        int readLen=0;
                        while ((readLen=is.read(bytes))!=-1){
                            fos.write(bytes,0,readLen);
                        }
                        //回复客户端消息
                        final OutputStream os = socket.getOutputStream();
                        os.write("上传成功".getBytes(StandardCharsets.UTF_8));
                        //释放资源
                        fos.close();
                        socket.close();
                        System.out.println("文件上传完毕");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        /**
         * 服务器不用关闭了
         */
        //serverSocket.close();

    }
}
