package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="status")
	private List<CustomerCampaign> customerCampaigns;

	//bi-directional many-to-one association to CustomerResponse
	@OneToMany(mappedBy="status")
	private List<CustomerResponse> customerResponses;

	public Status() {
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

	public List<CustomerCampaign> getCustomerCampaigns() {
		return this.customerCampaigns;
	}

	public void setCustomerCampaigns(List<CustomerCampaign> customerCampaigns) {
		this.customerCampaigns = customerCampaigns;
	}

	public CustomerCampaign addCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().add(customerCampaign);
		customerCampaign.setStatus(this);

		return customerCampaign;
	}

	public CustomerCampaign removeCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().remove(customerCampaign);
		customerCampaign.setStatus(null);

		return customerCampaign;
	}

	public List<CustomerResponse> getCustomerResponses() {
		return this.customerResponses;
	}

	public void setCustomerResponses(List<CustomerResponse> customerResponses) {
		this.customerResponses = customerResponses;
	}

	public CustomerResponse addCustomerRespons(CustomerResponse customerRespons) {
		getCustomerResponses().add(customerRespons);
		customerRespons.setStatus(this);

		return customerRespons;
	}

	public CustomerResponse removeCustomerRespons(CustomerResponse customerRespons) {
		getCustomerResponses().remove(customerRespons);
		customerRespons.setStatus(null);

		return customerRespons;
	}

}