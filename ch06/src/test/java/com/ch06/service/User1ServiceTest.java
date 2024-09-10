package com.ch06.service;

import com.ch06.dto.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class User1ServiceTest {

    @Autowired
    private User1Service user1Service;


    @Test
    void insertUser1() {
        // given - 테스트를 실행하기 위한 준비
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("장보고")
                .birth("1992-01-01")
                .hp("010-1234-1003")
                .age(23)
                .build();

        // when - 테스트를 진행
        user1Service.insertUser1(sample);

        // then - 결과 검증
        User1DTO actual = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(sample, actual);
    }

    @Test
    void selectUser1(){
        // given - 테스트를 실행하기 위한 준비
        String uid = "a101";

        // when - 테스트를 진행
        User1DTO expacted = user1Service.selectUser1(uid);

        // then -
        Assertions.assertEquals(expacted.getUid(),uid);
    }
    @Test
    void selectUser1s(){
        List<User1DTO> expected = user1Service.selectUser1s();
        Assertions.assertFalse(expected.isEmpty());

    }
    @Test
    void updateUser1(){


    }
    @Test
    void deleteUser1(){
        String uid = "a303";

        user1Service.deleteUser1(uid);

        User1DTO expacted = user1Service.selectUser1(uid);

        Assertions.assertNull(expacted);
    }

}
