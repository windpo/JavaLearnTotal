package java_homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 风之诗
 * @version 1.0
 * 知识点：抽象类，字符串的比较，整数与字符串的混合输入
 * PTA4-1
 * 本题描述
 * 1.定义抽象类Shape
 * 属性：不可变静态常量double PI，值为3.14，
 * 抽象方法:public double getPerimeter(),public double getArea()
 *
 * 2.Rectangle与Circle类均继承自Shape类。
 * Rectangle类(属性：int width,length)、Circle类(属性：int radius)。
 * 带参构造方法为Rectangle(int width,int length),Circle(int radius)。
 * toString方法(Eclipse自动生成)
 *
 * 3.编写double sumAllArea方法计算并返回传入的形状数组中所有对象的面积和与
 * double sumAllPerimeter方法计算并返回传入的形状数组中所有对象的周长和。
 *
 * 4.main方法
 * 4.1 输入整型值n，然后建立n个不同的形状。如果输入rect，则依次输入宽、长。如果输入cir，则输入半径。
 * 4.2 然后输出所有的形状的周长之和，面积之和。并将所有的形状信息以样例的格式输出。 提示：使用Arrays.toString。
 * 4.3 最后输出每个形状的类型与父类型.使用类似shape.getClass() //获得类型, shape.getClass().getSuperclass() //获得父类型;
 *
 * 注意：处理输入的时候使用混合使用nextInt与nextLine需注意行尾回车换行问题。
 *
 * 思考
 * 你觉得sumAllArea和sumAllPerimeter方法放在哪个类中更合适？
 * 是否应该声明为static?
 * 输入样例:
 * 4
 * rect
 * 3 1
 * rect
 * 1 5
 * cir
 * 1
 * cir
 * 2
 * 输出样例:
 * 38.84
 * 23.700000000000003
 * [Rectangle [width=3, length=1], Rectangle [width=1, length=5], Circle [radius=1], Circle [radius=2]]
 * class Rectangle,class Shape
 * class Rectangle,class Shape
 * class Circle,class Shape
 * class Circle,class Shape
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入的总数量
        final int N=scanner.nextInt();
        scanner.nextLine();
        Shape[] shapes = new Shape[N];
        String type;
        for (int i = 0; i < N; i++) {
            type=scanner.nextLine();
            if(type.equals("rect")){
                shapes[i]=new Rectangle(scanner.nextInt(),scanner.nextInt());
                scanner.nextLine();
            } else if(type.equals("cir")){
                shapes[i]=new Circle(scanner.nextInt());
                scanner.nextLine();
            }
        }
        System.out.println(Shape.sumAllPerimeter(shapes));
        System.out.println(Shape.sumAllArea(shapes));
        System.out.println(Arrays.toString(shapes));
        for (Shape s :
                shapes) {
            System.out.println(s.getClass()+","+s.getClass().getSuperclass());
        }
    }
}
abstract class  Shape{
    public static final double PI=3.14;//定义常量
    public abstract double getPerimeter();//定义抽象方法
    public abstract double getArea();//定义抽象方法
    //照那个思考里面的第一个和第二个问题，我觉得应该把那两个方法放在抽象类里面
    //且要定义为static静态方法，因为Shape类为这两个方法都不需要获取Shape的属性，所以可以直接弄成静态方法更方便操作
    //然后因为这两个方法都和Shape类的子类相关，这个类是最好放的地方。
    static double sumAllArea(Shape[] shapes){
        double result=0;
        //创建一个对象数组，直接获取它子类的面积，然后把它加到一个结果里面
        for (Shape s :
                shapes) {
            result+=s.getArea();
        }
        return result;
    }
    static double sumAllPerimeter(Shape[] shapes){
        double result=0;
        //同上，直接获取它子类的周长
        for (Shape s :
                shapes) {
            result+=s.getPerimeter();
        }
        return result;
    }
}
//类中的构造函数，toString方法等等都可以用idea自动生成，有快捷键的，我教你
class Rectangle extends Shape{
    private int width,length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+length);
    }

    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public String toString() {
        return "Rectangle [" +
                "width=" + width +
                ", length=" + length +
                ']';
    }
}
class Circle extends Shape{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2*PI*radius;
    }

    @Override
    public double getArea() {
        return PI*Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "Circle [" +
                "radius=" + radius +
                ']';
    }
}