package javaLearn_chapter6.innerClass;

/**
 * @author 风之诗
 * @version 1.0
 * 演示静态内部类的使用，实现一个方法返回比较数组的最大数和最小数
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] values = new double[20];
        for (int i = 0; i < values.length; i++) {
            values[i]=100*Math.random();

        }
        ArrayAlg.Pair minmax = ArrayAlg.minmax(values);
        System.out.println("min="+minmax.getFirst());
        System.out.println("max="+minmax.getSecond());
    }
}
class ArrayAlg{
    /**
     * 定义一个静态内部类Pair，其中包含有一个最小值一个最大值
     */
    public static class Pair{
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    /**
     * 通过设置一个min和max来比较一个数组中的最大值和最小值
     * @param values 传入比较的数组
     * @return 返回一个Pair内部类，其中包含有两个值，分别为最大值和最小值
     */
    public static Pair minmax(double[] values){
        double min=Double.POSITIVE_INFINITY;
        double max=Double.NEGATIVE_INFINITY;
        for (double v :
                values) {
            if (min>v){
                min=v;
            }
            if(v>max){
                max=v;
            }
        }
        return new Pair(min,max);
    }
}
