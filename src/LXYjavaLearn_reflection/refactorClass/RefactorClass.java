package LXYjavaLearn_reflection.refactorClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 风之诗
 * @version 1.0
 */
public class RefactorClass {
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final Class<Student> clazz = Student.class;
        final Student student = clazz.newInstance();
        //获取私有成员字段name
        final Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student,"巴巴托斯");

        clazz.getMethod("work").invoke(student);

    }
}
class Student{
    private String name;
    private final int grade=100;
    public void work(){
        System.out.println(name+"正在工作");
    }
}
