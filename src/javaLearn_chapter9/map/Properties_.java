package javaLearn_chapter9.map;

import java.util.Properties;

/**
 * @author 风之诗
 * @version 1.0
 * Properties_类介绍以及相关使用
 *  1、该类继承了HashTable
 *  2、可以通过键值对存放数据，且同HashTable一样，不能存放null
 */
public class Properties_ {
    public static void main(String[] args) {
        //创建Properties对象
        final Properties properties = new Properties();
        //增加值 k—v形式
        properties.put("john",100);
        properties.put("lucy",100);
        properties.put("lic",100);
        properties.put("lic",88);

        System.out.println("properties="+properties);

        //通过k 获取对应的值
        System.out.println(properties.get("lic"));

        //删除
        properties.remove("lic");
        System.out.println("properties="+properties);

        //修改
        properties.put("john","约翰");
        System.out.println("properties="+properties);
    }
}
