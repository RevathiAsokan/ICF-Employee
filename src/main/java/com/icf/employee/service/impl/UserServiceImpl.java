package com.icf.employee.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icf.employee.dto.CustomUserDetails;
import com.icf.employee.dto.LoginDto;
import com.icf.employee.dto.UserDto;
import com.icf.employee.model.User;
import com.icf.employee.repo.UserRepo;
import com.icf.employee.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = dozerBeanMapper.map(userDto, User.class);
		if (user.getEmployeeId() == null) {
			user.setCreatedDate(new Date());
		}
		return dozerBeanMapper.map(userRepo.save(user), UserDto.class);
	}

	@Override
	public UserDto getUserById(Long id) {

		return dozerBeanMapper.map(userRepo.getOne(id), UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> userList = userRepo.findAll();
		return userList.stream().map(g -> dozerBeanMapper.map(g, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteUserById(Long id) {

		userRepo.deleteById(id);
	}

	@Override
	public UserDto loginUser(LoginDto loginDto) {

		User user = userRepo.findByUserNameAndUserPassword(loginDto.getUserName(), loginDto.getPassword());
		return dozerBeanMapper.map(user, UserDto.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmailId(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		} else {
			String userRoles = user.getUserRole().getRoleName();
			return new CustomUserDetails(user, userRoles);
		}

	}

}
