package java_homework;


import java.util.Scanner;

/**
 * @author 风之诗
 * @version 1.0
 */
public class SumOfArray {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int M,N;
        N=scanner.nextInt();
        M=scanner.nextInt();
        final int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i]=scanner.nextInt();
        }
        System.out.println(SumOfArray.solve(numbers, N, M));
    }

    static int solve(int[] arr, int n, int m) {
        // 请添加具体实现
        int times=0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i]+arr[j]==m){
                    times++;
                }
            }
        }
        return times;
    }
}
