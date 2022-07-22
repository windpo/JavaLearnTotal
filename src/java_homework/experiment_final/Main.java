package java_homework.experiment_final;

import java.util.Random;

/**
 * @author 风之诗
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //产生随机数
        final Random random = new Random();
        final int[] ints = new int[100];
        for (int i = 0; i < 100; i++) {
            ints[i]=random.nextInt();
        }
        //冒泡算法排序
        boolean isprime;
        int temp=0;
        for (int i = 0; i <ints.length-1; i++) {
            isprime=false;
            for (int j = 0; j < ints.length-1-i; j++) {
                if(ints[j]>ints[j+1]){
                  temp=ints[j];
                  ints[j]=ints[j+1];
                  ints[j+1]=temp;
                  isprime=true;
                }
            }
            if(!isprime){
                break;
            }
        }
        int count=0;
        for (int num :
                ints) {
            count++;
            System.out.print(num+"   ");
            if(count%5==0){
                System.out.println();
            }
        }

    }
}
