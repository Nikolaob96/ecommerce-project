package com.ecommnjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.User;
import com.ecommnjt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository users;
    public UserDetailsServiceImpl(UserRepository users) {
        this.users = users;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  this.users.findByUsername(username).get();
        List<GrantedAuthority> list = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),list);
    }
}
