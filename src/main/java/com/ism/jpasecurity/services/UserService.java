package com.ism.jpasecurity.services;

import com.ism.jpasecurity.dto.UserRegistrationDto;
import com.ism.jpasecurity.entities.User;
import com.ism.jpasecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 02:28
 * Project : JpaSecurity
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void register(UserRegistrationDto registrationDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        save(user);
    }
}
