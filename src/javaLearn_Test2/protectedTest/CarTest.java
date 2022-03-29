package protectedTest;

import protectEx.Car;

public class CarTest extends Car {
    public static void main(String[] args) {
        CarTest carTest=new CarTest();
        Car car=new CarTest();
        carTest.buy();
        //被protect修饰的方法在不同包中仅能访问其子类实例继承的方法
//        car.buy();  error
    }
}
