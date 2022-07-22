package LXYjavaLearn_reflection.creat_use_get_annotation;

/**
 * @author 风之诗
 * @version 1.0
 * 演示使用自己的注解
 */
@TestMyAnnotation(value = "嗨害嗨")
public class Test {
    //@TestMyAnnotation
    private String name;
    @TestMyAnnotation
    public static void main(String[] args) {

    }
    @TestMyAnnotation("好吃又管饱")
    public void eat(){
        System.out.println("老八秘制小汉堡");
    }
}