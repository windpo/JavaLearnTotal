package java_array_demo;
import javax.xml.ws.Action;
import java.util.*;
//创建一个班的成绩并进行排名
//字符串的输入？
//多组数组的输入？
//数组怎么传入函数
//如何使用抽象类建立一个方法并实现
class Student{
    int ID;
    int score;
    String name;
    int rank;
}
public class ClassScore {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入学生的人数,以#结束");
        int size=0;
        while(reader.hasNextInt()){
            size=reader.nextInt();
        }
        Student mystudent[]=new Student[size];
        ClassScore p1 = new ClassScore() {
            Scanner reader = new Scanner(System.in);
            public void input(Student a[], int size) {
                for (int i = 0; i < size; i++) {
                    a[i].score = reader.nextInt();
                }
            }
        };


    }

}
