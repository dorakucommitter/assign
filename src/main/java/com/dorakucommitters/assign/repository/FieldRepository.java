package com.dorakucommitters.assign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorakucommitters.assign.domain.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {

}
