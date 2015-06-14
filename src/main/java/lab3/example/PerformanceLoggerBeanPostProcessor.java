package lab3.example;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class PerformanceLoggerBeanPostProcessor implements BeanPostProcessor {
    Map<String, Class<?>> map = new HashMap<String, Class<?>>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Logger annotation = beanClass.getAnnotation(Logger.class);
        if (annotation != null) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class<?> clazz = map.get(beanName);
        if (clazz != null) {
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    long start = System.currentTimeMillis();
                    Object value = ReflectionUtils.invokeMethod(method, bean, args);
                    System.out.println("Execution took = " + (System.currentTimeMillis() - start));
                    return value;
                }
            });
        }

        return bean;
    }
}
