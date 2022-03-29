package GenericWildCardTest;
//waiting

/*我们知道Ingeter是Number的一个子类，同时在特性章节中我们也验证过Generic<Ingeter>与Generic<Number>实际上是相同的一种基本类型。
 那么问题来了，在使用Generic<Number>作为形参的方法中，能否使用Generic<Ingeter>的实例传入呢？
 在逻辑上类似于Generic<Number>和Generic<Ingeter>是否可以看成具有父子关系的泛型类型呢？*/

public class Generic<Integer> {
    private Integer key;
    public Integer getkey(){
        return key;
    }
    public void showkey(Generic<Number> obj){
        System.out.println("通配符测试"+"the key is ");
    }
    public static void main(String[] args) {

    }
}
