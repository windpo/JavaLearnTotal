package HSPjavaLearn_FileLearn.outputstream_;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author 风之诗
 * @version 1.0
 */
//如果需要序列化某个对象，就必须要实现Serializable接口（标记接口，不需要实现方法）
public class Dog implements Serializable {
    private String name;
    private int age;
    //serialVersionUID,序列化的版本号，可以提高兼容性（对对象的属性进行修改会认为是对版本的升级而不是改变序列化）
    @Serial
    private static final long serialVersionUID=1L;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
