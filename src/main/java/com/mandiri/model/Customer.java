package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	public Customer(Long cif) {
		super();
		this.cif = cif;
	}

	@Id
	private Long cif;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String birthplace;

	private Long branchid;

	private Timestamp createdon;

	private String email;

	private String gender;

	private String indentitytype;

	private String jobtype;

	private Timestamp modifiedon;

	private String mothername;

	private String name;

	private Integer nasabahpep;

	private String nik;

	private String phone;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdby")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="customer")
	private List<CustomerCampaign> customerCampaigns;

	//bi-directional many-to-one association to CustomerProduct
	@OneToMany(mappedBy="customer")
	private List<CustomerProduct> customerProducts;

	//bi-directional many-to-one association to CustomerResponse
	@OneToMany(mappedBy="customer")
	private List<CustomerResponse> customerResponses;

	//bi-directional many-to-one association to UserActivity
	@OneToMany(mappedBy="customer")
	private List<UserActivity> userActivities;

	public Customer() {
	}

	public Long getCif() {
		return this.cif;
	}

	public void setCif(Long cif) {
		this.cif = cif;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Long getBranchid() {
		return this.branchid;
	}

	public void setBranchid(Long branchid) {
		this.branchid = branchid;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIndentitytype() {
		return this.indentitytype;
	}

	public void setIndentitytype(String indentitytype) {
		this.indentitytype = indentitytype;
	}

	public String getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getMothername() {
		return this.mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNasabahpep() {
		return this.nasabahpep;
	}

	public void setNasabahpep(Integer nasabahpep) {
		this.nasabahpep = nasabahpep;
	}

	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public List<CustomerCampaign> getCustomerCampaigns() {
		return this.customerCampaigns;
	}

	public void setCustomerCampaigns(List<CustomerCampaign> customerCampaigns) {
		this.customerCampaigns = customerCampaigns;
	}

	public CustomerCampaign addCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().add(customerCampaign);
		customerCampaign.setCustomer(this);

		return customerCampaign;
	}

	public CustomerCampaign removeCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().remove(customerCampaign);
		customerCampaign.setCustomer(null);

		return customerCampaign;
	}

	public List<CustomerProduct> getCustomerProducts() {
		return this.customerProducts;
	}

	public void setCustomerProducts(List<CustomerProduct> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public CustomerProduct addCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().add(customerProduct);
		customerProduct.setCustomer(this);

		return customerProduct;
	}

	public CustomerProduct removeCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().remove(customerProduct);
		customerProduct.setCustomer(null);

		return customerProduct;
	}

	public List<CustomerResponse> getCustomerResponses() {
		return this.customerResponses;
	}

	public void setCustomerResponses(List<CustomerResponse> customerResponses) {
		this.customerResponses = customerResponses;
	}

	public CustomerResponse addCustomerRespons(CustomerResponse customerRespons) {
		getCustomerResponses().add(customerRespons);
		customerRespons.setCustomer(this);

		return customerRespons;
	}

	public CustomerResponse removeCustomerRespons(CustomerResponse customerRespons) {
		getCustomerResponses().remove(customerRespons);
		customerRespons.setCustomer(null);

		return customerRespons;
	}

	public List<UserActivity> getUserActivities() {
		return this.userActivities;
	}

	public void setUserActivities(List<UserActivity> userActivities) {
		this.userActivities = userActivities;
	}

	public UserActivity addUserActivity(UserActivity userActivity) {
		getUserActivities().add(userActivity);
		userActivity.setCustomer(this);

		return userActivity;
	}

	public UserActivity removeUserActivity(UserActivity userActivity) {
		getUserActivities().remove(userActivity);
		userActivity.setCustomer(null);

		return userActivity;
	}

}