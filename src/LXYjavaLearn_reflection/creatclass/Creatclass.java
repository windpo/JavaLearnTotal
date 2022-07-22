package LXYjavaLearn_reflection.creatclass;

import java.lang.reflect.Constructor;

/**
 * @author 风之诗
 * @version 1.0
 * 演示如何通过获取类的构造器来创建对象
 * 以及如何通过获取类的私有构造器来创建对象
 */
public class Creatclass {
    public static void main(String[] args) throws ReflectiveOperationException {
        //通过获取构造器来创建对象
        final Class<Student> studentClass = Student.class;
        //获取构造器（传入的参数为构造器的构造参数的Class，来指定构造器）
        final Student student = studentClass.getConstructor(String.class).newInstance("刘旭阳");
        student.test();

        //通过获取类的私有构造器来创建对象
        //获取构造器
        final Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(Integer.class);
        //修改私有构造器的获取权限
        declaredConstructor.setAccessible(true);
        final Student student1 = declaredConstructor.newInstance(11);
        student1.test();
    }
}
class Student{
    String name;
    Integer grade;

    private Student(Integer grade) {
        this.grade = grade;
    }

    public Student(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println("在图书馆学习");
    }

    public void test2(String content){
        System.out.println("在图书馆学习"+content);
    }
}
