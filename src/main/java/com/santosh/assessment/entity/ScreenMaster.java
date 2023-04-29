package com.santosh.assessment.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class ScreenMaster {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID screenId;
	
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	@JsonManagedReference
	private TheatreMaster theatre;
	
	private Integer screenNo;
	
	private Integer totalStrength;
	
	private String screenType;
}
