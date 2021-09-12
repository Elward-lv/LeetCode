package java_knowledge.克隆;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Person implements Cloneable, Serializable {
    private static final long serialVersionUID = -1742448824652078966L;

    //jdk之中的对象的拷贝
    ArrayList<Person> familes = null;
    //jdk之外的对象拷贝
    School sc;

    String name;
    String id;
    int age;

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        familes = new ArrayList<>(4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void add(Person p){
        familes.add(p);
    }

    public School getSc() {
        return sc;
    }

    public void setSc(School sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "familes=" + familes +
                ", sc=" + sc +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
