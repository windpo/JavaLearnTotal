package HSPjavaLearn_FileLearn.decorator_design_patterns;

/**
 * @author 风之诗
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //通过创建读取文件的处理流，并使用增强方法多次读取文件
        final BuffedReader_ buffedReader_ = new BuffedReader_(new FileReader_());
        buffedReader_.reads(10);
        //通过创建读取字符串的处理流，并使用增强方法多次读取字符串
        final BuffedReader_ buffedReader_1 = new BuffedReader_(new StringReader_());
        buffedReader_1.reads(5);
    }
}
