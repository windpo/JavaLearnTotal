package LXYjavaLearn_reflection.getclass;

/**
 * @author 风之诗
 * @version 1.0
 * 演示三种方式获取类的Class对象
 */
public class  GetClass_{
    public static void main(String[] args) throws ClassNotFoundException {
        //方式1
        final Class<String> stringClass = String.class;
        //方式2
        final Class<?> stringClass2 = Class.forName("java.lang.String");
        //方式3
        final Class<? extends String> stringClass3 = new String("这是一个实例对象").getClass();
        //判断Class类是否相同
        System.out.println(stringClass == stringClass2);
        System.out.println(stringClass == stringClass3);
        //判断Integer的原始类型
        System.out.println(Integer.TYPE==int.class);
    }
}
