package java_knowledge.设计模式.创建式.生成器;

public class Client {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        final int count = 16;
        for (int i = 0; i < count; i++) {
            builder.append((char)('a'+i));
        }
        System.out.println(builder.toString());//abcdefghijklmnop
    }
}
