package HSPjavaLearn_FileLearn.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 风之诗
 * @version 1.0
 * 演示使用ObjectOutputStream，完成数据的序列化
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的格式不是纯文本的，而是根据它自己的格式来保存
        final String filePath = "e:\\data.dat";

        final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到"e:\\data.dat"
        oos.writeInt(100);// int->Integer (实现了 Serializable)
        oos.writeBoolean(true);//bool->Boolean (实现了 Serializable)
        oos.writeChar('a');//char->Character (实现了 Serializable)
        oos.writeDouble(9.5);//double->Double (实现了 Serializable)
        oos.writeUTF("巴巴托斯");//String
        //保存一个序列化对象
        oos.writeObject(new Dog("旺财",5));

        oos.close();
        System.out.println("数据保存完毕");
    }
}

