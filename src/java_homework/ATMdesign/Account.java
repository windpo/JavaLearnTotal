package java_homework.ATMdesign;

/**
 * @author 风之诗
 * @version 1.0
 * 银行卡类，包含ID、密码、以及账户余额
 */
public class Account {
    private String ID;
    private String password;
    private int deposit;

    public Account() {
        this.ID = "888888";
        this.password = "123456";
        this.deposit = 50000;
    }

    public String getID() {
        return ID;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * 获取密码
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码：只有旧密码正确，新密码符合要求，且两次输出相同的情况下才可以成功修改密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 查询余额
     *
     * @return
     */
    public int getDeposit() {
        return deposit;
    }

    /**
     * ATM取款：每次取款金额为100的倍数，总额不超过5000元，支取金额不允许透支。
     *
     * @param value
     * @return
     */
    public int drawMoney(int value) {
        this.deposit -= value;
        return value;
    }

    /**
     * 存款，如果存入金额为负，则打印错误日志
     *
     * @param deposit
     */
    public void addDeposit(int deposit) {
        this.deposit += deposit;
    }
}
