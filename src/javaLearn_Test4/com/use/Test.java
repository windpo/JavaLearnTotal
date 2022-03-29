//package作用为声明当前所在类的包，需要放在类的最上面，且一个类中最多有一个package语句
package com.use;
//import指令必须放在package下面，在类前定义，可以有多句且没有顺序要求
import com.xinyu.Dog;

/**
 * @author 风之诗
 * 关于包的使用以及命名冲突：
 *      1、包的实质为文件夹，用来方便管理文件以及解决命名冲突等问题
 *          com.xuyang实际为两层包，其中.的前后在文件夹中在不同的层级
 *      2、类的实际名称以及同一个类名的解决方式
 *          实际名称：如：Dog类：实际上有两个名称，一个是com.xuyang.Dog,另外一个是com.xinyu.Dog
 *          如何使用同名类：
 *              （1）、通过直接导入该类，就可以直接指定所用的类为导入类的Dog（仅能导入一个）
 *              （2）、通过类的全名直接导入该类
 *关于包的导入（Import）小细节：
 *      1、尽量做到需要哪个类就导入哪个类，不建议用*
 *      2、import指令必须放在package下面，在类前定义，可以有多句且没有顺序要求
 * 关于包的声明package：package作用为声明当前所在类的包，需要放在类的最上面，且一个类中最多有一个package语句
 *
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);
        com.xuyang.Dog dog1 = new com.xuyang.Dog();
        System.out.println(dog1);

    }
}
