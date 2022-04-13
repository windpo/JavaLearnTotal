package tracks.get_systemproperties;

import java.util.Map;
import java.util.Properties;

/**
 * 1、得到系统编码方式并输出
 * 2、设置系统编码方式
 * 3、得到系统属性
 * @author 风之诗
 */
public class Main {
    public static void main(String[] args) {
        //1、得到系统编码方式并输出
        System.out.println("得到系统编码方式并输出");

        String property = System.getProperty("file.encoding");
        System.out.println(property);
        //2、设置系统编码方式
        System.out.println("================");
        System.out.println("设置系统编码方式");

        System.setProperty("file.encoding","UTF-8");
        //3、输出系统所有可更改的属性
        System.out.println("==============");
        System.out.println("输出系统所有可更改的属性");

        Properties properties = System.getProperties();
        for (Map.Entry<Object,Object> entry:
             properties.entrySet()) {
            System.out.println(entry);
        }
        //4、输出系统不可更改的配置
        System.out.println("===========");
        System.out.println("输出系统不可更改的配置");
        Map<String, String> getenv = System.getenv();
        for (Map.Entry<String, String> stringStringEntry :
                getenv.entrySet()) {
            System.out.println(stringStringEntry);
        }
        //5、
    }
}
