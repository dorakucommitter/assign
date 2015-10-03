package com.dorakucommitters.assign.domain;

import java.util.Date;

public class EngagedInJoinOthers {
	private Date exitProspects;
    private Integer employeeId;
    private Integer projectId;
    private String nickname;
	private String projectName;
	public Date getExitProspects() {
		return exitProspects;
	}
	public void setExitProspects(Date exitProspects) {
		this.exitProspects = exitProspects;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
