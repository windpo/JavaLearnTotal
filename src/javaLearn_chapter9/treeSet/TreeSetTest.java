package javaLearn_chapter9.treeSet;

import java.util.*;

/**
 * @author 风之诗
 * @version 1.0
 * 演示TreeSet的使用，分别用两种方法来定义TreeSet的排序方式，分别通过商品号来对比，或者通过商品信息来对比
 *      TreeSet：树集，一个有序表，值将自动按照排序后的顺序呈现，其中元素必须可比较，适用于按一定顺序存储的数据
 *      1、通过在TreeSet的构造器中传入一个Comparator.comparing方法
 *      2、类元素要实现Comparable接口来指定排序方式
 *      3.1、TreeSet中的不重复是指的是按自己排序方式的不重复，如果毕竟字符串长度大小，”ghs“和”13s“算作重复元素
 *      3.2、comparing方法返回大于0则该元素更大，返回小于0则该元素更小，返回等于0该元素重复
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //按商品定义的方式排序：先排序商品号再排序商品描述
        TreeSet<Item> items = new TreeSet<>();
        items.add(new Item("Toaster",1234));
        items.add(new Item("Widget",4562));
        items.add(new Item("Modem",9912));

        System.out.println(items);

        //按自己实现的Comparator中的comparing方式来排序
        final TreeSet<Item> itemSortByDes = new TreeSet<>(Comparator.comparing(Item::getDescription));

        //将items集合中的元素添加到该类中
        itemSortByDes.addAll(items);
        System.out.println(itemSortByDes);
    }
}
class Item implements Comparable<Item>{
    /**
     * 商品的描述和商品号
     */
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    /**
     *  通过商品号以及商品的描述比较商品
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return partNumber == item.partNumber && Objects.equals(description, item.description);
    }

    /**
     * 通过商品的描述以及商品号生成hash码
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    /**
     * 自定义比较方法：先比较商品号，若商品号一致，则比较商品的描述
     * @param other
     * @return
     */
    @Override
    public int compareTo(Item other){
        final int diff = Integer.compare(partNumber, other.partNumber);
        return diff !=0?diff:description.compareTo(other.description);
    }
}
