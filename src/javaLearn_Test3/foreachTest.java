/**
 * java中的增强for：定义一个变量，该变量直接读取for中的每一个元素
 *      1、声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等。
 *      2、表达式是要访问的数组名，或者是返回值为数组的方法。
 */
public class foreachTest {
    public static void main(String[] args) {
        int[] nums={11,13,45,85,32,120};

        for (int i :
                nums) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        String[] names={"Jim","xiaoming","Yang","Xin","Ran"};
        for (String name :
                names) {
            System.out.print(name);
            System.out.print(",");
        }System.out.print("\n");
    }
}
