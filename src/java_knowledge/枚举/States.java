package java_knowledge.枚举;

public enum States {
    Error_100(100,"请求正在处理"),
    Error_200(200,"请求正常处理完毕"),
    Error_300(300,"需要进行附加操作以完成请求"),
    Error_400(400,"服务器无法处理请求");

    private String msg;
    private int code;
    States(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
