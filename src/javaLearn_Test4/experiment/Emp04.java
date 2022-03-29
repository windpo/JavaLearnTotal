package experiment;

/**
 * @author 风之诗
 */
public class Emp04 {
    static void print(int n){
        for (int count=0;count<n;count++) {
            for (int j = 0; j<count; j++) {
                System.out.print(' ');
            }
            for (int i = 0; i < 2*n-1-2*count; i++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Emp04.print(3);
        Emp04.print(5);
        Emp04.print(7);
    }
}
