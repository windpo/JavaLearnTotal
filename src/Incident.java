

public class Incident {
    public static void main(String[] args) {
        final Gamer windPo = new Gamer(1000);
        final TallSeng yumo = new TallSeng(windPo.deposite);

        windPo.eat();
        windPo.eat(5000);


        yumo.spendMoney();
        System.out.println("WindPo的余额为" + yumo.deposite);

        final Gamer jiGong = new TallSeng(1000);
        jiGong.spendMoney();
        System.out.println("玩游戏的师兄的余额为"+jiGong.deposite);
    }
}
/**
 * Gamer类
 */

class Gamer{
    int deposite;

    public Gamer(int deposite) {
        this.deposite = deposite;
    }

    public void eat(){
        System.out.println("吃泡面");
    }

    public void eat(int money){
        System.out.println("银行卡余额增加"+money);
        System.out.println("吃龙虾");
    }

    public void spendMoney(){
        System.out.println("氪金");
        deposite-=100;
    }

}

/**
 * TallSeng（高僧-->Tall Seng）类
 */
class TallSeng extends Gamer{

    public TallSeng(int deposite) {
        super(deposite);
    }

    @Override
    public void spendMoney() {
        System.out.println("买衣服");
        deposite-=10;
    }
}
