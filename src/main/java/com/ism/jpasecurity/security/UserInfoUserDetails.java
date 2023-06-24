package com.ism.jpasecurity.security;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 08:24
 * Project : JpaSecurity
 */
import com.ism.jpasecurity.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {


    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(User userInfo) {
        username=userInfo.getUsername();
        password=userInfo.getPassword();
        authorities = userInfo.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

