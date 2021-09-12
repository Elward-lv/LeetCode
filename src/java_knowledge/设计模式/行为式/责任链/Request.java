package java_knowledge.设计模式.行为式.责任链;

public class Request {
    public Request() {
    }

    public Request(String name, RequestType type) {
        this.name = name;
        Type = type;
    }

    private String name;
    private RequestType Type;

    public RequestType getType() {
        return Type;
    }

    public void setType(RequestType type) {
        this.Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
