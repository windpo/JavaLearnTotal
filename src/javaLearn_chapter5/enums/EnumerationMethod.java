package javaLearn_chapter5.enums;

/**
 * @author 风之诗
 * @version 1.0
 * 演示Enum类各种方法的使用
 * 1、输出枚举对象的名字
 * spring.name()
 * 2、输出枚举对象所在位置(从0开始编号)
 * spring.ordinal()
 * 3、返回一个包含全部枚举的数组
 * Season.values()
 * 4、将输入的字符串转化为枚举对象，如果找到了就返回，没找到就报错
 * Season.valueOf("AUTUMN")
 * 5、比较两个枚举常量，返回相对位置差
 * spring.compareTo(autumn)
 */
public class EnumerationMethod {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        //输出枚举对象的名字
        System.out.println(spring.name());
        //输出枚举对象所在位置(从0开始编号)
        System.out.println(spring.ordinal());
        //返回一个包含全部枚举的数组
        System.out.println("===========");
        for (Season example :
                Season.values()) {
            System.out.println(example);
        }
        //将输入的字符串转化为枚举对象，如果找到了就返回，没找到就报错
        System.out.println("=========");
        Season autumn = Season.valueOf("AUTUMN");
        System.out.println(autumn);
        //比较两个枚举常量，返回相对位置差
        System.out.println("==========");
        System.out.println("春天的编号为："+spring.ordinal());
        System.out.println("秋天的编号为："+autumn.ordinal());
        System.out.println("相差的编号为："+spring.compareTo(autumn));
    }
}
