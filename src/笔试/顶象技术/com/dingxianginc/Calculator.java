package 笔试.顶象技术.com.dingxianginc;

import 笔试.顶象技术.com.dingxianginc.utils.CalculatorUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1. 完成Calculator中未实现的方法, 不得修改本类中的方法签名以及类名, 包名. 实现逻辑可以新建类.
 * 2. 所列出方法不必全部实现， 可以从易到难逐个完成。
 * 3. 不能使用任何数学运算库(包括jdk中的)以及第三方库
 * 4. 浮点型计算结果保留两位小数
 * 5. 在规定时间内完成题目, 打包成"姓名-笔试题.zip"格式, 目录层次结构与原题相同. 回复至邮箱
 * <p>
 * 加分项
 * 1. 良好的代码风格和可读性
 * 2. 完备的单元测试用例
 */
public class Calculator {
    //缓存，用来求最值
    private static Map<String, Double> caches = new ConcurrentHashMap<>();

    //加法
    public Object add(Object leftValue, Object rightValue) {
        CalculatorUtil.isNumber(leftValue, rightValue);
        return CalculatorUtil.formatDouble(CalculatorUtil.convertNumberToDouble(leftValue) + CalculatorUtil.convertNumberToDouble(rightValue));
        //throw new RuntimeException("unimplemention");
    }

    //减法
    public Object sub(Object leftValue, Object rightValue) {
        CalculatorUtil.isNumber(leftValue, rightValue);
        return CalculatorUtil.formatDouble(CalculatorUtil.convertNumberToDouble(leftValue) - CalculatorUtil.convertNumberToDouble(rightValue));
//        throw new RuntimeException("unimplemention");
    }

    //乘法
    public Object mul(Object leftValue, Object rightValue) {
        CalculatorUtil.isNumber(leftValue, rightValue);
        return CalculatorUtil.formatDouble(CalculatorUtil.convertNumberToDouble(leftValue) * CalculatorUtil.convertNumberToDouble(rightValue));
//        throw new RuntimeException("unimplemention");
    }

    //除法
    public Object div(Object leftValue, Object rightValue) {
        CalculatorUtil.isNumber(leftValue, rightValue);
        return CalculatorUtil.formatDouble(CalculatorUtil.convertNumberToDouble(leftValue) / CalculatorUtil.convertNumberToDouble(rightValue));
//        throw new RuntimeException("unimplemention");
    }

    //求最大值
    public String max(String[] values) {
        //throw new RuntimeException("unimplemention");
        if (values == null || values.length == 0) return null;

        int maxIndex = 0;
        Double iDouble = null;
        Double maxDouble = null;
        caches.put(values[0], CalculatorUtil.convertStringToNumber(values[0]));
        for (int i = 1; i < values.length; i++) {
            //检查缓存
            Double iCa = caches.get(values[i]);
            if (iCa == null) {
                caches.put(values[i], iDouble = CalculatorUtil.convertStringToNumber(values[i]));
            } else {
                iDouble = iCa;
            }
            maxDouble = caches.get(values[maxIndex]);
            if (iDouble.compareTo(maxDouble) > 0)
                maxIndex = i;
        }
        return values[maxIndex];
    }

    //四则混合运算
    public String mixComputing(String expression) {
//        throw new RuntimeException("unimplemention");
        return null;
    }

    //批量计算
    public String[] batchComputing(String[] expression) {
        throw new RuntimeException("unimplemention");
    }


}
