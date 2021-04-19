package com.icf.employee.dto;

import lombok.Data;

@Data
public class DependantDto {
	
private Long dependantId;

private UserDto employee;

private String firstName;

private String lastName;

private String gender;

private String dob;

private String relationship;

}
