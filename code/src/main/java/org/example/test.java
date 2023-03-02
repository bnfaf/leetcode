package org.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;


interface SmsService {
    String send(String message);
}
class SmsServiceImpl {
    public SmsServiceImpl(){
        System.out.println("init service");
    }
    public SmsServiceImpl(String str){
        System.out.println(str);
    }
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

class MyRunnable implements Runnable {
    private String command;
    public MyRunnable(String command){
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " "+  this.command + " Start. Time=" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " "+  this.command + " End. Time=" + new Date());
    }
    public void processCommand(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString(){
        return this.command;
    }
}

/**
 * @author 10840
 */
public class test {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void pushWeek(){
        //一周后的日期
        LocalDate localDate = LocalDate.now();
        //方法1
        LocalDate after = localDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后日期：" + after);
        //方法2
        LocalDate after2 = localDate.plusWeeks(1);
        System.out.println("一周后日期：" + after);

        //算两个日期间隔多少天，计算间隔多少年，多少月
        LocalDate date1 = LocalDate.parse("2021-02-26");
        LocalDate date2 = LocalDate.parse("2021-12-23");
        Period period = Period.between(date1, date2);
        System.out.println("date1 到 date2 相隔："
                + period.getYears() + "年"
                + period.getMonths() + "月"
                + period.getDays() + "天");
        //打印结果是 “date1 到 date2 相隔：0年9月27天”
        //这里period.getDays()得到的天是抛去年月以外的天数，并不是总天数
        //如果要获取纯粹的总天数应该用下面的方法
        long day = date2.toEpochDay() - date1.toEpochDay();
        System.out.println(date1 + "和" + date2 + "相差" + day + "天");
        //打印结果：2021-02-26和2021-12-23相差300天
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> submit = executorService.submit(()->{
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        String s = submit.get();
        System.out.println(s);
        executorService.shutdown();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                CORE_POOL_SIZE,
//                MAX_POOL_SIZE,
//                KEEP_ALIVE_TIME,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//
//        for (int i = 0; i < 10; i++){
//            Runnable worker = new MyRunnable("" + i);
//            threadPoolExecutor.execute(worker);
//        }
//        threadPoolExecutor.shutdown();
//        while (!threadPoolExecutor.isTerminated()){
//
//        }
//        System.out.println("Finished all threads");


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
//        Integer [] myArray = { 1, 2, 3 };
//        List myList = Arrays.stream(myArray).collect(Collectors.toList());
//        System.out.println(myList);
//        int[] myarray = {1, 2, 3};
//        List<Integer> list = Arrays.stream(myarray).boxed().collect(Collectors.toList());
//        System.out.println(list.getClass());
//        Integer i = null;
//        Optional.ofNullable(i).ifPresent(t -> System.out.println(t.intValue()));
//
//        int j = 4;
//        Optional.ofNullable(j).ifPresent(t -> System.out.println(t.intValue()));
//        LocalDate date = LocalDate.of(2021, 1, 26);
//        System.out.println(date);
//        LocalDate date1 = LocalDate.parse("2021-01-26");
//        System.out.println(date1);
//
//        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 26, 12, 12, 22);
//        System.out.println(dateTime);
//        LocalDateTime dateTime1 = LocalDateTime.parse("2021-01-26T12:12:22");
//        System.out.println(dateTime1);
//
//        LocalTime time = LocalTime.of(12, 12, 22);
//        System.out.println(time);
//        LocalTime parse = LocalTime.parse("12:12:22");
//        System.out.println(parse);
//        pushWeek();

    }
}
