package HSPjavaLearn_FileLearn.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 风之诗
 * @version 1.0
 *  1、文件和目录的删除
 *  2、创建目录/多级目录
 */
public class Directory_ {
    public static void main(String[] args) {

    }
    @Test
    //判断 d:\\news1.txt是否存在，若存在则删除(也可以删除如："e:\\demo01"整个目录)
    public void m1(){
        final String filepath = "e:\\news1.txt";
        final File file = new File(filepath);
        if(file.exists()){
            if (file.delete()) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("该文件不存在");
        }
    }
    @Test
    //判断e:\\demo\\a\\b\\c 目录是否存在，若不存在则创建该多级目录(mkdir创建单个目录，mkdirs创建多个目录)
    public void m2(){
        final String directoryPath = "e:\\demo\\a\\b\\c";
        final File file = new File(directoryPath);
        if(file.exists()){
            System.out.println("该文件已存在");
        }else {
            if (file.mkdirs()) {
                System.out.println("创建成功！");
            }else {
                System.out.println("创建失败！");
            }
        }
    }
}
