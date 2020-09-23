package com.qdm.cs.usermanagement.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdm.cs.usermanagement.entity.Organization;
import com.qdm.cs.usermanagement.repository.OrganizationRepository;
import com.qdm.cs.usermanagement.service.OrganizationService;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	OrganizationRepository organizationRepository;
	@Override
	public Organization addOrganizationList(Organization organization) {
		Organization organizationById = organizationRepository.findByOrganizationId(organization.getOrganizationId());
		if (organizationById != null) {
			return null;
		} else {
			return organizationRepository.save(organization);
		}
	}
	@Override
	public List<Organization> getOrganizationList() {
		return organizationRepository.findAll();
	}

}
