package com.dorakucommitters.assign.domain;

import java.util.Date;

public class ProjectJoinOthers {
    private Integer projectId;
	private String projectName;
	private Date wantedStart;
	private Date wantedEnd;
	private String qualificationName;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getWantedStart() {
		return wantedStart;
	}
	public void setWantedStart(Date wantedStart) {
		this.wantedStart = wantedStart;
	}
	public Date getWantedEnd() {
		return wantedEnd;
	}
	public void setWantedEnd(Date wantedEnd) {
		this.wantedEnd = wantedEnd;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public ProjectJoinOthers() {}

	public ProjectJoinOthers(Integer projectId, String projectName,
			Date wantedStart, Date wantedEnd, String qualificationName) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.wantedStart = wantedStart;
		this.wantedEnd = wantedEnd;
		this.qualificationName = qualificationName;
	}



}
