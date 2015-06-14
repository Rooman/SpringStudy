package lab2.example;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class ReplaceDeprecationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            String currentClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> clazz = Class.forName(currentClassName);
                DeprecatedClass clazzAnnotation = clazz.getAnnotation(DeprecatedClass.class);
                if (clazzAnnotation != null) {
                    beanDefinition.setBeanClassName(clazzAnnotation.value().getCanonicalName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
