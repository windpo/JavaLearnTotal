package recurion;

public class Recurion04 {
    public static void main(String[] args) {
        char a='a';
        char b='b';
        char c='c';
        Tower.move(5,a,b,c);
    }
}
class Tower{
    //方法
    //num 表示要移动的个数，a，b，c分别表示A塔，B塔，C塔

    /**
     * 分析：要么有两个塔需要移动，要么有一个塔需要移动，把多个塔的上层部分看作抽象的两个塔，逐步拆解，只要涉及多个塔的移动就就用递归把它移动
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void move(int num,char a,char b,char c){
        //如果只有一个盘 num=1
        if(num==1){
            System.out.println(a+"->"+c);
        }else{
            //如果有多个盘，可以看成两个盘，最下面的一个盘以及最上面的所有盘(num-1)
            move(num-1,a,c,b);
            //把最下面的盘移动到c
            System.out.println(a+"->"+c);
            //再把b塔的所有塔移动到c,借助a塔（a塔作为中间的转移部分）
            move(num-1,b,a,c);
        }
    }
}
