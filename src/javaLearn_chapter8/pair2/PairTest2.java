package javaLearn_chapter8.pair2;

import javaLearn_chapter8.pair1.Pair;

import java.time.LocalDate;

/**
 * @author 风之诗
 * @version 1.0
 * 演示类型变量限定的使用
 *      类型变量限定：
 *          0、限制的变量类型既可以是类，也可以是接口
 *          1、如何限制类型变量 <T extends Comparable>指任意实现了（子类）Comparable的类型
 *          2、限制多个类型变量 <T extends A&B>指任意实现了（子类） A和B的类型
 *          3、最多有一个限定可以是类，如果有一个类作为限定，它必须为限定列表中的第一个限定
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays={
                LocalDate.of(1906,12,9),
                LocalDate.of(1815,12,10),
                LocalDate.of(1903,12,3),
                LocalDate.of(1910,6,22),
        };
        Pair<LocalDate> mm=ArrayAlg.minmax(birthdays);
        System.out.println("min= " + mm.getFirst());
        System.out.println("max= " + mm.getSecond());
    }
}
class ArrayAlg{
    /**
     * 比较得到任意对象T数组中的最大值和最小值
     */
    public static <T extends Comparable>Pair<T>minmax(T[] a){
        if(a==null||a.length==0){
            return null;
        }
        T min=a[0];
        T max=a[0];
        for (int i = 1; i < a.length; i++) {
            if(min.compareTo(a[i])>0){
                min=a[i];
            }
            if(max.compareTo(a[i])<0){
                max=a[i];
            }
        }
        return new Pair<T>(min,max);
    }
}
