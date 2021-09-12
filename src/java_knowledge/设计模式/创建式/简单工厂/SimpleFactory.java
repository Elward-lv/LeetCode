package java_knowledge.设计模式.创建式.简单工厂;

import java_knowledge.设计模式.创建式.BadProduct;
import java_knowledge.设计模式.创建式.HighProduct;
import java_knowledge.设计模式.创建式.NormalProuct;
import java_knowledge.设计模式.创建式.Product;

/**
 * 在创建一个对象时不向客户暴露内部细节，并提供一个创建对象的通用接口。
 */
public class SimpleFactory {
    public Product gennerateProduct(int type){
        if(type == 0){
            return new BadProduct();
        }else if(type == 1){
            return new NormalProuct();
        }else {
            return new HighProduct();
        }
    }

    public static void main(String[] args) {
        SimpleFactory f = new SimpleFactory();
        f.gennerateProduct(1).hello();

    }
}
