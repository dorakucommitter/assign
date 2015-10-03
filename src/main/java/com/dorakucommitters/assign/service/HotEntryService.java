package com.dorakucommitters.assign.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dorakucommitters.assign.domain.EngagedInJoinOthers;
import com.dorakucommitters.assign.domain.ProjectJoinOthers;

@Service
@Transactional
public class HotEntryService {
	@PersistenceContext
	private EntityManager entityManager;

	public List<ProjectJoinOthers> createProjectJoinOthersList() {


		TypedQuery<ProjectJoinOthers> query = entityManager.createQuery(
		        "select new com.dorakucommitters.assign.domain.ProjectJoinOthers(p.projectId, p.projectName, p.wantedStart, p.wantedEnd, q.qualificationName) "
		          + "from Project p, RequestSkills r, Qualification q "
		          + "where p.projectId = r.projectId and r.qualificationId = q.qualificationId "
		          + "order by p.wantedStart desc "
		          ,ProjectJoinOthers.class
		);

		List<ProjectJoinOthers> projects = query.setMaxResults(5).getResultList();
		return projects;
	}

	public List<EngagedInJoinOthers> createEngagedInJoinOthersList() {
		return null;
	}
}
