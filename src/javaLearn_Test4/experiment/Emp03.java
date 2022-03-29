package experiment;

/**
 * @author 风之诗
 */
public class Emp03 {
    public static void main(String[] args) {
        //底边长度
        int n=7;
        for (int count=0;count<(n+1)/2;count++) {
            for (int j = 0; j<count; j++) {
                System.out.print(' ');
            }
            for (int i = 0; i < 9-2*(count+1); i++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
