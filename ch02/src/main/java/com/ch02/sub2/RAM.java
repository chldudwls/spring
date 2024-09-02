package com.ch02.sub2;

import org.springframework.stereotype.Component;

@Component // -> @Controller, @Service @Repository(DAO)
public class RAM {

    public void show(){
        System.out.println("RAM : Samsung 326B");
    }
}
