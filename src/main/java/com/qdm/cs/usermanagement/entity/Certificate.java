package com.qdm.cs.usermanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_CERTIFICATE_LIST")
public class Certificate implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@Column(name = "Category_ID")
	int certificateId;

	@Column(name = "Category_Name")
	String certificateName;

	@Column(name = "Organization_ID")
	int organizationId;

	@Column(name = "Organization_Name")
	String organizationName;
	
	@Column(name = "Starting_From")
	String startingFrom;
	
	@Column(name = "Ending_From")
	String endingIn;
	
	@Column(name = "Order_No")
	int orderNo;

	@ManyToOne(optional = true)
	@Transient
	CareGiver caregiver;
}
