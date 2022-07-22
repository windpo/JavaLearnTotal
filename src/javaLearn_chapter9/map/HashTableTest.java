package javaLearn_chapter9.map;

import java.util.*;

/**
 * @author 风之诗
 * @version 1.0
 * HashTable的基本介绍以及其使用
 *  1、存放的元素是键值对：即k-v
 *  2、hashtable的键和值都不能为null
 *  3、hashTable使用方法基本上和HashMap一样
 *  4、hashTable是线程安全的，hashMap是线程不安全的
 *
 *  和HaspMap对比：
 *      1、HashTbale为线程安全，但效率较低，也不允许null键null值
 */
public class HashTableTest {
    public static void main(String[] args) {
        final Hashtable<String, Employee> staff = new Hashtable<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-24-2546",new Employee("Harry Hacker"));
        staff.put("157-62-7935",new Employee("Gary Cooper"));
        staff.put("456-62-5527",new Employee("Francesca Cruz"));
        //打印所有元素
        System.out.println(staff);

        //删除一个元素
        staff.remove("567-24-2546");

        //替换一个元素
        staff.put("456-62-5527",new Employee("Francesca Miller"));

        //获取一个元素
        System.out.println(staff.get("157-62-7935"));


        //第一组：先取出所有的Key，通过Key取出对应的Value(keyset集合：包含一些key值的集合)
        final Set<String> keyset = staff.keySet();
        final Iterator<String> iterator = keyset.iterator();
        //(1)增强for循环
        System.out.println("-----第一组第一种方式------");
        keyset.forEach((k)->{
            System.out.println(k+"    "+staff.get(k));
        });

        //(2)迭代器访问
        System.out.println("--------第一组第二种方式----");
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key+"         "+staff.get(key));
        }
        //第二组：把所有的values取出

        //1、foreach循环
        System.out.println("=====第二组第一种方式=====");
        final Collection<Employee> values = staff.values();
        values.forEach(System.out::println);

        //第三组：通过entrySet（）方法条目获取所有的key和value

        //1、entrySet（） 会将Map里面的k-v对放在该集合里面，然后返回一个EntrySet集合
        //在该集合中包含元素类型Map.Entry<k,v>，包含一对键值对。同时，该元素实际上指向HashMap中的内部类HashMap.Node
        //newNode(hash,key,value,null)为其中的一个节点
        System.out.println("=====第三组第一种方式=====");
        for (var entry :
                staff.entrySet()) {
            System.out.println("Map: key= "+entry.getKey()+",value= "+entry.getValue());
        }

        //2、forEach方法和lambda表达式遍历所有元素
        System.out.println("======第三组第二种方式=====");
        staff.forEach((String k,Employee v)->{
            System.out.println("key="+k+",value="+v);
        });
    }
}
