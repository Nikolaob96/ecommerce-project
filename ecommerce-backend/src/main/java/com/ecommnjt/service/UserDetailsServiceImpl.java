package com.ecommnjt.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.User;
import com.ecommnjt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
	@Autowired
	private UserRepository users;
   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = users.findByUsername(username).get();

		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			List<GrantedAuthority> grantedAuthority = user.getRoles().stream()
					.map(authority -> new SimpleGrantedAuthority(authority.getName()))
					.collect(Collectors.toList());

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthority);
		}
    }
}
