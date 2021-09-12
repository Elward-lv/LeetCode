package java_knowledge.设计模式.行为式.解释器;

/**
 * 时间：3.4
 * 抽象出表达式类，设置一个公共的接口/抽象类
 *
 * 解释器 interpreter---为语言创建解释器，通常由语言的语法和语法分析来定义。
 *
 *
 * 以下是一个规则检验器实现，具有 and 和 or 规则，通过规则可以构建一颗解析树，用来检验一个文本是否满足解析树定义的规则。
 *
 * 例如一颗解析树为 D And (A Or (B C))，文本 "D A" 满足该解析树定义的规则。
 *
 * 这里的 Context 指的是 String。
 *
 * - [java.util.Pattern](http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
 * - [java.text.Normalizer](http://docs.oracle.com/javase/8/docs/api/java/text/Normalizer.html)
 * - All subclasses of [java.text.Format](http://docs.oracle.com/javase/8/docs/api/java/text/Format.html)
 * - [javax.el.ELResolver](http://docs.oracle.com/javaee/7/api/javax/el/ELResolver.html)
 */
public abstract class Expression {
    public abstract boolean interpret(String str);
}
