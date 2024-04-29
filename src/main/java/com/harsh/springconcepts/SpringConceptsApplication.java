package com.harsh.springconcepts;

import com.harsh.springconcepts.bean_nature.concept1.CachingMovieLister;
import com.harsh.springconcepts.bean_scopes.concept1.PrototypeBean;
import com.harsh.springconcepts.bean_scopes.concept1.SingletonBean;
import com.harsh.springconcepts.evets.concept1.EmailService;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringConceptsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(
            SpringConceptsApplication.class,
            args);

        // beanScopeConcept1(context);
        // beanNatureConcept1(context);
        eventsConcept1(context);
    }

    public static void beanScopeConcept1(ApplicationContext applicationContext) {
        SingletonBean singletonBean = (SingletonBean) applicationContext.getBean("singletonBean");

        PrototypeBean prototypeBean1 = singletonBean.getPrototypeBean();
        PrototypeBean prototypeBean2 = singletonBean.getPrototypeBean();
        System.out.println("PrototypeBean1 : " + prototypeBean1);
        System.out.println("PrototypeBean2 : " + prototypeBean2);
        System.out.println("Are both prototype beans same ? " + (prototypeBean1 == prototypeBean2));
    }

    public static void beanNatureConcept1(ConfigurableApplicationContext applicationContext) {

        String[] beanNamesForType = applicationContext.getBeanNamesForType(
            CachingMovieLister.class);
        System.out.println(beanNamesForType);

        CachingMovieLister cachingMovieLister = (CachingMovieLister) applicationContext.getBean(beanNamesForType[0]);
        System.out.println(cachingMovieLister);
    }

    public static void eventsConcept1(ConfigurableApplicationContext applicationContext) {
        EmailService emailService = applicationContext.getBean(EmailService.class);
        emailService.setBlockedList(Collections.singletonList("iamblocked@gmail.com"));
        emailService.sendEmail("iamblocked@gmail.com", "Hello There...");
    }
}
