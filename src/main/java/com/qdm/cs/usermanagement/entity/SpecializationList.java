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
@Table(name = "TB_SPECIALIZATION_LIST")
public class SpecializationList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Specialization_Id")
	int value;
	
	@Column(name="Specialization_name")
	String label;
}
