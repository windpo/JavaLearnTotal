package Java_scanner_demo;
import java.util.*;
public class DoubleScanner {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        double sum=0;
        int count=0;
        System.out.println("Please enter some numbers(end with #)");
        //通过Scanner类创建一个对象，然后
        while(reader.hasNextDouble()){//hasNextDouble方法等待用户输入数据
            double x=reader.nextDouble();//nextDouble方法读取用户输入数据
            count++;
            sum+=x;
        }
        System.out.println("The average of those number is: "+sum/count);
        System.out.printf("The sum of those number is %d",(int)sum);//和c语言中用法相同

    }
}
