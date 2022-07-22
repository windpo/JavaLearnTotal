package javaLearn_chapter9.treemap;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author 风之诗
 * @version 1.0
 *    TreeMap（对key值按照指定的方法进行排序）:
 *      1、方法一：传入Comparator方法/类自己实现Comparator方法
 *      2、方法二：类元素要实现Comparable接口来指定排序方式
 */
public class TreeMapTest {
    public static void main(String[] args) {
        final TreeMap<Object, Object> treeMap = new TreeMap<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo(((String) o2));
            }
        });
        treeMap.put("jack","杰克");
        treeMap.put("tom","汤姆");
        treeMap.put("kristina","克瑞斯缇娜");
        treeMap.put("smith","斯密斯");

        System.out.println("treemap="+treeMap);


    }
}
