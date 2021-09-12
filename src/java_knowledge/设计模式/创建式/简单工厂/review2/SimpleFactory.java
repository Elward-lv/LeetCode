package java_knowledge.设计模式.创建式.简单工厂.review2;

import java_knowledge.设计模式.创建式.BadProduct;
import java_knowledge.设计模式.创建式.HighProduct;
import java_knowledge.设计模式.创建式.NormalProuct;
import java_knowledge.设计模式.创建式.Product;

/**
 * 简单工厂通过参数的不同由工厂的某个方法创建对象
 */
public class SimpleFactory {
    public Product createProduct(int type){
        if( type == 1){
            return new HighProduct();
        }else if(type == 2){
            return new NormalProuct();
        }
        return new BadProduct();
    }
}
