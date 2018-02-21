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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Integer status;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="reason")
	private List<CustomerCampaign> customerCampaigns;

	//bi-directional many-to-one association to CustomerResponse
	@OneToMany(mappedBy="reason")
	private List<CustomerResponse> customerResponses;

	public Reason() {
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<CustomerCampaign> getCustomerCampaigns() {
		return this.customerCampaigns;
	}

	public void setCustomerCampaigns(List<CustomerCampaign> customerCampaigns) {
		this.customerCampaigns = customerCampaigns;
	}

	public CustomerCampaign addCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().add(customerCampaign);
		customerCampaign.setReason(this);

		return customerCampaign;
	}

	public CustomerCampaign removeCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().remove(customerCampaign);
		customerCampaign.setReason(null);

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
		customerRespons.setReason(this);

		return customerRespons;
	}

	public CustomerResponse removeCustomerRespons(CustomerResponse customerRespons) {
		getCustomerResponses().remove(customerRespons);
		customerRespons.setReason(null);

		return customerRespons;
	}

}