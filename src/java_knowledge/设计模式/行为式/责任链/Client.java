package java_knowledge.设计模式.行为式.责任链;

public class Client {
    /**
     * 通过一个关系(可以是属性/构造方法等)把一种类型的处理器串在一起，只要消息/请求没得到处理，就继续执行这个传递
     *
     * java.util.logging.Logger#log()
     * [Apache Commons Chain]
     * [javax.servlet.Filter#doFilter()]
     */
    public static void main(String[] args) {
        Handler handler2 = new ConcreteHandler2(null);
        Handler handler1 = new ConcreteHandler1(handler2);


        Request request1 = new Request("re1",RequestType.TYPE1);
        Request request2 = new Request("re2",RequestType.TYPE2);
        handler1.handlerRequest(request1);
        handler1.handlerRequest(request2);
    }
}
