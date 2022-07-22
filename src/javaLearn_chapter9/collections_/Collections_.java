package javaLearn_chapter9.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 风之诗
 * @version 1.0
 *  Collections工具类：对集合进行一系列的操作
 *      演示Collections的一些常见方法操作
 *        1、反转List中元素的操作            Collections.reverse(list);
 *        2、对List集合元素进行随机排序            Collections.shuffle(list);
 *        3、对List集合进行自然排序                  Collections.sort(list);
 *        4、按照自己定义的排序方法进行排序                Collections.sort(list, new Comparator<String>()
 *        5、将指定的list集合中的i处元素和j处元素进行交换           Collections.swap(list,0,1);
 *        6、根据元素的自然顺序，返回给定集合中的最大元素
 *        7、根据Comparator指定的顺序，返回给定集合中的最大元素
 *        8、最小值同理
 *        9、返回指定排序方式中指定元素出现的次数
 *        10、复制另外一个集合中的内容（新的集合的大小需大于等于原集合）
 *        11、使用新值替换List对象的所有旧值
 */
public class Collections_ {
    public static void main(String[] args) {
        final ArrayList<String> list = new ArrayList<>();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        System.out.println("list="+list);

        //1、反转List中元素的操作
        System.out.println("=========对list集合中的元素进行反转==========");
        Collections.reverse(list);
        System.out.println("list="+list);

        //2、对List集合元素进行随机排序
        System.out.println("========对list集合中的元素进行随机排序========");
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(list);
            System.out.println("list="+list);
        }

        //3、对List集合进行自然排序
        System.out.println("========对list集合中的元素进行自然排序========");
        Collections.sort(list);
        System.out.println("list="+list);

        //4、按照自己定义的排序方法进行排序
        System.out.println("========按照自己定义的排序方法进行排序========");
        Collections.sort(list, Comparator.comparing(String::length));
        System.out.println("list="+list);

        //5、将指定的list集合中的i处元素和j处元素进行交换
        System.out.println("========将指定的list集合中的i处元素和j处元素进行交换=========");
        Collections.swap(list,0,1);
        System.out.println("list="+list);

        //6、根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println("====返回自然顺序最大元素=======");
        System.out.println(Collections.max(list));

        //7、根据Comparator指定的顺序，返回给定集合中的最大元素
        System.out.println("====返回给定集合中的最大元素====");
        System.out.println(Collections.max(list, Comparator.comparing(String::length)));

        //8、最小值同理
        //9、返回指定排序方式中指定元素出现的次数
        System.out.println("====返回指定集合中tom出现的次数====");
        System.out.println(Collections.frequency(list, "tom"));

        //10、复制另外一个集合中的内容
        System.out.println("====复制另外一个集合中的内容====");
        //为了完成一个拷贝，我们需要先给dest赋值，大小和list.size()一样
        final ArrayList<String> dest = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest,list);
        System.out.println("dest="+dest);

        //11、使用新值替换List对象的所有旧值
        //如果list中有tom就全部替换成汤姆
        Collections.replaceAll(list,"tom","汤姆");
        System.out.println("list替换后="+list);
    }
}
