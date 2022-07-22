package HSPjavaLearn_FileLearn.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 演示使用BufferedReader来读取文件中的字符串
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        final String filePath = "e:\\a.txt";
        //创建BufferedReader
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;//按行读取，提高效率

        //BufferedReader中含有方法为一次读取一行字符串，当读取完毕过后会返回空字符串
        while ((line = bufferedReader.readLine()) != null) {
            //这里读取过后需要换行才能保证跟源文件效果一样

            System.out.println(line);
        }
        //关闭流时，只需要关闭BufferedReader，底层会自动关闭节点流（FileReader）
        bufferedReader.close();
    }
}
