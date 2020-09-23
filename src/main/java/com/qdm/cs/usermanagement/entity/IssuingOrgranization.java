package com.qdm.cs.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_ISSUING_ORGANIZATION_LIST")
public class IssuingOrgranization {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Organization_ID")
	int organizationId;

	@Column(name = "Organization_Name")
	String organizationName;

	public IssuingOrgranization(String organizationName) {
		super();
		this.organizationName = organizationName;
	}

}
