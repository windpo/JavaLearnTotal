import java.util.*;

/**
 * @author 风之诗
 * @version 1.0
 * 迭代器的操作，创造一个迭代器，并对所有元素遍历以及进行删除元素的操作
 */
public class Test {
    public static void main(String[] args) {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(85);
        numbers.add(52);
        final Iterator<Integer> iterator = numbers.iterator();
        iterator.forEachRemaining(System.out::println);
        /**
         * 遍历删除集合中的所有元素
         */
        iterator.forEachRemaining(element->iterator.remove());
        iterator.remove();
        iterator.forEachRemaining(System.out::println);
        System.out.println("=========");
        /**
         *  删除集合中的前两个个元素
         */
        final List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(5);
        numbers2.add(6);
        numbers2.add(7);

        final Iterator<Integer> iterator1 = numbers2.iterator();
        iterator1.next();
        iterator1.remove();
        iterator1.next();
        iterator1.remove();
        numbers2.forEach(System.out::println);
    }
}