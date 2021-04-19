package com.icf.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icf.employee.model.Qualification;

public interface QualificationRepo extends JpaRepository<Qualification, Long> {
	
	
}
