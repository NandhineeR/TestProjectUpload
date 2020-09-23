package com.qdm.cs.usermanagement.service;

import java.util.List;

import com.qdm.cs.usermanagement.entity.IssuingOrgranization;

public interface IssuingOrganizationService {

	IssuingOrgranization addIssuingOrganizationList(IssuingOrgranization organization);

	List<IssuingOrgranization> getIssuingOrganizationList();
}
