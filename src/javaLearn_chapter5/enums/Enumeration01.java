package javaLearn_chapter5.enums;

/**
 * 1、枚举的使用：
 *      （1）、所需场景：有限的几个值，只读，不需要修改。
 *      （2）、定义：枚举--->属于一种特殊的类，里面只包含一组有限的特定的对象。
 * 2、通过enum关键字实现枚举类
 * @author 风之诗
 * @version 1.0
 */
public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}

/**
 * 1、使用枚举关键字定义枚举类
 */
enum Season{
    //2、将定义的常量写在最前面(枚举对象必须放在枚举类的行首)
    SPRING("春天","温暖"),SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");
    /**
     * 3、再定义关键字
     */
    private String name;
    private String decs;

    Season(String name, String decs) {
        this.name = name;
        this.decs = decs;
    }

    public String getName() {
        return name;
    }

    public String getDecs() {
        return decs;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", decs='" + decs + '\'' +
                '}';
    }
}
