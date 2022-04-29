package javaLearn_chapter8.pair1;

/**
 * @author 风之诗
 * @version 1.0
 * 创建一个泛型类
 */
public class Pair <T>{
    private T first;
    private T second;

    public Pair(){
        first=null;
        second=null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
