package experiment;

import static java.lang.Math.pow;

/**
 * @author 风之诗
 */
public class Emp01 {
    private double l1,l2,l3;

    public Emp01(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }
    public void verifyTriangle(){
        final double ESPLION=0.0001;
        if(Math.abs(l1+l2)<=l3||Math.abs(l1+l3)<=l2||Math.abs(l2+l3)<=l1){
            System.out.println("不为三角形");
        }
        else{
            if(Math.abs(l1-l2)<ESPLION||Math.abs(l1-l3)<ESPLION||Math.abs(l2-l3)<ESPLION){
            if(Math.abs(l1-l2)<ESPLION && Math.abs(l2-l3)<ESPLION && Math.abs(l1-l3)<ESPLION){
                System.out.println("该三角形为等边三角形");
            }else{
                System.out.println("该三角形为等腰三角形");
            }
        }else {
            if(Math.abs(pow(l1,2)-(pow(l2,2)+pow(l3,2)))<ESPLION||Math.abs(pow(l2,2)-(pow(l1,2)+pow(l3,2)))<ESPLION||Math.abs(pow(l3,2)-(pow(l2,2)+pow(l1,2)))<ESPLION){
                System.out.println("该三角形为直角三角形");
            }else {
                System.out.println("该三角形为普通三角形");
            }
        }
        }
    }
    public static void main(String[] args) {
        Emp01 righTriangle = new Emp01(5,3,4);
        righTriangle.verifyTriangle();
        Emp01 emp02 = new Emp01(4,4,4);
        emp02.verifyTriangle();
        Emp01 emp03 = new Emp01(4,3,3);
        emp03.verifyTriangle();
    }
}
