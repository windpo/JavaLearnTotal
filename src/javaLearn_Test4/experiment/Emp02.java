package experiment;

/**
 * @author 风之诗
 */
public class Emp02 {
    public static void main(String[] args) {
        int n=100;
        double num=1;
        double sum=0;
        int sign=-1;
        for (int i = 0; i < n; i++) {
            sum+=1/num;
            num+=2;
            num*=sign;
        }
        System.out.println(sum);
    }
}
