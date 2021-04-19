package com.icf.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icf.employee.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUserNameAndUserPassword(String userName, String password);

	User findByEmailId(String email);
	

}
