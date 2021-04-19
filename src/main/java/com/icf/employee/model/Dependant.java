package com.icf.employee.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="dependant", indexes = @Index(columnList = "firstName , lastName"))
public class Dependant {
	
	public Dependant() {}
	
	public Dependant(Dependant dependant) {
		this.dependantId = dependant.dependantId;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long dependantId;
	
	@ManyToOne
	@JoinColumn(name = "employee_id",nullable = false)
	private User employee;
	
	@Column(nullable = false, length = 100)
	private String firstName;
	
	@Column(nullable = false, length = 100)
	private String lastName;
	
	@Column(nullable = false, length = 25)
	private String gender;
	
	@Column(nullable = false)
	private LocalDate dob;
	
	@Column(nullable = false, length = 100)
	private String relationship;
	
	
}
