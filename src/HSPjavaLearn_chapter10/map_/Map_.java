package HSPjavaLearn_chapter10.map_;

import java.util.HashMap;

/**
 * @author 风之诗
 * @version 1.0
 * Map接口的特点：
 *      1、保存具有映射关系的数据：key-value（双列元素）
 *      2、Map中的key不能重复，当重复put同一个key中时，会将Value进行替换
 *      3、Map中的value可以重复
 *      4、key仅能有一个为空，value可以有多个空
 *
 */
public class Map_ {
    public static void main(String[] args) {
        //由Hash表实现，其中取出的时候顺序随机，用空间换时间，加快了查找元素时的速度
        final HashMap<String, String> map = new HashMap<>();
        map.put("no1","韩顺平");
        map.put("no2","张无忌");
        map.put("no3","韩顺平");
        System.out.println("map"+map);

    }
}
