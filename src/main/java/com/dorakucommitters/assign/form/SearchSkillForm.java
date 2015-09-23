package com.dorakucommitters.assign.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class SearchSkillForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String field;
	private String skill;
	private String name;

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
