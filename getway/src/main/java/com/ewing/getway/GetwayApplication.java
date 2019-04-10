package com.ewing.getway;

import com.ewing.getway.filter.PasswordFilter;
import com.ewing.getway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GetwayApplication {

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }


    @Bean
    public PasswordFilter passwordFilter(){
        return new PasswordFilter();
    };

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

}
