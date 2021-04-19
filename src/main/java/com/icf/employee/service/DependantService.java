package com.icf.employee.service;

import java.util.List;
import com.icf.employee.dto.DependantDto;

public interface DependantService {

	DependantDto createDependant(DependantDto dependantDto);

	DependantDto getDependantById(Long id);

	List<DependantDto> getAllDependants();

	void deleteDependantById(Long id);
}
