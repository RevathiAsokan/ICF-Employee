package com.icf.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icf.employee.dto.CustomUserDetails;
import com.icf.employee.dto.LoginDto;
import com.icf.employee.dto.UserDto;
import com.icf.employee.security.TokenUtil;
import com.icf.employee.service.UserService;
import com.icf.employee.service.impl.UserServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/employee")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserServiceImpl userDetailService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtil jwtTokenUtil;

	@ApiOperation(value = "Login", notes = "This api is used to Login the User", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/auth/login")
	public UserDto loginUser(@RequestBody LoginDto loginDto, Device device) {
		UserDto userDto = userService.loginUser(loginDto);

		// Perform the security
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmailId(), userDto.getUserPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final CustomUserDetails userDetails = (CustomUserDetails) userDetailService
				.loadUserByUsername(userDto.getEmailId());
		final String token = jwtTokenUtil.generateToken(userDetails, device);
		userDto.setToken(token);
		return userDto;

	}

	@ApiOperation(value = "save User", notes = "This api is used to save the User", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@PostMapping("/auth/user")
	public UserDto saveUserDto(@RequestBody UserDto userDto, Device device) {
		UserDto userResDto = userService.createUser(userDto);

		// Perform the security
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userResDto.getEmailId(), userResDto.getUserPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final CustomUserDetails userDetails = (CustomUserDetails) userDetailService
				.loadUserByUsername(userResDto.getEmailId());
		final String token = jwtTokenUtil.generateToken(userDetails, device);
		userResDto.setToken(token);
		return userResDto;

	}

	@ApiOperation(value = "get all Users", notes = "This api is used to get all the Users", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/users")
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();

	}

	@ApiOperation(value = "get User by Id", notes = "This api is used to get the User by Id", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/user/{id}")
	public UserDto getUserById(@PathVariable Long id) {

		return userService.getUserById(id);
	}

	@ApiOperation(value = "delete User by Id", notes = "This api is used to delete the User by Id", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

}
