package javaLearn_chapter9.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 风之诗
 * @version 1.0
 * 演示HashSet的使用：
 *      HashSet，一个无序不可重复的集合，适用于不关系元素的顺序，快速地查找元素
 *      添加散列表的元素
 *      遍历散列表的元素
 *      查找散列表的元素
 *     读取所有输入的单词，并将它们添加到散列集中，然后迭代处理散列集中的不同单词，最后打印单词的数量4+
 *
 */
public class SetTest {
    public static void main(String[] args) {
        //创建HashSet
        final HashSet<String> words = new HashSet<>();
        long totalTime=0;

        try(Scanner scanner = new Scanner(System.in)){
            //以#输入结束
            while (!scanner.hasNext("#")){
                String word = scanner.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime+=callTime;
            }
        }
        //创建集合的迭代器
        final Iterator<String> iterator = words.iterator();
        //打印前20个单词或者打印所有保存的单词
        for (int i = 1; i <=20 &&iterator.hasNext(); i++) {
            System.out.println(iterator.next());
        }
        System.out.println("...");
        System.out.println(words.size()+"distinct words." +totalTime+"milliseconds.");
        System.out.println("========");
        System.out.println("表中含有元素a?");
        System.out.println(words.contains("a"));
    }
}
