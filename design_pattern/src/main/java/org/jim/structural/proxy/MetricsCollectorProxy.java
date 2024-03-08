package org.jim.structural.proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
代理模式：它在不改变原始类（或者叫被代理类）代码的情况下，通过引入代理类来给原始类附加功能
代理模式最常用的一个应用场景就是，在业务系统中开发一些非功能性需求，
比如：监控、统计、鉴权、限流、事务、幂等、日志。
我们将这些附加功能与业务功能解耦，放到代理类中统一处理，让程序员只需要关注业务方面的开发。
Spring AOP 底层的实现原理就是基于动态代理。
 */

public class MetricsCollectorProxy {
    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            //
            Object result = method.invoke(proxiedObject, args);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }

    public static void main(String[] args) {

        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserService userService = (IUserService) proxy.createProxy(new UserService());
        userService.printUserName();

    }
}

