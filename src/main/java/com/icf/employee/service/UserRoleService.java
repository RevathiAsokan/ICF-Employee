package com.icf.employee.service;

import java.util.List;

import com.icf.employee.dto.UserRoleDto;

public interface UserRoleService {

	UserRoleDto createUserRole(UserRoleDto userRoleDto);

	UserRoleDto getUserRoleById(Long id);

	List<UserRoleDto> getAllUserRoles();

	void deleteUserRole(Long id);

}
