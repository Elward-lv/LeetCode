package java_knowledge.格式化;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class TestNumberFormat {
    @Test
    public void test1(){
        NumberFormat instance = NumberFormat.getNumberInstance(Locale.CHINA);
        double d = 13469966.1215661;
        String format = instance.format(d);
        System.out.println(format);//13,469,966.122

    }
}
