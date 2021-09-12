package java_knowledge.Stream;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        User u1 = new User(12,"a",231);
        User u2 = new User(16,"b",254);
        User u3 = new User(25,"c",266);
        User u4 = new User(63,"d",487);
        User u5 = new User(31,"e",189);
        User u6 = new User(7,"f",148);

        List<User> users = Arrays.asList(u1, u2, u3, u4, u5, u6);
        //users.forEach(System.out::println);
        users.stream().
                filter(p-> p.getId()%2==0).
                sorted((o1,o2)-> o1.getId() - o2.getId())
                .filter(p->p.getAge()>10)
                .map(t->t.getName().toUpperCase())
                .limit(1)
                .forEach(System.out::println);
    }
}
