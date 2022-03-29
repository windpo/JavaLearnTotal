package recurion;

/**
 * @author 风之诗
 * 利用递归求阶乘以及斐波那契数列
 * 猴子吃桃问题
 */
public class Recurion02 {
    /**
     * 求阶乘
     * @param n
     * @return
     */
    int factorial(int n){
        if(n==1){
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    /**
     * 递归求斐波那契数列
     * 缺点：容易造成栈溢出
     * @param n
     * @return
     */
    int fibonacci(int n){
        if(n==1||n==2){
            return 1;
        }
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    /**
     * 法二：找规律
     * @param n
     * @return
     */
    int fibonacci2(int n){
        int a=1,b=1;
        if(n==1||n==2){
            return 1;
        }
        else{
            for (int i = 0; i < n-2; i++) {
                a+=b;
                b=a-b;
            }
            return a;
        }

    }

    /**
     * 猴子吃桃问题
     * @param n
     * @return
     */
    int funOfEat(int n){
        if(n==1){
            return 1;
        }
        else{
            return (funOfEat(n-1)+1)*2;
        }
    }
    public static void main(String[] args) {
        int n=5;
        Recurion02 recurion02 = new Recurion02();
        int factorial = recurion02.factorial(n);
        System.out.println(factorial);
        System.out.println("======");

        int fibonacci = recurion02.fibonacci2(7);
        System.out.println(fibonacci);

        System.out.println("======");
        int numOfPeach = recurion02.funOfEat(2);
        System.out.println(numOfPeach);
    }
}
