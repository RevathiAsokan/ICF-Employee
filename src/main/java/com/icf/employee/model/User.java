package com.icf.employee.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="users", indexes = @Index(columnList = "firstName , lastName"))
public class User {
	
	public User() {}
	
	public User(User user) {
		super();
		this.employeeId = user.employeeId;
		this.userName = user.userName;
		this.emailId = user.emailId;
		this.userPassword = user.userPassword;
		this.userRole = user.userRole;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long employeeId;
	
	@ManyToOne
	@JoinColumn(name = "role_id",nullable = false)
	private UserRole userRole;
	
	@Column(nullable = false, length = 100)
	private String firstName;
	
	@Column(nullable = false, length = 100)
	private String lastName;
	
	@Column(nullable = false)
	private Long employmentId;
	
	@Column(nullable = false, length = 100)
	private String emailId;
	
	@Column(nullable = false, length = 100)
	private String userName;

	@Column(nullable = false, length = 100)
	private String userPassword;
	
	@Column(nullable = true)
	private Date createdDate;
	
	@Column(nullable = false, length = 100)
	private String designation;
	
	@Column(nullable = false, length = 100)
	private String department;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	@Column(nullable = true)
	private LocalDate endDate;
	
	@Column(nullable = false, length = 100)
	private String status;
	
	@Column(nullable = false)
	private LocalDate dob;
	
	@Column(nullable = false)
	private Long reportingManager;
	
	@Column(nullable = false, length = 100)
	private String gender;
	
	@Column(nullable = false, length = 100)
	private String bloodGroup;
	
	@Column(nullable = false, length = 150)
	private String address;
}
