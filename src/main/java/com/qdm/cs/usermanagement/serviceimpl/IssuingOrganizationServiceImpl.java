package com.qdm.cs.usermanagement.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdm.cs.usermanagement.entity.IssuingOrgranization;
import com.qdm.cs.usermanagement.entity.Organization;
import com.qdm.cs.usermanagement.repository.IssuingOrganizationRepository;
import com.qdm.cs.usermanagement.service.IssuingOrganizationService;

@Service
@Transactional
public class IssuingOrganizationServiceImpl implements IssuingOrganizationService{

	@Autowired
	IssuingOrganizationRepository issuingOrganizationRepository;
	
	@Override
	public IssuingOrgranization addIssuingOrganizationList(IssuingOrgranization organization) {
		Organization organizationById = issuingOrganizationRepository.findByOrganizationId(organization.getOrganizationId());
		if (organizationById != null) {
			return null;
		} else {
			return issuingOrganizationRepository.save(organization);
		}
	}
	
	@Override
	public List<IssuingOrgranization> getIssuingOrganizationList() {
		return issuingOrganizationRepository.findAll();
	}

}
