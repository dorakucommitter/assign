package com.dorakucommitters.assign.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dorakucommitters.assign.domain.HoldingQualificationJoinOthers;
import com.dorakucommitters.assign.form.SearchSkillForm;

@Service
@Transactional
public class HoldingQualificationService {
	@PersistenceContext
	private EntityManager entityManager;

	public String createSkillList(SearchSkillForm dto) {
		TypedQuery<HoldingQualificationJoinOthers> query = entityManager.createQuery(
		        "select new com.dorakucommitters.assign.domain.HoldingQualificationJoinOthers(e.employeeId, h.dateOfAcquisition, h.yearsOfExperience, e.name, q.qualificationName) "
		          + "from Employee e, HoldingQualification h, Qualification q, Field f "
		          + "where e.employeeId = h.employeeId and h.qualificationId = q.qualificationId and q.fieldId = f.fieldId "
		          +  (StringUtils.isEmpty(dto.getField()) ? "" : "and f.fieldId = :fieldId ")
		          +  (StringUtils.isEmpty(dto.getSkill()) ? "" : "and q.qualificationId = :qualificationId ")
		          +  (StringUtils.isEmpty(dto.getName()) ? "" : "and e.name like :name ")
		          ,HoldingQualificationJoinOthers.class
		);
		if (!StringUtils.isEmpty(dto.getField())) {
			query.setParameter("fieldId", new Integer(dto.getField()));
		}
		if (!StringUtils.isEmpty(dto.getSkill())) {
			query.setParameter("qualificationId", new Integer(dto.getSkill()));
		}
		if (!StringUtils.isEmpty(dto.getName())) {
			query.setParameter("name", dto.getName() + "%");
		}

		List<HoldingQualificationJoinOthers> summary = query.getResultList();
		String json = "";
		if (summary.size() > 0) {
	    	StringBuilder s = new StringBuilder();
	        s.append("[");
			for (HoldingQualificationJoinOthers rec : summary) {
	            s.append("{\"itemName\": \"");
	            s.append(rec.getName());
	            s.append("\",");
	            s.append("\"itemSkill\": \"");
	            s.append(rec.getQualificationName());
	            s.append("\",");
	            s.append("\"itemExperience\": \"");
	            s.append(rec.getYearsOfExperience());
	            s.append("\"},");
	        }
	        s.deleteCharAt(s.lastIndexOf(","));
	        s.append("]");
	        json = s.toString();
		}
		return json;
	}
}
