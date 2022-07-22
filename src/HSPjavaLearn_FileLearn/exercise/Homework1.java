package HSPjavaLearn_FileLearn.exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 考察file知识
 * 创建文件 creatNewFile
 * 创建目录/多级目录 mkdir（s）
 */
public class Homework1 {
    public static void main(String[] args) throws IOException {
        final File file1 = new File("e:\\mytemp");
        final File file2 = new File("e:\\mytemp\\hello.txt");
        //判断是否有文件夹mytemp，没有就创建
        if (!file1.exists()) {
            //创建文件夹方法
            if (file1.mkdirs()) {
                System.out.println("创建文件夹成功");
            }else {
                System.out.println("创建文件夹失败");
            }
        }
        //判断在文件夹下是否有hello.txt，有提示已存在，没有就创建
        if (file2.exists()) {
            System.out.println("存在该文件");
        }else {
            try {
                //创建文件方法
                file2.createNewFile();
                System.out.println("创建文件成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //向文件中写入信息hello
        final FileWriter fileWriter = new FileWriter("e:\\mytemp\\hello.txt");
        fileWriter.write("hello");
    }
}
