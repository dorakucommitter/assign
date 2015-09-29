package com.dorakucommitters.assign.domain;

import java.util.Date;


public class HoldingQualificationJoinOthers {
    private Integer employeeId;
    private Date dateOfAcquisition;
    private Integer yearsOfExperience;
    private String name;
 	private String qualificationName;

	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}
	public HoldingQualificationJoinOthers(Integer employeeId,
			Date dateOfAcquisition, Integer yearsOfExperience, String name, String qualificationName) {
		this.employeeId = employeeId;
		this.dateOfAcquisition = dateOfAcquisition;
		this.yearsOfExperience = yearsOfExperience;
		this.name = name;
		this.qualificationName = qualificationName;
	}
	public HoldingQualificationJoinOthers() {}

}
