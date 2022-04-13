package javaLearn_chapter5.equals_hashcode_toString;

import java.util.Objects;

/**
 * @author 风之诗
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus=0;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        //super以及检测了传入类和判断类是否为同一个类，也验证了父类有的属性
        if (!super.equals(o)) {
            return false;
        }
        Manager manager = (Manager) o;
        //只需判断子类的新属性是否相等即可
        return Double.compare(manager.bonus, bonus) == 0;
    }

    @Override
    public int hashCode() {
        //直接调用父类的super，和子类新生成的属性合并
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        //super.toSring中包含了该类名以及子类所有的父类中的所有属性
        return super.toString() +
                "bonus=" + bonus +
                '}';
    }
}
