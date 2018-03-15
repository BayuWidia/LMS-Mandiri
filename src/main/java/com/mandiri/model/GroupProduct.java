package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the group_product database table.
 * 
 */
@Entity
@Table(name="group_product")
@NamedQuery(name="GroupProduct.findAll", query="SELECT g FROM GroupProduct g")
public class GroupProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	//bi-directional many-to-one association to TProduct
	@OneToMany(mappedBy="groupProduct")
	private List<TProduct> TProducts;

	public GroupProduct() {
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

	public List<TProduct> getTProducts() {
		return this.TProducts;
	}

	public void setTProducts(List<TProduct> TProducts) {
		this.TProducts = TProducts;
	}

	public TProduct addTProduct(TProduct TProduct) {
		getTProducts().add(TProduct);
		TProduct.setGroupProduct(this);

		return TProduct;
	}

	public TProduct removeTProduct(TProduct TProduct) {
		getTProducts().remove(TProduct);
		TProduct.setGroupProduct(null);

		return TProduct;
	}

}