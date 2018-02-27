package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_product database table.
 * 
 */
@Entity
@Table(name="t_product")
@NamedQuery(name="TProduct.findAll", query="SELECT t FROM TProduct t")
public class TProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private String productId;

	private String detail;

	private String group;

	@Column(name="product_name")
	private String productName;

	@Column(name="sub_product_name")
	private String subProductName;

	//bi-directional many-to-one association to TProduct
	@ManyToOne
	@JoinColumn(name="sub_product_id")
	private TProduct TProduct;

	//bi-directional many-to-one association to TProduct
	@OneToMany(mappedBy="TProduct")
	private List<TProduct> TProducts;

	public TProduct() {
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSubProductName() {
		return this.subProductName;
	}

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	public TProduct getTProduct() {
		return this.TProduct;
	}

	public void setTProduct(TProduct TProduct) {
		this.TProduct = TProduct;
	}

	public List<TProduct> getTProducts() {
		return this.TProducts;
	}

	public void setTProducts(List<TProduct> TProducts) {
		this.TProducts = TProducts;
	}

	public TProduct addTProduct(TProduct TProduct) {
		getTProducts().add(TProduct);
		TProduct.setTProduct(this);

		return TProduct;
	}

	public TProduct removeTProduct(TProduct TProduct) {
		getTProducts().remove(TProduct);
		TProduct.setTProduct(null);

		return TProduct;
	}

}