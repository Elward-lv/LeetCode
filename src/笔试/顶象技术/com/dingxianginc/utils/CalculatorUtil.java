package 笔试.顶象技术.com.dingxianginc.utils;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class CalculatorUtil {
    /**
     * 判断是否是Number,否则抛出异常
     * @param obj
     */
    public static void isNumber(Object ...obj){
        for (Object o : obj) {
            if(!(o instanceof Number)){
                throw new NumberFormatException("数据不是Number的子类");
            }
        }
    }

    /**
     *  将Number数字转化为Doule
     * @param num Number的子类
     * @return
     */
    public static Double convertNumberToDouble(Object num){
        return ((Number)num).doubleValue();
    }

    /**
     * 将String转化为Double运算
     * @param value
     * @return
     */
    public static Double convertStringToNumber(String value) {
        Double v = null;
        try {
          v  = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("String不能转换为Number!");
        }
        return v;
    }

    /**
     * Double类型的数据控制两位精度(有点麻烦,而且会出现重复计算问题)
     * @param d
     * @return
     */
    public static Double formatDouble(Double d){

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setRoundingMode(RoundingMode.UP);
        nf.setMaximumFractionDigits(2);
        return convertStringToNumber(nf.format(d));
    }
}
