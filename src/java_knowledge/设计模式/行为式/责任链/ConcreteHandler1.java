package java_knowledge.设计模式.行为式.责任链;

public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    public void handlerRequest(Request request) {
        if(request.getType() == RequestType.TYPE1){
            System.out.println(request.getName() + " is handle by ConcreteHandler1");
            return;
        }
        if(successor != null){
            successor.handlerRequest(request);
        }
    }
}
