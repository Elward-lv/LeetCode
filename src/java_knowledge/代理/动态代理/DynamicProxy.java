package java_knowledge.代理.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理的简单使用
 *   通过给计算器类加上简单的日志
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Calucate cal = new MyCalucate();//被代理对象
        Calucate calucateProxy = getCalucateProxy(cal);
        //代理对象执行add方法
        calucateProxy.add(1,5);
    }

    //返回代理对象
    public static Calucate getCalucateProxy(Calucate calucate){
        Object proxyInstance = Proxy.newProxyInstance(calucate.getClass().getClassLoader(), calucate.getClass().getInterfaces() , new InvocationHandler() {
            /**
             * @param proxy 代理对象 任何时候都不要动这个对象
             * @param method 目标对象的方法,利用反射执行方法
             * @param args 方法的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("===============>run "+method.getName()+" 参数:"+ Arrays.toString(args));
                //反射需要执行的方法，第一个参数是需要执行方法的对象，第二个是方法的参数
                Object res = method.invoke(calucate , args);
                System.out.println("===============>finish "+method.getName() + " 结果:"+res);
                return res;
            }
        });
        return (Calucate) proxyInstance;
    }
}

class MyCalucate implements Calucate{

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sec(int a, int b) {
        return a - b;
    }
}

interface Calucate{
    public abstract int add(int a, int b);

    public  abstract int sec(int a, int b);

}
