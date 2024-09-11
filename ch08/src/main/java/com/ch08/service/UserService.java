package com.ch08.service;

import com.ch08.dto.UserDto;
import com.ch08.entity.User;
import com.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void insertUser(UserDto userDto) {

        //회원가입
        String encoded = passwordEncoder.encode(userDto.getPass());
        userDto.setPass(encoded);

        User user = userDto.toEntity();
        userRepository.save(user);
    }

    public UserDto selectUser(String uid) {

        Optional<User> optUser = userRepository.findById(uid);

        if(optUser.isPresent()) {
            User user = optUser.get();
            return user.toDTo();
        }
        return null;
    }
}
