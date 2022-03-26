package java_knowledge.代理.接口代理;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 不提供接口的实现，而是直接让代理代理，从而获取类似于mybatis的proxy功能
 * @Author: lvyanwei
 * @Date: 2022-03-15
 */
public class InterfaceProxy {

    private static final int ALLOWED_MODES = MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED
            | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC;

    public static void main(String[] args) {
        Calucate proxy = getProxy();
        int res = proxy.add(10, 20);
        System.out.println(res);
    }

    public static Calucate getProxy(){
        Object proxyInstance = Proxy.newProxyInstance(Calucate.class.getClassLoader(),
                                    new Class[]{Calucate.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method + "- > "+ Arrays.toString(args));
                System.out.println(method.getDeclaringClass());
                if(method.getDeclaringClass().equals(Object.class)){
                    return method.invoke(this, args);
                }else {
                    //简单的加法计算，复杂的可以匹配各种方法
                    return (int)args[0] + (int)args[1];
                }
            }
        });
        return (Calucate) proxyInstance;
    }
}

interface Calucate{
    int add(int a , int b);

    int sub(int a, int b);
}
