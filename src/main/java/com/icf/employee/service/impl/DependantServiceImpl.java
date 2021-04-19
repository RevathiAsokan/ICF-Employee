package com.icf.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icf.employee.dto.DependantDto;
import com.icf.employee.model.Dependant;
import com.icf.employee.repo.DependantRepo;
import com.icf.employee.service.DependantService;

@Service
public class DependantServiceImpl implements DependantService {

	@Autowired
	DependantRepo dependantRepo;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Override
	public DependantDto createDependant(DependantDto dependantDto) {
		Dependant dependant = dozerBeanMapper.map(dependantDto, Dependant.class);
		if (dependant.getDependantId() == null) {
		}
		return dozerBeanMapper.map(dependantRepo.save(dependant), DependantDto.class);
	}

	@Override
	public DependantDto getDependantById(Long id) {

		return dozerBeanMapper.map(dependantRepo.getOne(id), DependantDto.class);
	}

	@Override
	public List<DependantDto> getAllDependants() {
		List<Dependant> dependantList = dependantRepo.findAll();
		return dependantList.stream().map(g -> dozerBeanMapper.map(g, DependantDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteDependantById(Long id) {

		dependantRepo.deleteById(id);
	}

}
