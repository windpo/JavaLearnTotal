package LXYjavaLearn_reflection.usemethod;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 风之诗
 * @version 1.0
 * 演示利用反射机制获取并使用类的方法
 */
public class Usemethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取Class对象
        final Class<Student> clazz = Student.class;
        final Student student = clazz.newInstance();
        //通过方法名和形参类型获取类中的方法（前一个为方法名称，后面一个为方法参数的Class对象）
        final Method method = clazz.getMethod("test", String.class);
        //通过Method对象的invoke方法来使用类的方法（前一个为实例对象（static可省略），后一个为方法参数的内容）
        method.invoke(student, "肝原神");

        //获取并使用类的private方法
        //通过方法名和形参类型获取类中的方法
        final Method method2 = clazz.getDeclaredMethod("test2", String.class);
        method2.setAccessible(true);
        //通过Method对象的invoke方法来调用方法
        method2.invoke(student,"学生方法");

        //获取方法名称
        System.out.println(method2.getName());
        //获取方法返回值类型
        System.out.println(method2.getReturnType());
    }
}

class Student {
    String name;

    public void test(String content) {
        System.out.println("我在图书馆" + content);
    }
    private void test2(String content){
        System.out.println(content+"为一个隐藏方法");
    }
}