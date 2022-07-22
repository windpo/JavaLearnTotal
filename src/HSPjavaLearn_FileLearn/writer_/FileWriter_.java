package HSPjavaLearn_FileLearn.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 演示FIleWriter通过传入char,chars,string等方式将数据写入文件里面
 */
public class FileWriter_ {
    public static void main(String[] args) {
        final String filePath = "e:\\note.txt";
        //创建FileWtirer对象
        FileWriter fileWriter =null;
        char[] chars={'L','X','Y'};
        try {
            //追加模式：需要在构造器的参数里面加一个true，默认是覆盖模式
            fileWriter = new FileWriter(filePath);
            //1、写入单个字符
            fileWriter.write('L');
            //2、写入指定数组
            fileWriter.write(chars);
            //3、写入指定数组的指定部分
            fileWriter.write("刘旭阳今天摆了吗".toCharArray(),0,3);
            //4、写入整个字符串
            fileWriter.write("你好，hello~");
            //5、写入字符串的指定部分
            fileWriter.write("北京欢迎你",0,2);
            System.out.println("写入成功！");
        } catch (IOException e) {
            System.out.println("创建对象失败");
            e.printStackTrace();
        }finally {
            //FileWriter，一定要关闭流，或者flush才能真正把数据写入文件里面
            //原理：实际上最后会调用fileOutputStream将数据写进文件
            try {
                if (fileWriter!=null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("关闭对象失败");
                e.printStackTrace();
            }
        }
    }
}
