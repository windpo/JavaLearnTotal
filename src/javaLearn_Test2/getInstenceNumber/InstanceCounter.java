package getInstenceNumber;

public class InstanceCounter {
    private static int numInstence=0;//实例数量
    protected static int getNumInstence(){
        return numInstence;
    }
    private static void addInstance(){
        numInstence++;
    }
    public InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] args) {
        System.out.println("Starting with"+
                InstanceCounter.getNumInstence()+"instence");
        for (int i = 0; i < 500; i++) {
            new InstanceCounter();
        }
        System.out.println("Starting with"+
                InstanceCounter.getNumInstence()+"instence");
    }
}
