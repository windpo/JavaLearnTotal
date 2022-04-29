package javaLearn_chapter8.pair1;

/**
 * @author 风之诗
 * @version 1.0
 * 泛型类使用演示
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words={"Mary","had","a","little","lamb"};
        final Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min= "+mm.getFirst());
        System.out.println("max= "+mm.getSecond());
    }
}

/**
 * 使用Pair<String>作为函数的返回值，返回一个包含有最大字符串和最小字符串的对象
 */
class ArrayAlg
{
    public static Pair<String> minmax(String[] a){
        /**
         * 得到一堆字符串中的最大值和最小值
         */
        if(a==null||a.length==0){
            return null;
        }
        String min=a[0];
        String max=a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i].compareTo(max)>0){
                max=a[i];
            }
            if(a[i].compareTo(min)<0){
                min=a[i];
            }
        }
        return new Pair<>(min,max);
    }
}
