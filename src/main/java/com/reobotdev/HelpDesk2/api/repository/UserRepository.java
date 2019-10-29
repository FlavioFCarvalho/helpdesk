package com.reobotdev.HelpDesk2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reobotdev.HelpDesk2.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
