package HSPjavaLearn_FileLearn.application;

import java.io.*;

/**
 * @author 风之诗
 * @version 1.0
 * 演示使用BufferedInputStream和BufferedOutputStream来拷贝二进制文件
 */
public class BufferedCopy02 {
    public static void main(String[] args) {
        final String srcFilePath = "e:\\venti.jpg";
        final String destFilePath = "e:\\test\\venti.jpg";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        final byte[] buf = new byte[1024];
        int readLen = 0;
        try {
            //创建BufferedInputStream和BufferedOutputStream流
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            //循环读取文件并写入destFilePath文件
            while ((readLen = bis.read(buf)) != -1) {
                bos.write(buf, 0, readLen);
            }
            System.out.println("拷贝文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
