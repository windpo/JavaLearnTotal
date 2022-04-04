package javalearn_homework;

/**
 * @author 风之诗
 * 设计点、圆以及圆柱体的三层继承关系
 */
class Point {
    private int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
class Circle extends Point{
    private double radius;
    
    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }
    public Circle() {
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
    
    public double getArea(){
        return 3.14*radius*radius;
    }
}
class Clider extends Circle{
    private double height;

    public Clider() {
    }
    public Clider(int x, int y, double radius, double height) {
        super(x, y, radius);
        this.height = height;
    }
    public double getHight() {
        return height;
    }
    public void setHight(double hight) {
        this.height = hight;
    }
    @Override
    public String toString() {
        return "Clider{" +
                "height=" + height +
                '}';
    }

    @Override
    public double getArea(){
       return super.getArea()*height;
    }
    public double getVolume(){
        return 2 * 3.14 * super.getRadius() * height;
    }
}
