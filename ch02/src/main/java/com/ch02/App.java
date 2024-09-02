package com.ch02;

import com.ch02.config.AppConfig;
import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 날짜 : 2024/09/02
 * 이름 : 최영진
 * 내용 : 2장 Spring IoC/DI 실습하기
 *
 * @Configu
 *
 * @Been
 *
 *
 *
 */
public class App 
{
    public static void main( String[] args ){

        // 스프링 커네이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 빈 가져오기
        Hello hello = context.getBean(Hello.class);
        hello.show();

        Welcome welcome = (Welcome) context.getBean("welcome");
        welcome.show();

        Greeting greeting = (Greeting) context.getBean("greet");
        greeting.show();


        // IoC/DI 실습
        Computer com = context.getBean("com");
        com.show;


    }
}
