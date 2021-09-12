package java_knowledge.关键字.inner;

import java_knowledge.关键字.Father;

/**
 * 子类不能访问默认方法，但是可以访问protected方法
 */
class Children extends Father {
    void test(){
        testProect();
        //testNone(); 子类不能访问default
    }
}
