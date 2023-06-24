package com.ism.jpasecurity.dto;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 02:51
 * Project : JpaSecurity
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationDto {

    private String username;
    private String password;
    // Getters and setters

    // Additional validation or custom logic as needed
}

