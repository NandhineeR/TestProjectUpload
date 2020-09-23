package com.qdm.cs.usermanagement.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExperienceDTO {

	int id;
	int roleId;
	String roleName;
	int organizationId;
	String organizationName;
	String startingFrom;
	String endingIn;
	int orderNo;

}