package java_homework.experiment1;

import java.util.Scanner;

/**
 * @author 风之诗
 * @version 1.0
 */
public class TrangleTest {
    public static void main(String[] args){
        double a,b,c;
        double[] numbers=new double[3];
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<3;i++){
            numbers[i]=scanner.nextInt();
        }
        a=numbers[0];
        b=numbers[1];
        c=numbers[2];
        if(Math.abs(a+b-c)>0){
            if(a==b&&a==c&&b==c){
                System.out.println("等边三角形");
            }else {
                if(a==b||a==c||b==c){
                    System.out.println("等腰三角形");
                }
                if(Math.abs(a*a+b*b-c*c)<=0.001){
                    System.out.println("直角三角形");
                }
            }

        }else {
            System.out.println("不为三角形");
        }
    }
}
