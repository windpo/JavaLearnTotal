package javaLearn_chapter5.abstractclasses;

/**
 * @author 风之诗
 */
public abstract class Person {
    /**
     * 为子类提供一个简短描述自己信息的方法
     * @return
     */
    public abstract String getDescription();
    private String name;
    public Person(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
