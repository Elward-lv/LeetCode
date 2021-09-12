package java_knowledge.设计模式.创建式.单例模式.静态内部类;

public class MyThread extends Thread {
    @Override
    public void run() {
        //super.run();
        System.out.println("线程名称:"+this.getName()+",线程获取的实例："+StaticClassSingleton.getInstance());
    }
}
