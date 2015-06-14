package lab1.example;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class InjectIntPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            InjectInt annotation = field.getDeclaredAnnotation(InjectInt.class);
            if (annotation != null) {
                Integer newValue = IntServiceLocator.get(annotation.value());
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
