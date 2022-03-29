package GenericClassTest;
//泛型类的使用测试

//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T>{
    //key这个成员变量的类型为T,T的类型由外部指定  
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
    public static void main(String[] args) {
        //在使用泛型的时候如果传入泛型实参,只能按照所确定的参数传入，否则会报错
        //泛型的类型参数只能是类类型，不能是简单类型。
        //不能对确切的泛型类型使用instanceof操作。
        Generic<Integer>  genericInterger=new Generic<>(666);
        Generic<String> genericString=new Generic<String>("value");
        System.out.println("Key is "+genericInterger.getKey());
        System.out.println("Key is "+genericString.getKey());
        //如果不传入泛型类型实参，此时传入的泛型的成员变量或方法可以为任何的类型
        Generic someInterger=new Generic(555);
        Generic someString=new Generic("呜呜呜");
        System.out.println("Key is "+someInterger.getKey());
        System.out.println("Key is "+someString.getKey());
    }
}