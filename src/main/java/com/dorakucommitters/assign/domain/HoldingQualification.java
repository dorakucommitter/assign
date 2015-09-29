package com.dorakucommitters.assign.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "holding_qualification")
public class HoldingQualification {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
	private Integer employeeId;

    @Column(name = "qualification_id")
    private Integer qualificationId;

    @Column(name = "date_of_acquisition")
    private Date dateOfAcquisition;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Integer qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Date getDateOfAcquisition() {
		return dateOfAcquisition;
	}

	public void setDateOfAcquisition(Date dateOfAcquisition) {
		this.dateOfAcquisition = dateOfAcquisition;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}


}
