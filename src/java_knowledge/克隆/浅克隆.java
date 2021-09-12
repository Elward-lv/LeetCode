package java_knowledge.克隆;

public class 浅克隆 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p  = new Person("lvyanwei" , "456",42);
        p.setSc(new School("ahpu"));
        p.add(new Person("lvxiaonan","123",12));
        System.out.println(p);

        Object pc = p.clone();
        System.out.println(pc);
        System.out.println(p == pc);
    }
}
