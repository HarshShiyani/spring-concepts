package com.harsh.springconcepts.bean_nature.concept1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CachingMovieLister {

    public String movieName = "The Mask";

    @PostConstruct
    public void populateMovieCache() {
        System.out.println("Post Construct Method Called: Populating Movie Cache....");
    }

    @PreDestroy
    public void clearMovieCache() {
        System.out.println("Pre Destroy Method Called: Clearing Movie Cache....");
    }

    public void initMethod() {
         System.out.println("Init Method Called: Initializing Movie Cache....");
    }

    public void destroyMethod() {
         System.out.println("Destroy Method Called: Destroying Movie Cache....");
    }
}
