package com.qdm.cs.usermanagement.service;

import java.util.List;

import com.qdm.cs.usermanagement.entity.SpecializationList;

public interface SpecializationService {

	SpecializationList addSpecializationList(SpecializationList specialization);

	List<SpecializationList> getSpecializationList();

}
