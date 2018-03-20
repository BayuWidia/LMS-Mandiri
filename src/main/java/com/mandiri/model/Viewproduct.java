package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viewproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Viewproduct.findAll", query="SELECT v FROM Viewproduct v")
public class Viewproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private String productId;
	
	@Column(name="group_product_id")
	private Long groupProductId;

	@Column(name="product_name")
	private String productName;

	public Viewproduct() {
	}

	public Long getGroupProductId() {
		return this.groupProductId;
	}

	public void setGroupProductId(Long groupProductId) {
		this.groupProductId = groupProductId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}