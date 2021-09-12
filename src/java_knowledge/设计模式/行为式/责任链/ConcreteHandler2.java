package java_knowledge.设计模式.行为式.责任链;

public class ConcreteHandler2 extends Handler {

    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    public void handlerRequest(Request request) {
        if(request.getType() == RequestType.TYPE2){
            System.out.println(request.getName() + " is handle by ConcreteHandler2");
            return;
        }
        if(successor != null){
            successor.handlerRequest(request);
        }
    }
}
