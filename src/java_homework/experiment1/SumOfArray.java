package java_homework.experiment1;

/**
 * @author 风之诗
 * @version 1.0
 */
public class SumOfArray {
    public static void main(String[] args){
        int num=1,c=1;
        double result=0;
        for(int i=1;i<=100;i++){
            result+=(1.0/num)*c;
            num+=2;
            c*=(-1);

        }
        System.out.println("结果为："+result);
    }
}
