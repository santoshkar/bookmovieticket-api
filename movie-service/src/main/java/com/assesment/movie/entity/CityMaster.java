package com.assesment.movie.entity;

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
public class CityMaster  {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "VARCHAR(255)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID cityId;
	
    public CityMaster(String cityId) {
		this(UUID.fromString(cityId));
	}
    
    public CityMaster(UUID cityId) {
		this.cityId = cityId;
	}

    public CityMaster(){
    	
    }

    private String country;

    private String name;
}
