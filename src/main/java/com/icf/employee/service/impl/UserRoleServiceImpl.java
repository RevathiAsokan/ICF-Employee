package com.icf.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icf.employee.dto.UserRoleDto;
import com.icf.employee.model.UserRole;
import com.icf.employee.repo.UserRoleRepository;
import com.icf.employee.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleRepository roleRepository;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Override
	public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
		UserRole userRole = dozerBeanMapper.map(userRoleDto, UserRole.class);
		return dozerBeanMapper.map(roleRepository.save(userRole), UserRoleDto.class);
	}

	@Override
	public UserRoleDto getUserRoleById(Long id) {

		return dozerBeanMapper.map(roleRepository.getOne(id), UserRoleDto.class);
	}

	@Override
	public List<UserRoleDto> getAllUserRoles() {
		List<UserRole> userRoles = roleRepository.findAll();
		return userRoles.stream().map(g -> dozerBeanMapper.map(g, UserRoleDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteUserRole(Long id) {

		roleRepository.deleteById(id);

	}

}
