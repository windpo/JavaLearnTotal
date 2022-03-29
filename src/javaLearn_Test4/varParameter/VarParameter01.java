package varParameter;


/**
 * @author 风之诗
 * 可变参数概念：当方法名称相同，功能相同，参数个数不同，使用可变参数优化
 *      特点：
 *      1、int...  表示可以接受可变参数，接受的个数为（0到多）个int型参数
 *      2、使用可变参数时，可以当作数组来使用
 */
public class VarParameter01 {
    public static void main(String[] args) {
        int[] numbers= {4, 5, 3};
        int sum = VarParameter01.sum(numbers[0], numbers[1], numbers[2],100);
        System.out.println(sum);
    }

    /**
     * 求n个数的和
     * @param nums
     * @return
     */
    static  int sum(int... nums){
        System.out.println("参数个数："+nums.length);
        int sum=0;
        for (int i :
                nums) {
            sum+=i;
        }
        return sum;
    }
}
