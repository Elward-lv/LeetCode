package java_knowledge.正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java正则表达式
 */
public class PatternModeTest {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("\\w+\\s+");
        Matcher matcher = pattern.matcher("abd    ");
        System.out.println(matcher.matches());

        System.out.println(Pattern.matches("\\w+\\s+", "adb.  "));
    }
}
