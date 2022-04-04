package javaLearn_chapter5.inheritance;

public class Manager extends Employee{
    private double bonus;

    /**
     * @param name
     * @param salary
     * @param year
     * @param month
     * @param day
     */
    public Manager(String name,double salary,int year,int month,int day){
        //super关键字两个作用：
            //1、调用父类的方法，用来获取父类的属性
            //2、调用父类的构造器，用来初始化父类的属性
        super(name,salary,year,month,day);
        bonus=0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    /**
     * //重写：在子类中使用一个新的方法来覆盖父类的方法，在使用子类对象调用getSalary方法时会调用重写的方法
     * @return
     */
    @Override
    public double getSalary(){
        double baseSalary=super.getSalary();
        return baseSalary+bonus;
    }
}
