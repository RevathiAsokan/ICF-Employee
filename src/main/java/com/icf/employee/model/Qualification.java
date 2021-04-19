package com.icf.employee.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="qualification")
public class Qualification {
	
	public Qualification() {}
	
	public Qualification(Qualification qualification) {
		this.qualificationId = qualification.qualificationId;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long qualificationId;
	
	@ManyToOne
	@JoinColumn(name = "employee_id",nullable = false)
	private User employee;
	
	@Column(nullable = false, length = 100)
	private String type;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	@Column(nullable = false)
	private LocalDate endDate;
	
	@Column(nullable = false, length = 100)
	private String institution;
	
	@Column(nullable = false, length = 25)
	private String address;
	
	
	@Column(nullable = false)
	private int percentage;	
	
}
