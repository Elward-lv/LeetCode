package java_knowledge.JVM.内存;

public class 获取内存大小 {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();//返回最大内存数 字节
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("MaxMemory:"+maxMemory/(double)1024/1024+"MB");//3042.0
        System.out.println("TotalMemory:"+totalMemory/(double)1024/1024+"MB");//192.0
    }
}
