package javaLearn_chapter9.priorityQueue;


import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author 风之诗
 * @version 1.0
 *  演示优先队列的使用
 *      1、优先队列在遍历时不会按照从小到大的顺序开始遍历，但删除时会从最小开始删除，其内部实质为二叉树，有内部顺序
 *      2、PriorityQueue在创建时需要有两种方式来确定内部元素的比较方式。
 *      其一是通过子类实现Comparable
 *      其二是在传入构造器一个Comparator
 *      3、构造器内能指定开始的容量
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815,12,10));
        pq.add(LocalDate.of(1903,12,3));
        pq.add(LocalDate.of(1910,6,22));
        //使用迭代器遍历所有元素
        System.out.println("Iterating overt elements...");
        for (LocalDate date :
                pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements...");
        //删除所有元素
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}
