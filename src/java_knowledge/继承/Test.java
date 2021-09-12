package java_knowledge.继承;

public class Test {

    public static void main(String[] args) {
        /*向上转型:循里氏替换原则，子类对象必须能够替换掉所有父类对象*/
        Animal a1 = new Cat();
        a1.eat();//eat fishs!
        a1.sleep();

        /*向下转型:本来不是猫，却要转成猫报错*/
        Cat c2 = (Cat) new Animal();
        c2.eat();//ClassCastException ->Animal cannot be cast to java_knowledge.继承.Cat
    }
}

class Animal{
    public void eat(){
        System.out.println("eat food!");
    }

    public void sleep(){
        System.out.println("......");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("eat fishs!");
    }
}