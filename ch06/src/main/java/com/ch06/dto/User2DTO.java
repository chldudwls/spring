package com.ch06.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User2DTO {
    private String uid;
    private String name;
    private String birth;
    private String addr;
}
