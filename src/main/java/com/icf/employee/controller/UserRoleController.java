package com.icf.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icf.employee.dto.UserRoleDto;
import com.icf.employee.service.UserRoleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/employee")
public class UserRoleController {

	@Autowired
	UserRoleService userRoleService;

	@ApiOperation(value = "save UserRole", notes = "This api is used to save the UserRole", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@PostMapping("/userRole")
	public UserRoleDto saveUserRoleDto(@RequestBody UserRoleDto userRoleDto) {
		return userRoleService.createUserRole(userRoleDto);

	}

	@ApiOperation(value = "get all UserRoles", notes = "This api is used to get all the UserRoles", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/userroles")
	public List<UserRoleDto> getAllUserRoles() {
		return userRoleService.getAllUserRoles();

	}

	@ApiOperation(value = "get UserRole by Id", notes = "This api is used to get the UserRole by Id", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/userRole/{id}")
	public UserRoleDto getUserRoleById(@PathVariable Long id) {

		return userRoleService.getUserRoleById(id);
	}

	@ApiOperation(value = "delete UserRole by Id", notes = "This api is used to delete the UserRole by Id", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@DeleteMapping("/userRole/{id}")
	public void deleteUserRoleById(@PathVariable Long id) {
		userRoleService.deleteUserRole(id);
	}

}
