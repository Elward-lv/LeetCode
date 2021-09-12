package java_knowledge.关键字;

/**
 * 测试各个权限修饰符的范围
 * 修饰方法：
 * private 子类和同包均无法访问 私有
 * ^
 * default 子类无权访问，同包可访问
 * ^
 * protected 子类可以访问,同包能访问
 * ^
 * public 全部
 */
public class Father {

    protected void testProect(){}

    static void testDefault(){}
}
