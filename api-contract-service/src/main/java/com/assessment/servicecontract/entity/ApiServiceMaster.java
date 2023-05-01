package com.assessment.servicecontract.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
public class ApiServiceMaster {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID apiId;
	
	private String theatreId;
	
	
	private String apiName;
	
	
	private String apiUrl;
	
	private String apiProtocol;
	
	private String apiPort;
	
	private String apiBodyTemplate;

	private String paramName_1;
	private String paramName_2;
	private String paramName_3;
	private String paramName_4;
	private String paramName_5;

	
}
