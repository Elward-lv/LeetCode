package java_knowledge.序列化;

import java.io.*;

/**
 * 测试序列化
 * 定制序列化和反序列化 需要重写readObject和writeObject方法
 *      void writeObject(ObjectOutputStream out) throws IOException
 *      void readObject(ObjectInputStream in) throws IOException，ClassNotFoundException
 */
public class 序列化测试 {
    public static void main(String[] args) throws IOException {
        //序列化();
        反序列化();
    }

    public static void 反序列化() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("F:\\test.obj"));
            Object o = ois.readObject();
            Student student = (Student)o;
            System.out.println(student.getName()+student.getAge());//lvyanwie22
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void 序列化() {
        ObjectOutputStream oos = null;
        try {
            Student stu = new Student("lvyanwie", 22);
            oos = new ObjectOutputStream(new FileOutputStream("F:\\test.obj"));
            oos.writeObject(stu);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Student implements Serializable {
    /**
     * use serialVersionUID for interoperability
     */
    static final long serialVersionUID = 54648916645L;

    private String name;
    private int age;

    private transient Clothes clothes;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
}

class Clothes {
    private String name;
    private String color;

    public Clothes() {
    }

    public Clothes(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
