package com.icf.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icf.employee.dto.QualificationDto;
import com.icf.employee.model.Qualification;
import com.icf.employee.repo.QualificationRepo;
import com.icf.employee.service.QualificationService;

@Service
public class QualificationServiceImpl implements QualificationService {

	@Autowired
	QualificationRepo qualificationRepo;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Override
	public QualificationDto createQualification(QualificationDto qualificationDto) {
		Qualification qualification = dozerBeanMapper.map(qualificationDto, Qualification.class);
		if (qualification.getQualificationId() == null) {
		}
		return dozerBeanMapper.map(qualificationRepo.save(qualification), QualificationDto.class);
	}

	@Override
	public QualificationDto getQualificationById(Long id) {

		return dozerBeanMapper.map(qualificationRepo.getOne(id), QualificationDto.class);
	}

	@Override
	public List<QualificationDto> getAllQualifications() {
		List<Qualification> qualificationList = qualificationRepo.findAll();
		return qualificationList.stream().map(g -> dozerBeanMapper.map(g, QualificationDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteQualificationById(Long id) {

		qualificationRepo.deleteById(id);
	}

}
