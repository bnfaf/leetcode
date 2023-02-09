package org.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


interface SmsService {
    String send(String message);
}
class SmsServiceImpl {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
class DebugInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}

class DebugMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable{
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return object;
    }
}

class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}

public class test {

    public static void main(String[] args) {
        // JDK动态代理
//        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
//        smsService.send("java");
        // CGLIB动态代理
//        SmsServiceImpl smsService = (SmsServiceImpl) CglibProxyFactory.getProxy(SmsServiceImpl.class);
//        smsService.send("java");
//        BigDecimal a = BigDecimal.valueOf(1.1);
//        BigDecimal b = BigDecimal.valueOf(0.9);
//        System.out.println(a.add(b));
//        assert a.equals(b);
//        System.out.println(a.multiply(b));
//        System.out.println(a.compareTo(b));
        Integer [] myArray = { 1, 2, 3 };
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList);
        int[] myarray = {1, 2, 3};
        List<Integer> list = Arrays.stream(myarray).boxed().collect(Collectors.toList());
        System.out.println(list.getClass());

    }
}
