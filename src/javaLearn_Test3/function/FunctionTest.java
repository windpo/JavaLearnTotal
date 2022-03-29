package function;

/**
 * 测试java中的方法 静态方法
 *
 * 可变参数：
 * 在定义方法时，在最后一个形参后加上三点 …，就表示该形参可以接受多个参数值(0-多)，多个参数值被当成数组传入。上述定义有几个要点需要注意：
 *      1、可变参数只能作为函数的最后一个参数，但其前面可以有也可以没有任何其他参数
 *      2、由于可变参数必须是最后一个参数，所以一个函数最多只能有一个可变参数
 *      3、Java的可变参数，会被编译器转型为一个数组
 *      4、可变参数的方法签名同数组一致
 *      5、方法重载：如果max(1,2)同时满足普通方法和可变参数方法，则会优先满足可变参数方法
 */
public class FunctionTest {
    public static void main(String[] args) {
        int a=1,b=2;
        int k=max(a,b);//某类主函数中调用该类的静态方法，可以省略类名
        int numax=max(2,4,5,6,3,1,20,35);
        System.out.printf("%d,%d",a,b);
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static int max(int... nums){
        if(nums.length==0){
            System.out.println("No paramter");
            return 0;
        }
        else {
            int max=nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]>max);
                max=nums[i];
            }
            return max;
        }
    }
}
