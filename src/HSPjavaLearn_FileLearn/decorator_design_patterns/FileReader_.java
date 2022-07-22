package HSPjavaLearn_FileLearn.decorator_design_patterns;

/**
 * @author 风之诗
 * @version 1.0
 * 节点流，为读取某一数据源的流对象
 */
public class FileReader_ extends Reader_{
    @Override
    public void read(){
        System.out.println("读取文件");
    }
}
