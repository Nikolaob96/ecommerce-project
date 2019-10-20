package com.ecommnjt.mapper;

import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.dto.UserDTO;
import com.ecommnjt.model.Product;
import com.ecommnjt.model.User;

public interface UserMapper {
	
	UserDTO toUserDTO(User user);
	
	User toUser(UserDTO userDTO);
}
