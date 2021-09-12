package java_knowledge.流.ObjectOuputSt;

import java_knowledge.克隆.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        /*List<Person> list = new ArrayList<>();
        list.add(new Person("kk","jdjd",20));
        list.add(new Person("kk2","jdj2d",30));
        testWriteList(list);
*/
        testReadList();
    }

    public static void testWriteList(List list){
        try {
            FileOutputStream fos = new FileOutputStream("F:\\hello.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        }catch (Exception e){
            System.out.println("写入异常");
            e.printStackTrace();
        }
    }

    public static void testReadList(){
        try {
            FileInputStream fis = new FileInputStream("F:\\hello.txt");
            ObjectInputStream oos = new ObjectInputStream(fis);
            Object o = oos.readObject();
            if(o instanceof ArrayList){
                List<Person> list = (List<Person>)o;
                System.out.println(list.size());
                for (Person p : list) {
                    System.out.println(p);
                }
            }
        }catch (Exception e){
            System.out.println("写入异常");
            e.printStackTrace();
        }
    }
}
