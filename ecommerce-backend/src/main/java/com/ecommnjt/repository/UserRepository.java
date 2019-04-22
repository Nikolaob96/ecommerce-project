package com.ecommnjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommnjt.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
