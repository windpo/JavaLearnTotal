package extend;

/**
 * 测试java与c++构造器能否继承，private属性能否继承，以及父类指针super
 */
class Student{
    private String name;
    private int age;
    private int score;
    private String gender;


    //getter方法
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public String getGender() {
        return gender;
    }
    //构造器方法
    public Student() {
    }
    public Student(String name, int age, int score, String gender) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.gender = gender;
    }
    //成员方法
    void printScore(){
        System.out.println(score);
    }
}
class Colloege extends Student{
    //注：1、java中构造器无法被继承,不过可以通过super关键字调用父类构造器
    public Colloege(String name, int age, int score, String gender) {
        super(name, age, score, gender);
    }

    //2、private属性的成员无法被继承,但可以用super关键字获取父类的成员函数

    @Override
    void printScore() {
        System.out.println("调用父类的方法.....");
        super.printScore();
        System.out.println("获取并输出父类的成员");
        System.out.println("获取父类的成绩："+super.getScore());
    }

}
public class ExtendTest {
    public static void main(String[] args) {
        Colloege colloege = new Colloege("xuyang",18,100,"M");
        colloege.printScore();
    }
}