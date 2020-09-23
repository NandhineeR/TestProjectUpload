package com.qdm.cs.usermanagement.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdm.cs.usermanagement.entity.SpecializationList;
import com.qdm.cs.usermanagement.repository.SpecializationRepository;
import com.qdm.cs.usermanagement.service.SpecializationService;

@Service
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

	@Autowired
	SpecializationRepository specializationRepository;

	@Override
	public SpecializationList addSpecializationList(SpecializationList specialization) {
		SpecializationList specById = specializationRepository.findByValue(specialization.getValue());
		if (specById != null) {
			return null;
		} else {
			return specializationRepository.save(specialization);
		}
	}

	@Override
	public List<SpecializationList> getSpecializationList() {
		return specializationRepository.findAll();
	}

}
