package com.qdm.cs.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qdm.cs.usermanagement.entity.IssuingOrgranization;
import com.qdm.cs.usermanagement.entity.Organization;

@Repository
public interface IssuingOrganizationRepository extends JpaRepository<IssuingOrgranization, Integer> {

	Organization findByOrganizationId(int organizationId);

}
