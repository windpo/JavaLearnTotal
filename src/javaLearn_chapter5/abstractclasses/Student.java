package javaLearn_chapter5.abstractclasses;

/**
 * @author 风之诗
 */
public class Student extends Person{
    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }
    //重写父类的抽象方法
    @Override
    public String getDescription() {
        return "a student majoring in"+major;
    }
}
