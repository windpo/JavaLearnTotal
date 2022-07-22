package HSPjavaLearn_threadLearn;

/**
 * @author 风之诗
 * @version 1.0
 * 获取当前电脑的cpu数量
 */
public class CupNum {
    public static void main(String[] args) {
        final Runtime runtime = Runtime.getRuntime();
        final int cpuNums = runtime.availableProcessors();
        System.out.println("当前电脑cpu数量为"+cpuNums);
    }
}
