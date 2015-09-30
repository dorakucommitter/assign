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
@Table(name = "engaged_in")
public class EngagedIn {
    @Id
    @GeneratedValue
    @Column(name = "engaged_in_id")
    private Integer engagedInId;

    @Column(name = "engaged_in_start")
	private Date engagedInStart;

    @Column(name = "engaged_in_end")
	private Date engagedInEnd;

    @Column(name = "exit_prospects")
	private Date exitProspects;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "project_id")
    private Integer projectId;

}
