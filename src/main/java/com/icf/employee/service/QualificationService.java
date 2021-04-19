package com.icf.employee.service;

import java.util.List;

import com.icf.employee.dto.UserDto;
import com.icf.employee.dto.QualificationDto;

public interface QualificationService {

	QualificationDto createQualification(QualificationDto qualificationDto);

	QualificationDto getQualificationById(Long id);

	List<QualificationDto> getAllQualifications();

	void deleteQualificationById(Long id);
}