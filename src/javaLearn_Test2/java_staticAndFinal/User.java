package java_staticAndFinal;

public class User {
    public static int salary=200;
    public static final int SALARY=100;
    private int salarys=300;
    public int getsalarys(){
        return salarys;
    }
}
class Test{
    public static void main(String[] args) {
        //静态常量，直接使用类中的常量
        System.out.println("静态常量:"+User.SALARY);
        //静态变量，直接使用类中的变量
        System.out.println("静态变量第一次在Test中:"+User.salary);
        User.salary++;
        //实例变量，首先需要创建实例对象
        User user=new User();
        System.out.println("实例变量："+user.getsalarys());
        //测试静态变量和c中的静态变量具有同一性质
        StaticTest staticTest=new StaticTest();
        staticTest.add();
        System.out.println("静态变量加两次后在Test中"+User.salary);

    }
}

class StaticTest{
        public void add() {
            User.salary++;
        }
    }

