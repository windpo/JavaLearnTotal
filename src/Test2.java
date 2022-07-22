/**
 * @author 风之诗
 * @version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        final Student student1 = new Student("刘");
        final Student student2 = new Student("洋");
        swap(student1,student2);
        System.out.println(student1.getName());
        System.out.println(student2.getName());
    }
    public static void swap(Student a,Student b){
        Student temp;
        temp=a;
        a=b;
        b=temp;
        a.setName("刘");
        b.setName("洋"); 
    }
}
class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}