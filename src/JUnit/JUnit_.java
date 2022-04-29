package JUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author 风之诗
 * @version 1.0
 *  1、直接测试
 *      @Test
 *  2、传入参数设置
 *      @ParameterizedTest
 *      @ValueSource(测试的一堆数据的数组)
 *  3、传入函数测试
 *      @ParameterizedTest
 *      @MethodSource(函数名),且该函数的返回值有一定的要求
 * 4、传入空值NULL
 *      @NullSource
 * 5、传入空格
 *      @EmptySource
 *
 */
public class JUnit_ {
    public static void main(String[] args) {

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void m1(int a){
        System.out.println("M1方法被调用"+a);
    }
    @Test
    public void m2(){
        System.out.println("M2方法被调用");
    }
}

