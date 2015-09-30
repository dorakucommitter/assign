package com.dorakucommitters.assign.domain;

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
@Table(name = "request_skills")
public class RequestSkills {
    @Id
    @GeneratedValue
    @Column(name = "request_skills_id")
    private Integer requestSkillsId;

    @Column(name = "qualification_id", nullable = false)
	private Integer qualificationId;

    @Column(name = "project_id", nullable = false)
	private Integer projectId;

	public Integer getRequestSkillsId() {
		return requestSkillsId;
	}

	public void setRequestSkillsId(Integer requestSkillsId) {
		this.requestSkillsId = requestSkillsId;
	}

	public Integer getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Integer qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


}
