package com.ch10.controller;

import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.jwt.JwtProvider;
import com.ch10.security.MyUserDetails;
import com.ch10.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @GetMapping("/user")
    public ResponseEntity user(Authentication authentication) {
        log.info("user1 - " + authentication);
        User user = (User) authentication.getPrincipal();

        UserDTO userDTO = userService.selectUser(user.getUid());

        return ResponseEntity
                .ok()
                .body(userDTO);

    }

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO){
        log.info("login1 - " + userDTO);

        try {
            // Spring Security 인증 처리
            UsernamePasswordAuthenticationToken authToken
                    = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getPass());

            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info("login2 - " + authentication);

            // 인증된 사용자 객체 가져오기
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            log.info("login3 - " + myUserDetails);

            User user = myUserDetails.getUser();
            log.info("login4 - " + user);

            // 토큰 생성
            String accessToken = jwtProvider.createToken(user, 1); // 1일
            String refreshToken = jwtProvider.createToken(user, 7); // 7일
            log.info("login5 - " + accessToken);

            // Refresh 토큰 DB저장

            // Access, Refresh 토큰 전송
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("accessToken", accessToken);
            resultMap.put("refreshToken", refreshToken);

            return ResponseEntity
                    .ok()
                    .body(resultMap);

        } catch (Exception e) {
            // 인증 실패
            log.info("login6 - catch!!!");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }

}
