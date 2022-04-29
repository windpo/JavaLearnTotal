package java_homework;

import java.util.ArrayList;

import static java.lang.Math.pow;

/**
 * @author 风之诗
 * @version 1.0
 * 设计一个抽象类，利用抽象方法计算底面积不同体积的柱体，并用该抽象类作为参数类型接收其子类调用子类具体方法
 */
public abstract class Pillar {
    private double height;

    public Pillar(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public abstract void CaculateVolume();

    public static void main(String[] args) {
        ArrayList<Pillar> pillars = new ArrayList<>();
        pillars.add(new Rectangle1(1,1,1));
        pillars.add(new Circle1(1,1));
        for (Pillar p :
                pillars) {
            p.CaculateVolume();
        }
    }
}

class Rectangle1 extends Pillar {
    private double length;
    private double width;

    public Rectangle1(double height,double length, double width) {
        super(height);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void CaculateVolume() {
        System.out.println("The Volume of the RectanglePillar is:"+length*width*super.getHeight());
    }
}
class Circle1 extends Pillar{
    private double radius;

    public Circle1(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void CaculateVolume() {
        System.out.println("The Volume of the CirclePillar is:"+radius*3.14*pow(radius,2)*super.getHeight());
    }
}