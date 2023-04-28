package com.santosh.assessment.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.santosh.assessment.jsonseralizer.CurrencySerializer;

import lombok.Data;

@Data
@Entity
public class TicketPrice  {
    @Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", columnDefinition = "VARCHAR(255)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @JsonProperty("ticketPriceId")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_screening_id", referencedColumnName = "id")
    private MovieScreening movieScreening;

//    @JsonSerialize(using = CurrencySerializer.class)
    private BigDecimal gold;
    
//    @JsonSerialize(using = CurrencySerializer.class)
    private BigDecimal silver;
    
//    @JsonSerialize(using = CurrencySerializer.class)
    private BigDecimal bronze;
    
}
