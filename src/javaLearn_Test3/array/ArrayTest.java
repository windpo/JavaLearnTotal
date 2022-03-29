package array;

/**
 * 数组的声明、定义以及初始化
 */
public class ArrayTest {
    private   int[] ages;//数组的定义
    private   String[] names={"小明"};//数组的定义以及初始化
    private   double[] grades=new double[5];
    public static void main(String[] args) {
        //方式1
        int[] ages;//数组的声明
        ages=new int[10];//数组的定义
        //方式2
        double[] grades=new double[5];//数组的定义
        //方式3
        String[] names={"小明"};//数组的定义以及初始化
        //foreach循环控制数组
        ages[0]=10;
        ages[1]=5;
        ages[4]=20;
        for(int age:ages){
            System.out.println(age);
        }
        //数组传入函数
        Fun.printArray(names);
        //数组作为返回值
        int[] years = Fun.copyArray(ages);
    }
}
//数组作为函数形参
class Fun{
    static void printArray(String[] array){
        for(String single:array){
            System.out.println(single);
        }
    }
    //数组作为返回值
    static int[] copyArray(int[] array){//数组的复制也可以直接用等号
        int[] result=new int[array.length];
        int i=0;
        for (int age :
                array) {
            result[i]=age;
            i++;
        }
        return result;
    }
}
