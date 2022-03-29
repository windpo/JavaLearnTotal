package regularExperssion;

/**
 * 在String类中使用正则表达式
 */
public class RegExp11 {
    public static void main(String[] args) {
        /**
         * 功能1、替换功能 repalceAll(String regex,String replacement):将正则表达式所对应格式的字符串进行替代
         * 将下文中JDK1.3和JDK1.4替换为JDK
         */
        String content1="2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。" +
                "2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，" +
                "还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J2SE1.5发布" +
                "，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，" +
                "J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，" +
                "其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、格式化I/O及可变参数。";
        content1 = content1.replaceAll("JDK1\\.(?:3|4)", "JDK");
        System.out.println(content1);
        /**
         * 功能2、判断功能 matches(String regex):判断字符是否满足正则表达式格式，返回判断结果
         * 验证一个手机号，要求必须以138|139开头的 11位数字
         */
        String content2="13988889999";
        if (content2.matches("^13(?:8|9)\\d{8}$")) {
            System.out.println("满足要求");
        }
        else {
            System.out.println("不满足要求");
        }
        /**
         * 功能3、分割功能 split(String regex):将字符串进行分割，分割成字符串数组
         * 要求按照# 或者- 或者~ 或者数字 来分割字符串
         */
        System.out.println("==========");
        String content3="hello#abc-jack12smith~北京";
        String[] split = content3.split("#|-|~|\\d+");
        for (String s :
                split) {
            System.out.println(s);
        }
    }
}
