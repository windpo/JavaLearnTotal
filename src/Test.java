import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test  {
    public static void main(String[] args) {
        String content="aaaa21aaa";
        String regString="(a)\\1+";
        Pattern pattern = Pattern.compile(regString);
        System.out.println(pattern.matcher(content).replaceAll("$1"));
    }
}
