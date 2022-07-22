package HSPjavaLearn_FileLearn.application;

import java.io.*;

/**
 * @author 风之诗
 * @version 1.0
 * 演示通过BufferedReader和BufferedWriter来拷贝文本文件
 * 注意：不能读取二进制文件（图片，文字），否则可能会造成文件拷贝错误
 */
public class BufferedCopy {
    public static void main(String[] args) {
        final String srcFilePath = "e:\\a.txt";
        final String destFilePath = "e:\\a2.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;//以字符串形式读取
        try {
            //创建BufferedReader和BufferedWriter
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //说明：readLine读取一行内容，但不带换行符，所以每读取一行，就需要插入一个换行符
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("拷贝完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null) {
                    br.close();
                }
                if (bw!=null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("关闭文件异常");
                e.printStackTrace();
            }
        }
    }
}
