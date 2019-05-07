package com.jca.search.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.bridge.builtin.IntegerBridge;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Indexed
@Table(name = "product")
public class ProductEntity {
	
	@Id
	private String id;
	
	@Field
	private String name;
	
	@Field
	private BigDecimal pricePerUom;
	
	private Integer quantity;
	
	@Field
	private String uom;
	
	@Field
	@FieldBridge(impl = IntegerBridge.class)
	private int manufacturedYear;
	
	private Instant createdOn;
	
	public ProductEntity() {
		this.id = UUID.randomUUID().toString();
	}

}
