package LXYjavaLearn_reflection.creat_use_get_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 风之诗
 * @version 1.0
 * 演示如何自定义自己的注解,包含注解的属性（以无参方法形式呈现）
 */
//下面两个都为元注解，第一个表示该注解作用的目标（是作用在类/方法还是变量）。第二个表示限定作用域（是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问）
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestMyAnnotation {
    String value() default "";
}
