package GenericInterfaceTest;
//泛型接口使用测试

/*
 * 在声明一个继承接口的类时，需要将泛型同样写上，否则编译器报错
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 */
public class FruitGnerator<T> implements Generator{

    private T key;  //私人变量

    public FruitGnerator(T key) { //构造器
        this.key = key;
    }
    public T getKey(){
        return key;
    }
    @Override //重写注解
    public T add(){
        System.out.println("have add "+getKey());
        return null;
    }
    /*
     * 传入泛型实参时：
     * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口Generator<T>
     * 但是我们可以为T传入无数个实参，形成无数种类型的Generator接口。
     * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
     * 即：Generator<T>，public T next();中的的T都要替换成传入的String类型。
     */
    public static void main(String[] args) {
        //创建字符串类型的泛型和整数型的泛型并验证
        FruitGnerator<String> stringFruitGnerator=new FruitGnerator<String>("吼吼吼");
        stringFruitGnerator.add();
        FruitGnerator<Integer> integerFruitGnerator=new FruitGnerator<Integer>(52021);
        integerFruitGnerator.add();
    }
}


