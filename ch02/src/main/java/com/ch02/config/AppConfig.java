package com.ch02.config;

import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ch02"})//ch02를 베이스로 함ㅠ
public class AppConfig {

    @Bean
    public Hello hello(){
        return new Hello();
    }

    @Bean(name = "welcome") //생략 가능
    public Welcome welcome(){
        return new Welcome();
    }

    @Bean("greet")//생략 가능
    public Greeting greeting(){
        return new Greeting();
    }



}
