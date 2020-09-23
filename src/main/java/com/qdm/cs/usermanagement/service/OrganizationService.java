package com.qdm.cs.usermanagement.service;

import java.util.List;

import com.qdm.cs.usermanagement.entity.Organization;

public interface OrganizationService {
	Organization addOrganizationList(Organization organization);

	List<Organization> getOrganizationList();
}
