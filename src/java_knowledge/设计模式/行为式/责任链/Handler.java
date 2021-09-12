package java_knowledge.设计模式.行为式.责任链;

public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    public abstract void handlerRequest(Request request);
}
