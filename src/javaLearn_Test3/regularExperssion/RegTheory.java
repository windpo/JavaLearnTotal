package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 源码分析以及正则表达式的分组的分析
 */
public class RegTheory {
    public static void main(String[] args) {
        String content="1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的静态网页能够“灵活”起来，急需一种" +
                "软件技术来开发一种程序，这种程序可以通过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行的技术）" +
                "，并将Oak更名为Java（在申请注册商标时，发现Oak已经被人使用了，再想了一系列名字之后，最" +
                "终，使用了提议者在喝一杯Java咖啡时无意提到的Java词语）。5月23日，Sun公司在Sun world会" +
                "上正式发布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软等" +
                "各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为自己的产品开发了相应的Ja" +
                "va平台。";
        //  \\d表示任意一个数字
        String RegStr="(\\d\\d)(\\d\\d)";//正则表达式模式字符串
        //1、创建一个pattern对象来传入正则表达式
        Pattern pattern = Pattern.compile(RegStr);
        //2、创建matcher匹配器 传入所需匹配字符串的内容 按照pattern定义模式的方法去匹配
        Matcher matcher = pattern.matcher(content);
        //3、开始匹配
        /**
         *
         * matcher.find()完成的任务 (考虑分组)
         * 分组：正则表达式中用（）来分组，如(\d\d)(\d\d),第一个（）表示第一组，第二个（）表示第二组
         * 1、根据指定的规则，定位满足规则的子字符串（如1998）
         * 2、找到后，将子字符串的索引位置记录到matcher对象的属性 int[] groups；
         *      2.1 groups[0]=0，将字符串结束的索引+1并记录在groups[1]=4
         *      2.2 记录1组()匹配到的字符串的索引groups[2]=0 gruops[3]=2
         *      2.3 记录2组()匹配到字符串的索引gruops[4]=2 gruops[5]=4
         * 3、统计记录oldLast 的值 为结束的索引+1 为4，下次使用find时，就从4 开始匹配
         *
         * matcher.group(0) 分析
         * 源码：
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *  1、根据groups[0]=0和gruops[1]=4的位置，从content中截取子字符串返回
         *     就是从[0,4)包含的子字符串（不包含4）
         */
        while(matcher.find()){
            //有括号时的匹配规则：
            //group（0）代表取出全部
            //group（1）代表取出第一组
            //group（2）代表取出第二组
            //注意：1、匹配的组数不能越界，有几组就取出几组。
            //     2、如果没分组，就只有group（0）
            System.out.println("找到： "+matcher.group(0));
            System.out.println("第一组()匹配到的值： "+matcher.group(1));
            System.out.println("第二组()匹配到的值： "+matcher.group(2));
        }
    }
}
