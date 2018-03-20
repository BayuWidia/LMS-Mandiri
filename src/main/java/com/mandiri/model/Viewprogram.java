package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viewprogram database table.
 * 
 */
@Entity
@NamedQuery(name="Viewprogram.findAll", query="SELECT v FROM Viewprogram v")
public class Viewprogram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	@Column(name="product_id")
	private String productId;

	public Viewprogram() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}