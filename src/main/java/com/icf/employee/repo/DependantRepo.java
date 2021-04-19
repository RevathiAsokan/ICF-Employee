package com.icf.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icf.employee.model.Dependant;

public interface DependantRepo extends JpaRepository<Dependant, Long> {
	
	
}
