package com.harsh.springconcepts.bean_scopes.concept1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
public class PrototypeBean {

    private String message = "Test";

    public PrototypeBean() {
        System.out.println("Prototype bean has been created");
    }
}
