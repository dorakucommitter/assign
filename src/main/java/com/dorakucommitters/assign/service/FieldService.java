package com.dorakucommitters.assign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dorakucommitters.assign.domain.Field;
import com.dorakucommitters.assign.repository.FieldRepository;

@Service
@Transactional
public class FieldService {
    @Autowired
    FieldRepository feildRepository;

	public List<Field> findAll() {
        return feildRepository.findAll();
	}

}
