package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reason database table.
 * 
 */
@Entity
@NamedQuery(name="Reason.findAll", query="SELECT r FROM Reason r")
public class Reason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	@Column(name="product_group")
	private String productGroup;

	@Column(name="response_type")
	private String responseType;

	//bi-directional many-to-one association to TCustomerResponse
	@OneToMany(mappedBy="reason")
	private List<TCustomerResponse> TCustomerResponses;

	public Reason() {
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

	public List<TCustomerResponse> getTCustomerResponses() {
		return this.TCustomerResponses;
	}

	public void setTCustomerResponses(List<TCustomerResponse> TCustomerResponses) {
		this.TCustomerResponses = TCustomerResponses;
	}

	public TCustomerResponse addTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().add(TCustomerRespons);
		TCustomerRespons.setReason(this);

		return TCustomerRespons;
	}

	public TCustomerResponse removeTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().remove(TCustomerRespons);
		TCustomerRespons.setReason(null);

		return TCustomerRespons;
	}

}