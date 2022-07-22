package HSPjavaLearn_FileLearn.properties;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 风之诗
 * @version 1.0
 * 读取、创建、修改mysql.properties 文件，并得到ip，user 和pwd信息
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //创建Properties对象
        final Properties properties = new Properties();
        //加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //把k-v显示在控制台
        properties.list(System.out);
        //根据key获取单个值的信息
        System.out.println("用户名为："+properties.getProperty("user"));
        System.out.println("密码为："+properties.getProperty("pwd"));

        //创建新的Properties对象
        final Properties properties2 = new Properties();
        //创建（修改就是创建，如果有相同的key不同的value，则直接替换value的值）
        properties2.setProperty("charset","utf-8");
        properties2.setProperty("user","阳欣");//中文会转化为Unicode码
        properties2.setProperty("pwd","12345");
        //将k-v 存储到文件中即可
        properties2.store(new FileOutputStream("src\\mysql2.properties"),null);//后面的参数是注释
        System.out.println("保存配置文件成功!");

    }
}
