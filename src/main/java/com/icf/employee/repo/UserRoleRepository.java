package com.icf.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icf.employee.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
