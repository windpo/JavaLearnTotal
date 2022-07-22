package LXYjavaLearn_reflection.getclassinfo;

import java.lang.reflect.Type;

/**
 * @author 风之诗
 * @version 1.0
 * 演示如何获取Class对象的信息
 * 1、获取该类的一些相关信息的方法
 * 2、获取父类信息
 */
public class Getclassinfo_ {
    public static void main(String[] args) {
        //得到字符串数组的类class对象，获取class类的相关信息
        Class<String[]> clazz = String[].class;
        System.out.println(clazz.getName());  //获取类名称（得到的是包名+类名的完整名称）
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getTypeName());//获取类的类型名
        System.out.println(clazz.getClassLoader());   //获取它的类加载器
        //System.out.println(clazz.cast(new Integer("10")));   //强制类型转换

        System.out.println("================================");

        /**
         * 获取父类信息方法
         */
        //1、通过`getSuperclass()`方法，我们可以获取到父类的Class对象
        Integer i = 10;
        System.out.println(i.getClass().getSuperclass());

        System.out.println("==========");
        //2、通过`getGenericSuperclass()`获取父类的原始类型的Type
        final Type type = i.getClass().getGenericSuperclass();
        System.out.println(type);
        System.out.println(type instanceof Class);

        System.out.println("=================================");
        //3、获取父接口
        for (Class<?> anInterface : i.getClass().getInterfaces()) {
            System.out.println(anInterface);
        }

        System.out.println("==========");
        //4、获取父接口的原始类型type
        for (Type genericInterface : i.getClass().getGenericInterfaces()) {
            System.out.println(genericInterface.getTypeName());
        }
        System.out.println("\nInteger父类接口的第一个为Comparable<Integer>，用");
        System.out.println(i.getClass().getGenericInterfaces()[0].getClass());
        System.out.println("来实现，可以通过该实现来获取泛型");
    }
}
