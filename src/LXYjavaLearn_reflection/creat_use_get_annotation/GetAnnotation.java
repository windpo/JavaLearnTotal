package LXYjavaLearn_reflection.creat_use_get_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author 风之诗
 * @version 1.0
 * 演示 通过反射获取类/方法上的注解 以及其中的内容
 */
public class GetAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        final Class<Test> clazz = Test.class;
        //获取Test类上的所有注解
        final Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            //获取注解类型
            System.out.println(annotation.annotationType());
            //判断该注解是否为TestMyAnnotation
            System.out.println(annotation instanceof TestMyAnnotation);
            //获取在注解中写入的内容
            System.out.println(((TestMyAnnotation) annotation).value());
        }

        System.out.println("========================================");

        //获取Test类的eat方法上的注解
        final Method method = clazz.getMethod("eat");
        final Annotation[] methodAnnotations = method.getAnnotations();
        for (Annotation methodAnnotation : methodAnnotations) {
            //获取注解类型
            System.out.println(methodAnnotation.annotationType());
            //判断该注解是否为TestMyAnnotation
            System.out.println(methodAnnotation instanceof TestMyAnnotation);
            //获取在注解中写入的内容
            System.out.println(((TestMyAnnotation) methodAnnotation).value());
        }
    }
}
