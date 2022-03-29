package varParameter;

import java.util.List;
import java.util.Scanner;

/**
 * @author 风之诗
 * 利用可变参数，将一个学生的名字以及他n门课的成绩返回
 */
public class VarParameter03_example {
    public static void main(String[] args) {
        HspMethod xuyang = new HspMethod();
        System.out.println(xuyang.showScore("p", 13, 15, 16));
        System.out.println(xuyang.showScore("yang", 98, 55, 34, 10.2, 34.1));
    }
}
class HspMethod{
    /**
     * 将名字和所有的成绩封装为String字符串返回
     * @param name
     * @param scores
     * @return
     */
    String showScore(String name,double... scores){
        double sum=0;
        for (double num :
                scores) {
            sum+=num;
        }
        /**
         * 如何将一个基本数据类型转化为字符串或将字符串转化为基本数组类型
         *      基本数据类型转化为字符串：
         *          int c=10;
         *          1、使用包装类的toString()方法；  Inter.toString(c)
         *          2、使用String类的valueOf()方法； String.valueOf(c)
         *          3、使用一个空字符串加上基本类型。   c+""
         *      将字符串转换成基本数据类型:
         *          string str="8";
         *          1、调用包装类的parseXXX()方法；
         *          2、调用包装类的valueOf()方法转换为基本数据类型的包装类。再将包装类（自动拆箱）并赋值给基本数据类型
         */
        //String result=String.valueOf(sum);
        //String result = Double.toString(sum);
        //String result= name+sum;
        return name+"的"+scores.length+"门课成绩为"+sum;

    }
}
