package javaLearn_chapter9.linkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author 风之诗
 * @version 1.0
 * 演示链表LinkedList的一些操作方法
 *      linkedList，继承abstractList，为一个有序可重复集合，适用于高效从任意位置插入删除元素，不适用于通过下标访问元素
 *  1、将b的所有元素合并到a
 *  2、隔空移除b的元素
 *  3、移除a中包含b的所有元素
 */
public class LinkedListTest {
    public static void main(String[] args) {
        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //a为可读可增迭代器，b为不可增迭代器
        final ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        /**
         * 隔空将b的所有元素合并到a
         */
        //遍历所有b的元素，将b全部添加到a
        while(bIter.hasNext()){
            //a如果有下一个元素，就将a往下移，然后将b添加上去，如果没有，那就直接将b添加到末尾
            if(aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }

        System.out.println(a);

        /**
         * 隔空移除b的元素
         */
        bIter=b.iterator();
        while(bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        /**
         * 移除a中包含b的所有元素
         */
        a.removeAll(b);

        System.out.println(a);
    }
}
