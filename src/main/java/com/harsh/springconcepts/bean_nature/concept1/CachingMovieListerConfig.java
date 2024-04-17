package com.harsh.springconcepts.bean_nature.concept1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CachingMovieListerConfig {

    // Second Way
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public CachingMovieLister cachingMovieLister() {
        CachingMovieLister cachingMovieLister = new CachingMovieLister();
        cachingMovieLister.movieName = "KGF";
        return cachingMovieLister;
    }
}
