package java_homework;

/**
 * @author 风之诗
 * @version 1.0
 */
public class Test1{
    public static void main(String[] args) {
        final MyRectangle myRectangle1 = new MyRectangle(2, 4);
        System.out.println(myRectangle1);
        final MyRectangle myRectangle2 = new MyRectangle();
        myRectangle2.setLength(1);
        myRectangle2.setWidth(2);
        System.out.println(myRectangle2);
    }
}
class MyRectangle {
    private double length;
    private double width;

    public MyRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public MyRectangle() {
        length=0;
        width=0;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getArea(){
        return length*width;
    }

    @Override
    public String toString() {
        return "MyRectangle{" +
                "length=" + length +
                ", width=" + width +
                ", Area="+getArea()+
                '}';
    }
}
