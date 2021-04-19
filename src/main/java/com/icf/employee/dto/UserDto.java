package com.icf.employee.dto;

import lombok.Data;

@Data
public class UserDto {

	private Long employeeId;
	
	private UserRoleDto userRole;
	
	private String firstName;
	
	private String lastName;
	
	private Long employmentId;
	
	private String emailId;
	
	private String userName;

	private String userPassword;
	
	private String createdDate;
	
	private String startDate;
	
	private String designation;
	
	private String department;
	
	private String endDate;
	
	private String status;
	
	private String dob;
	
	private Long reportingManager;
	
	private String gender;
	
	private String bloodGroup;
	
	private String address;
	
	private String token;

}
