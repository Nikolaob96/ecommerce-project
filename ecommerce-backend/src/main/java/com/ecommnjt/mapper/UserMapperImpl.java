package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.UserDTO;
import com.ecommnjt.model.User;

@Component
public class UserMapperImpl implements UserMapper{

	@Override
	public UserDTO toUserDTO(User user) {
		UserDTO u = new UserDTO();
		
		if(user.getId() != 0) {
			u.setId(user.getId());
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			u.setEmail(user.getEmail());
			return u;
		} else {
			return u;
		}

		
	}

	@Override
	public User toUser(UserDTO user) {
		return new User(user.getId(),user.getUsername(),user.getPassword(),user.getEmail(), user.getRoles());
	}

}
