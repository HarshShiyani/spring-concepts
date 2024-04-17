package com.harsh.springconcepts;

import com.harsh.springconcepts.bean_scopes.concept1.PrototypeBean;
import com.harsh.springconcepts.bean_scopes.concept1.SingletonBean;
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

        beanScopeConcept1(context);
    }

    public static void beanScopeConcept1(ApplicationContext applicationContext) {
        SingletonBean singletonBean = (SingletonBean) applicationContext.getBean("singletonBean");

        PrototypeBean prototypeBean1 = singletonBean.getPrototypeBean();
        PrototypeBean prototypeBean2 = singletonBean.getPrototypeBean();
        System.out.println("PrototypeBean1 : " + prototypeBean1);
        System.out.println("PrototypeBean2 : " + prototypeBean2);
        System.out.println("Are both prototype beans same ? " + (prototypeBean1 == prototypeBean2));
    }
}
