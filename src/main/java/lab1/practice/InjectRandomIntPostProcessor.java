package lab1.practice;


import lab1.example.IntServiceLocator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            InjectRandomInt annotation = field.getDeclaredAnnotation(InjectRandomInt.class);
            if (annotation != null) {
//                Integer newValue = IntServiceLocator.get(annotation.value());
                Integer bound = RandomIntServiceLocator.get(annotation.value());
                Random random = new Random();
                Integer newValue = random.nextInt(bound);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, newValue);
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
