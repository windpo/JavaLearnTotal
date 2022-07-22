package LXYjavaLearn_reflection.getclassloader;

/**
 * @author 风之诗
 * @version 1.0
 * 演示获取类加载器的方法
 */
public class Getclassloader {
    public static void main(String[] args) {
        //AppClassLoader
        System.out.println(Getclassloader.class.getClassLoader());
        //PlatformClassLoader，JDK1.9之后ExtClassLoader更名为PlatFromClassLoader，加载lib/modules目录下的class。
        System.out.println(Getclassloader.class.getClassLoader().getParent());
        //由于BootstarpClassLoader是C++编写的，在Java中是获取不到的。
        System.out.println(Getclassloader.class.getClassLoader().getParent().getParent());
        System.out.println(String.class.getClassLoader());
    }
}
