package java_knowledge.代理.静态代理;

/**
 * 静态代理模式：
 *      简单的理解就是别人帮你做一件事
 *      真实对象和代理对象都要实现同一个接口
 *      代理对象要代理真实角色，调用真实对象的方法
 *    代理对象可以做一些真实对象不能做的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        Corporation corporation = new Corporation(new You());
        corporation.HappyHarry();
    }
}

interface Marry {
    public abstract void HappyHarry();
}

class You implements Marry {

    @Override
    public void HappyHarry() {
        System.out.println("I have a happy widding! a beautiful wife!");
    }
}

class Corporation implements Marry{
    private You you;

    public Corporation(You you) {
        this.you = you;
    }

    @Override
    public void HappyHarry() {
        System.out.println("我们为你制版婚礼！");
        System.out.println("我们为你邀请友人!");
        you.HappyHarry();
        System.out.println("我们为你清理结束事宜!");
    }
}