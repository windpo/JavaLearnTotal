package recurion;

/**
 * @author 风之诗
 * 输出2到n的内容
 */
public class Recurion01 {
    void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }
    public static void main(String[] args) {
        int n=5;
        Recurion01 recurion01 = new Recurion01();
        recurion01.test(n);
    }
}
