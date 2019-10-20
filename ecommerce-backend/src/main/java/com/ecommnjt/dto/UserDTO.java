package com.ecommnjt.dto;

import java.util.Set;

import com.ecommnjt.model.Role;
import com.ecommnjt.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class UserDTO {
	
	@Getter @Setter
	private int id;
	@Getter @Setter
	private String username;
	@Getter @Setter
	private String password;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private Set<Role> roles;
	
//	public UserDTO(User user) {
//		if(user.getId() != 0) {
//			this.id = user.getId();
//		}
//		this.username = user.getUsername();
//		this.password = user.getPassword();
//		this.email = user.getEmail();
//	}
//	
//	public static User getUser(UserDTO user) {
//		return new User(user.getId(),user.getUsername(),user.getPassword(),user.getEmail(), user.getRoles());
//	}
	
}
