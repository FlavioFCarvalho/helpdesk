package com.reobotdev.HelpDesk2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reobotdev.HelpDesk2.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Transactional(readOnly = true)
	User findByEmail (String email);

}
