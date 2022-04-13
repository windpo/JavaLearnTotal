package javaLearn_chapter5.integer;

import java.util.ArrayList;

/**
 * @author 风之诗
 * 演示包装类以及基本方法
 *  1、设置对象数字
 *  Integer.valueOf(3)
 *  2、取出对象数字
 *  Integer.intValue()
 *  3、返回字符串
 *  Integer.toString()
 *  4、将字符串转化为整数
 *  Integer.parseInt(string)
 *  5、比较（注意：Integer包装类的比较即为类之间的比较，需要用.equals方法）
 *  a.equals(i)
 */
public class IntegerTest {
    public static void main(String[] args) {
        //创建包装类数组列表
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);//自动装箱
        integers.add(Integer.valueOf(3));//手动装箱
        integers.get(0);//自动拆箱
        integers.get(0).intValue();//手动拆箱
        String string = integers.get(0).toString();//返回字符串
        int i = Integer.parseInt(string);//返回整数
        System.out.println("比较int型整数和Integer类型包装类");
        System.out.println(integers.get(0).equals(i));
    }
}
