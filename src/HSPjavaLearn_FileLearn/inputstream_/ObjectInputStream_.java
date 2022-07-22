package HSPjavaLearn_FileLearn.inputstream_;

import HSPjavaLearn_FileLearn.outputstream_.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 风之诗
 * @version 1.0
 * 演示使用ObjectInputStream来提取序列化文件的内容并反序列化恢复数据
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //指定反序列化的文件
        final String filePath = "e:\\data.dat";

        final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取时，反序列化的顺序应和序列化时一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        //dog的编译类型为Object，实际运行的类型为Dog
        Object dog = ois.readObject();
        System.out.println("运行类型="+dog.getClass());
        System.out.println("dog信息="+dog);

        //如果我们需要调用Dog的方法，需要向下转型
        //需要我们将Dog类的定义，拷贝到我们能引用的位置
        System.out.println("狗的名字="+((Dog)dog).getName());
        //关闭流
        ois.close();
    }
}
