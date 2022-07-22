package HSPjavaLearn_FileLearn.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 风之诗
 * @version 1.0
 */
public class FileInformation {
    public static void main(String[] args) {

    }
    @Test
    //获取文件的信息
    public void info(){
        //先创建文件对象
        final File file = new File("e:\\news1.txt");

        //调用相应方法，得到对应信息
        System.out.println("文件名字="+file.getName());
        System.out.println("文件绝对路径"+file.getAbsolutePath());
        System.out.println("文件父路径"+file.getParent());
        System.out.println("文件大小（字节）"+file.length());
        System.out.println("文件是否存在"+file.exists());
        System.out.println("是否为文件"+file.isFile());//如："e:\\news1.txt"
        System.out.println("是否为一个目录"+file.isDirectory());//如："e:\\"
    }
}
