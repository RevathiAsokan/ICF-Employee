package com.icf.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="user_roles")
public class UserRole {
	public UserRole() {}
	
	public UserRole(UserRole userRole) {
		super();
		this.roleId = userRole.roleId;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long roleId;
	
	@Column(length = 25, unique = true, nullable = false)
	private String roleName;
	
	@Column
	private String roleDesc;
}
