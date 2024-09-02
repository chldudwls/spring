package com.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")//이름 등록
public class Computer {

    // 필드 주입
    @Autowired
    private CPU cpu;
    private Ssd ssd;

    // 생성자 주입
    @Autowired
    public Computer(Ram ram){
        this.ram = ram;
    }
    //
    @Autowired
    public void set(Ssd ssd){
        this.ssd = ssd;
    }

    public void show(){
        cpu.show();
        ram.show();
        ssd.show();
    }
}
