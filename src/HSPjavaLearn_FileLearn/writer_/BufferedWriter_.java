package HSPjavaLearn_FileLearn.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 演示BufferedWriter的使用
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        final String filePath = "e:\\ok.txt";
        //创建BufferedWriter
        //注意：追加模式是在节点流的构造器里的选项，增加一个true为追加模式，否则为覆盖模式
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write("hello，刘旭阳没有在卷");
        bufferedWriter.newLine();//增加一行换行符（根据不同的系统增加不同的换行符）
        bufferedWriter.write("hello，刘旭阳想卷一卷");
        bufferedWriter.newLine();
        bufferedWriter.write("hello，刘旭阳快卷死了");
        bufferedWriter.newLine();

        //关闭处理流和节点流
        bufferedWriter.close();
    }
}
