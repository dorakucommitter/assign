package com.dorakucommitters.assign.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorakucommitters.assign.domain.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Integer> {

	public List<Qualification> findByFieldId(Integer fieldId);


}
