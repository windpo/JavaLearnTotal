package javaLearn_chapter6.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 创建自己的比较器实现Comparator方法，实现自己定义字符串的比较方法
 * @author 风之诗
 * @version 1.0
 */
public class StringSortTest {
    public static void main(String[] args) {
        //ArrayList排序
//        ArrayList<String> strings = new ArrayList<>(2);
//        strings.add("huohuohuo");
//        strings.add("hahaha");
//        StingLengthSort stingLengthSort = new StingLengthSort();
//        strings.sort(stingLengthSort);//ArrayList中的sort方法需传入一个Comparator比较器
//        strings.sort(Comparator.naturalOrder());//直接传入Comparator接口中的私有方法
        //Arrays排序
        String[] strings = new String[2];
        strings[0]="zahahahah";
        strings[1]="huohuohuohuo";
        //默认的Sting中的Comparator为根据字典大小排序
        Arrays.sort(strings);
        for (String s :
                strings) {
            System.out.println(s);
        }
        //自定义根据字符大小进行排序
        //创建比较器
        System.out.println("=======");
        StingLengthSort stingLengthSort = new StingLengthSort();
        Arrays.sort(strings,stingLengthSort);
        for (String s :
                strings) {
            System.out.println(s);
        }
    }
}
class StingLengthSort implements Comparator<String> {
    @Override
    public int compare(String first,String second) {
        return first.length()-second.length();
    }
}
