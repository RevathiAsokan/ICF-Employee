package com.icf.employee.service;

import java.util.List;

import com.icf.employee.dto.LoginDto;
import com.icf.employee.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto getUserById(Long id);

	List<UserDto> getAllUsers();

	void deleteUserById(Long id);
	
	UserDto loginUser(LoginDto loginDto);

}
