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
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "project_name")
	private String projectName;

    @Column(name = "start_of_project")
	private Date startOfProject;

    @Column(name = "end_of_project")
	private Date endOfProject;

    @Column(name = "wanted_start")
	private Date wantedStart;

    @Column(name = "wanted_end")
	private Date wantedEnd;

    @Column(name = "outline")
	private String outline;

    @Column(name = "scale")
	private String scale;

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

	public Date getStartOfProject() {
		return startOfProject;
	}

	public void setStartOfProject(Date startOfProject) {
		this.startOfProject = startOfProject;
	}

	public Date getEndOfProject() {
		return endOfProject;
	}

	public void setEndOfProject(Date endOfProject) {
		this.endOfProject = endOfProject;
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

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}


}
