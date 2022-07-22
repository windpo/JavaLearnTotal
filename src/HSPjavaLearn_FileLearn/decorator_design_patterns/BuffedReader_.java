package HSPjavaLearn_FileLearn.decorator_design_patterns;

/**
 * @author 风之诗
 * @version 1.0
 * 模拟修饰器设计模式
 * 处理流/包装流，将多个原有的节点流进行包装，使得能灵活处理不同的数据源，并且能在原有功能上进行拓展
 */
public class BuffedReader_ extends Reader_{
    private Reader_ reader_;

    public BuffedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    //拓展功能-->多次读取
    public void reads(int num){
        for (int i = 0; i < num; i++) {
            reader_.read();
        }
    }

    @Override
    public void read() {
        reader_.read();
    }
}
