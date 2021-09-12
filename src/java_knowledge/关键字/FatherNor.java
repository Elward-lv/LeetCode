package java_knowledge.关键字;

/**
 * 同包能访问protected和default方法
 */
public class FatherNor {
    void test(){
        new Father().testProect();
        Father.testDefault();
    }
}
