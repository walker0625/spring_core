package com.minwoo.spring_core.container;

import com.minwoo.spring_core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContainerTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findAllBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionName) {
            Object bean = ac.getBean(s);
            System.out.println("beanName : " + s + " / bean : " + bean);
        }
    }

    @Test
    void findApplicationBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionName) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(s);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(s);
                System.out.println("beanName : " + s + " / bean : " + bean);
            }
        }
    }


}
