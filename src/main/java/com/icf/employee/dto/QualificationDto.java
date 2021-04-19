package com.icf.employee.dto;

import lombok.Data;

@Data
public class QualificationDto {

	private Long qualificationId;
	
	private UserDto employee;
	
	private String type;
	
	private String startDate;
	
	private String endDate;

	private String institution;

	private String address;
	
	private int percentage;	
}
