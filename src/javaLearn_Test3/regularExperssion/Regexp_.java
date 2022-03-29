package regularExperssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 体验正则表达式威力，体现正则表达式处理文本带来的威力
 */
public class Regexp_ {
        public static void main(String[] args) {
                String content="1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的静态网页能够“灵活”起来，急需一种" +
                        "软件技术来开发一种程序，这种程序可以通过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行的技术）" +
                        "，并将Oak更名为Java（在申请注册商标时，发现Oak已经被人使用了，再想了一系列名字之后，最" +
                        "终，使用了提议者在喝一杯Java咖啡时无意提到的Java词语）。5月23日，Sun公司在Sun world会" +
                        "上正式发布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软等" +
                        "各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为自己的产品开发了相应的Ja" +
                        "va平台。";

                String content1="<ul class=\"s-news-rank-content\"><li class=\"news-meta-item clearfix\"><a id=\"tit" +
                        "le-content\" class=\"title-content c-link c-font-medium\" href=\"https://www.baidu.com/" +
                        "s?wd=%E5%85%A8%E5%9B%BD%E4%BA%BA%E5%A4%A7%E4%BA%94%E6%AC%A1%E4%BC%9A%E8%AE%AE%E8%83%9C%E5%88%" +
                        "A9%E9%97%AD%E5%B9%95&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&am" +
                        "p;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\"><i class=\"c-ic" +
                        "on title-content-top-icon c-color-red c-gap-right-small\">\uE62E</i><!--4--><!--5--><span class=\"" +
                        "title-content-title\">全国人大五次会议胜利闭幕</span><span class=\"title-content-mark c-text \"></span>" +
                        "</a></li><li class=\"news-meta-item clearfix\"><a id=\"title-content\" class=\"title-content c-li" +
                        "nk c-font-medium\" href=\"https://www.baidu.com/s?wd=31%E7%9C%81%E4%BB%BD%E6%96%B0%E5%A2%9E%E6%9C%AC" +
                        "%E5%9C%9F%E2%80%9C1807%2B1315%E2%80%9D&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super" +
                        "&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\"><span cl" +
                        "ass=\"title-content-index c-index-single c-index-single-hot1\">1</span><!--6--><!--7--><span class=\"" +
                        "title-content-title\">31省份新增本土“1807+1315”</span><span class=\"title-content-mark c-text c-text-hot" +
                        "\">热</span></a></li><li class=\"news-meta-item clearfix\"><a id=\"title-content\" class=\"title-conten" +
                        "t c-link c-font-medium\" href=\"https://www.baidu.com/s?wd=%E5%8D%95%E6%97%A5%E6%96%B0%E5%A2%9E%E8%B6%85" +
                        "2000+%E5%90%89%E6%9E%97%E7%96%AB%E6%83%855%E7%82%B9%E9%87%8A%E7%96%91&amp;sa=fyb_n_homepage&amp;rsv_dl" +
                        "=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1" +
                        "\" target=\"_blank\"><span class=\"title-content-index c-index-single c-index-single-hot2\">2</span><!" +
                        "--8--><!--9--><span class=\"title-content-title\">单日新增超2000 吉林疫情5点释疑</span><span class=\"title-" +
                        "content-mark c-text c-text-hot\">热</span></a></li><li class=\"news-meta-item clearfix\"><a id=\"title-c" +
                        "ontent\" class=\"title-content c-link c-font-medium\" href=\"https://www.baidu.com/s?wd=%E5%86%AC%E6%AE" +
                        "%8B%E5%A5%A5%E9%97%AD%E5%B9%95%E5%BC%8F%E4%B8%BB%E9%A2%98%E4%B8%BA%E5%9C%A8%E6%B8%A9%E6%9A%96%E4%B8%AD" +
                        "%E6%B0%B8%E6%81%92&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=bai" +
                        "dutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\"><span class=\"title-content-i" +
                        "ndex c-index-single c-index-single-hot3\">3</span><!--10--><!--11--><span class=\"title-content-title\"" +
                        ">冬残奥闭幕式主题为在温暖中永恒</span><span class=\"title-content-mark c-text c-text-hot\">热</span></a></li" +
                        "><li class=\"news-meta-item clearfix\"><a id=\"title-content\" class=\"title-content c-link c-font-medi" +
                        "um\" href=\"https://www.baidu.com/s?wd=%E4%B8%8A%E6%B5%B7%E9%9A%94%E7%A6%BB%E5%A4%A7%E7%88%B7%E5%9D%90%" +
                        "E5%A2%99%E4%B8%8A%E9%92%93%E9%B1%BC&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp" +
                        ";cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\"><span class=\"" +
                        "title-content-index c-index-single c-index-single-hot4\">4</span><!--12--><!--13--><span class=\"title-" +
                        "content-title\">上海隔离大爷坐墙上钓鱼</span><span class=\"title-content-mark c-text c-text-new\">新</span><" +
                        "/a></li><li class=\"news-meta-item clearfix\"><a id=\"title-content\" class=\"title-content c-link c-fo" +
                        "nt-medium\" href=\"https://www.baidu.com/s?wd=%E5%AD%99%E6%9D%A8%E4%B8%8E%E6%B3%B3%E6%B1%A0%E6%B8%90%E8%" +
                        "A1%8C%E6%B8%90%E8%BF%9C+%E5%B8%B8%E5%B8%A6%E8%B4%A7%E5%88%B0%E5%87%8C%E6%99%A8&amp;sa=fyb_n_homepage&am" +
                        "p;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfi" +
                        "lter=1\" target=\"_blank\"><span class=\"title-content-index c-index-single c-index-single-hot5\">5</sp" +
                        "an><!--14--><!--15--><span class=\"title-content-title\">孙杨与泳池渐行渐远 常带货到凌晨</span><span class=\"" +
                        "title-content-mark c-text c-text-new\">新</span></a></li><li class=\"news-meta-item clearfix\"><a id=\"t" +
                        "itle-content\" class=\"title-content c-link c-font-medium\" href=\"https://www.baidu.com/s?wd=%E5%BE%B7" +
                        "%E5%AA%92%EF%BC%9A%E4%BA%BA%E8%B4%A9%E5%AD%90%E7%9B%AF%E4%B8%8A%E4%B9%8C%E5%85%8B%E5%85%B0%E5%A5%B3%E9%" +
                        "9A%BE%E6%B0%91&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop" +
                        "10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\"><span class=\"title-content-index c" +
                        "-index-single c-index-single-hot6\">6</span><!--16--><!--17--><span class=\"title-content-title\">德媒：" +
                        "人贩子盯上乌克兰女难民</span><span class=\"title-content-mark c-text \"></span></a></li><li class=\"news-met" +
                        "a-item clearfix\"><a id=\"title-content\" class=\"title-content c-link c-font-medium\" href=\"https://w" +
                        "ww.baidu.com/s?wd=%E5%BC%A0%E6%96%87%E5%AE%8F%EF%BC%9A%E7%BB%88%E6%9C%89%E4%B8%80%E5%A4%A9%E4%BC%9A%E5%" +
                        "8F%91%E7%8E%B0%E5%B7%B2%E5%AE%8C%E5%85%A8%E5%BC%80%E6%94%BE&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_hom" +
                        "epage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"" +
                        "_blank\"><span class=\"title-content-index c-index-single c-index-single-hot7\">7</span><!--18--><!--1" +
                        "9--><span class=\"title-content-title\">张文宏：终有一天会发现已完全开放</span><span class=\"title-content-ma" +
                        "rk c-text c-text-hot\">热</span></a></li><li class=\"news-meta-item clearfix\"><a id=\"title-content\" c" +
                        "lass=\"title-content c-link c-font-medium\" href=\"https://www.baidu.com/s?wd=%E4%BF%84%E5%9B%BD%E9%98%B" +
                        "2%E9%83%A8%E5%85%AC%E5%B8%83%E5%8D%A0%E9%A2%86%E4%B9%8C%E5%85%8B%E5%85%B0%E6%9C%BA%E5%9C%BA%E7%94%BB%E9" +
                        "%9D%A2&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr" +
                        "=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\"><span class=\"title-content-index c-index-si" +
                        "ngle c-index-single-hot8\">8</span><!--20--><!--21--><span class=\"title-content-title\">俄国防部公布占领乌" +
                        "克兰机场画面</span><span class=\"title-content-mark c-text c-text-hot\">热</span></a></li><li class=\"new" +
                        "s-meta-item clearfix\"><a id=\"title-content\" class=\"title-content c-link c-font-medium\" href=\"ht" +
                        "tps://www.baidu.com/s?wd=%E4%B9%8C%E7%A7%B0%E6%AD%A3%E8%B6%8B%E4%BA%8E%E5%B0%B1%E7%AD%BE%E7%BD%B2%E5%85%A8%E" +
                        "9%9D%A2%E5%8D%8F%E8%AE%AE%E8%BE%BE%E6%88%90%E5%A6%A5%E5%8D%8F&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&am" +
                        ";from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\"><span cla" +
                        "ss=\"title-content-index c-index-single c-index-single-hot9\">9</span><!--22--><!--23--><span class=\"title-con" +
                        "tent-title\">乌称正趋于就签署全面协议达成妥协</span><span class=\"title-content-mark c-text \"></span></a></li><!--3-" +
                        "-></ul>";

                String content3="私有地址（Private address）属于非注册地址，专门为组织机构内部使用。\n" +
                        "以下列出留用的内部私有地址\n" +
                        "A类 10.0.0.0--10.255.255.255\n" +
                        "B类 172.16.0.0--172.31.255.255\n" +
                        "C类 192.168.0.0--192.168.255.255";
                //提取文章中的所有英文单词
                //提取文章中的所有数字
                //提取文章中的所有数字和英文单词
                //提取百度热搜
                //(1).传统方法：使用遍历，代码量大，效率不高
                //(2).正则表达式技术

                //1.先创建一个pattern对象：模式的对象，正则表达式的对象
                //Pattern pattern = Pattern.compile("[a-zA-Z]+");
                //Pattern pattern = Pattern.compile("[0-9]+");
                //Pattern pattern = Pattern.compile("([0-9])+|([a-zA-Z]+)");
                //Pattern pattern = Pattern.compile("<span class=\"title-content-title\">(\\S*)</span>");
                Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
                //2.创建一个匹配器对象：就是按照pattern对象的模式，到content的文本中进行匹配和解释的对象
                Matcher matcher = pattern.matcher(content3);
                //matcher.find()方法，即在文本中寻找字符串，找到返回true，未找到返回false
                //匹配字符串
                int no=0;
                while(matcher.find()){
                        //匹配内容，文本，放到m.gruop(0)中
                        System.out.println("找到: "+(++no)+" "+ matcher.group(0));
                }
        }

}
