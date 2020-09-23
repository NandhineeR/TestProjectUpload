package com.qdm.cs.usermanagement.dto;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.qdm.cs.usermanagement.entity.Certificate;
import com.qdm.cs.usermanagement.entity.Experience;
import com.qdm.cs.usermanagement.entity.Specialization;
import com.qdm.cs.usermanagement.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FormDataDTO {

	long careGiverId;
	long careCoordinatorId;
	long careProviderId;
	MultipartFile uploadPhoto;
	String careGiverName;
	String careCoordinatorName;
	String careProviderName;
	List<Integer> category;
	List<Long> careprovider;
	int MobileNoISDCode;
	long mobileNo;
	String emailId;
	String address;
	List<Integer> skills;
	List<String> offerings;
	Status activeStatus;
	int clientsCount;
	int careGiversCount;
	String inChargesName;
	String bussinessRegNo;
	int officeNoISDCode;
	long officeNo;
	String licenseNo;
	List<Specialization> specialization;
	List<Certificate> certificate;
	List<Experience> experience;

}
