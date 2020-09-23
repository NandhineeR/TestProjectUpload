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
@Table(name = "TB_CERTIFICATION_CAREGIVER")
public class Certification {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Category_ID")
	int certificateId;

	@Column(name = "Category_Name")
	String certificateName;

	public Certification(String certificateName) {
		super();
		this.certificateName = certificateName;
	}

}
