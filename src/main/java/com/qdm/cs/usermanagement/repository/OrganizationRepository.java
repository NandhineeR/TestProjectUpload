package com.qdm.cs.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qdm.cs.usermanagement.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

	Organization findByOrganizationId(int organizationId);

}
