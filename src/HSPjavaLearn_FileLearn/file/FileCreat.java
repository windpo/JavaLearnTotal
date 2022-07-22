package HSPjavaLearn_FileLearn.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 * 演示创建文件的三种方式
 *  1、File(String pathname)
 *  2、File(File parent, String child)
 *  3、File(String parent, String child)
 */
public class FileCreat {
    public static void main(String[] args) {

    }
    @Test
    //方式一
    public void create01(){
        final String filepath = "e:\\news1.txt";
        final File file = new File(filepath);

        try {
            file.createNewFile();
            System.out.println("创建文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //方式二
    public void create02(){
        final File parentFile = new File("e:\\");
        final String filename = "news2.txt";
        final File file = new File(parentFile + filename);

        try {
            file.createNewFile();
            System.out.println("创建文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //方式三
    public void create03(){
        final String parentPath = "e:\\";
        final String filePath = "news3.txt";
        final File file = new File(parentPath, filePath);

        try {
            file.createNewFile();
            System.out.println("创建文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
