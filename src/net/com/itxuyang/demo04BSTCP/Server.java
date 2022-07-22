package net.com.itxuyang.demo04BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 风之诗
 * @version 1.0
 * 使用浏览器访问TCPSocket服务器
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器
        final ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("等待客户端连接");
        /**
         * 浏览器解析服务器回写的html页面，页面中如果有图片，那么浏览器就会单独的开启一个线程，读取服务器的图片
         * 我们就得让服务器处于监听状态，客户端请求一次，服务器就回写一次
         */
        while (true){
            //获取客户端对象（浏览器）
            final Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
                        final InputStream is = socket.getInputStream();
                        //获取所有传入的信息
//                        final byte[] by = new byte[1024];
//                        int en=0;
//                        while((en=is.read(by))!=-1){
//                        System.out.println(new String(by,0,en));
//                           }

                        //  仅读取输入信息第一行的部分信息（JavaLearnTotal/web/index.html）
                        final BufferedReader br = new BufferedReader(new InputStreamReader(is));//将字节输入流转化为缓冲字符输入流
                        final String line = br.readLine();//读取第一行信息
                        final String[] arr = line.split(" ");//使用空格将字符串分开
                        final String htmlPath = arr[1].substring(1);//截取中间一段/JavaLearnTotal/web/index.html，并去掉首字符/
                        System.out.println(htmlPath);

                        //读取客户端请求的本地资源（html路径）
                        final FileInputStream fis = new FileInputStream(htmlPath);
                        //将文件写回客户端
                        final OutputStream os = socket.getOutputStream();

                        //写入HTTP协议响应头，固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes(StandardCharsets.UTF_8));
                        //注意，此处为网页识别的文件格式，若Content-Type写错，网页输出的内容错误，若没设置ContentType时，浏览器会直接下载文件到本地
                        os.write("Content-Type:text/html\r\n".getBytes(StandardCharsets.UTF_8));
                        //必须要写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes(StandardCharsets.UTF_8));

                        //一读一写复制文件，把服务器读取的html文件回写到客户端
                        int readLen=0;
                        final byte[] bytes = new byte[1024];
                        while ((readLen=fis.read(bytes))!=-1){
                            os.write(bytes,0,readLen);
                        }

                        //释放资源
                        fis.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}
