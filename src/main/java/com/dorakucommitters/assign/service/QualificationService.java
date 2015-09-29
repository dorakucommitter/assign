package com.dorakucommitters.assign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dorakucommitters.assign.domain.Qualification;
import com.dorakucommitters.assign.repository.QualificationRepository;

@Service
@Transactional
public class QualificationService {
    @Autowired
    QualificationRepository qualificationRepository;

	public String createQualificationJsonByFieldId(String fieldId) {

		StringBuilder build = new StringBuilder();
        String json;
        build.append("[");

        List<Qualification>qualifications = qualificationRepository.findByFieldId(new Integer(fieldId));

		qualifications.forEach(qualification ->
				build.append("{\"itemValue\": \"")
				.append(qualification.getQualificationId())
				.append("\",\"itemLabel\": \"")
				.append(qualification.getQualificationName())
				.append("\"},"));
		if (qualifications.size() > 0) {
			build.deleteCharAt(build.lastIndexOf(","));
		}
        build.append("]");
        json = build.toString();

        return json;
	}

	public  List<Qualification> createQualificationListByFieldId(Integer fieldId) {
		return qualificationRepository.findByFieldId(fieldId);
	}

}
