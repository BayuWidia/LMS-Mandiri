package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viewreason database table.
 * 
 */
@Entity
@NamedQuery(name="Viewreason.findAll", query="SELECT v FROM Viewreason v")
public class Viewreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	@Column(name="product_group")
	private String productGroup;

	@Column(name="response_type")
	private String responseType;

	public Viewreason() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductGroup() {
		return this.productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getResponseType() {
		return this.responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

}