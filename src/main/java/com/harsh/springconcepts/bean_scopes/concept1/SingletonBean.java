package com.harsh.springconcepts.bean_scopes.concept1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private PrototypeBean prototypeBean;

    public SingletonBean() {
        System.out.println("SingletonBean has been created");
    }

    @Autowired
    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    // First Way - Spring will be responsible to return new prototype bean
    @Lookup("prototypeBean")
    public PrototypeBean getPrototypeBean() {
        return null;
    }

    // Second Way
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

/*  public PrototypeBean getPrototypeBean() {
        return (PrototypeBean) applicationContext.getBean("prototypeBean");
    }
*/

}
