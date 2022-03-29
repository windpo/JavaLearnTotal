package function;

/**
 * 1、java中如何给类成员变量设置默认值：在构造方法中直接赋值
 * 2、java构造方法的重载：java构造方法重载，与函数签名有关，相同类型如String name和String gender不能重载
 */
public class ConstractorTest {
    private String name;
    private int age;
    private String gender;
    //有参数的构造方法
    public ConstractorTest(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public ConstractorTest(String name) {
        this.name = name;
    }
    public ConstractorTest(int age) {
        this.age = age;
    }

    //无参数的构造方法
    public ConstractorTest() {
        this.name="unnamed";
        this.age=18;
        this.gender="M";
    }
}
