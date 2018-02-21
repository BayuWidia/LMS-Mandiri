package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Timestamp createdon;

	private String detail;

	private String group;

	private Timestamp modifiedon;

	private String name;

	private Long producttypeid;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="product1")
	private List<CustomerCampaign> customerCampaigns1;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="product2")
	private List<CustomerCampaign> customerCampaigns2;

	//bi-directional many-to-one association to CustomerProduct
	@OneToMany(mappedBy="product")
	private List<CustomerProduct> customerProducts;

	//bi-directional many-to-one association to CustomerResponse
	@OneToMany(mappedBy="product")
	private List<CustomerResponse> customerResponses;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="parentproductid")
	private Product product;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="product")
	private List<Product> products;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdby")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
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

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProducttypeid() {
		return this.producttypeid;
	}

	public void setProducttypeid(Long producttypeid) {
		this.producttypeid = producttypeid;
	}

	public List<CustomerCampaign> getCustomerCampaigns1() {
		return this.customerCampaigns1;
	}

	public void setCustomerCampaigns1(List<CustomerCampaign> customerCampaigns1) {
		this.customerCampaigns1 = customerCampaigns1;
	}

	public CustomerCampaign addCustomerCampaigns1(CustomerCampaign customerCampaigns1) {
		getCustomerCampaigns1().add(customerCampaigns1);
		customerCampaigns1.setProduct1(this);

		return customerCampaigns1;
	}

	public CustomerCampaign removeCustomerCampaigns1(CustomerCampaign customerCampaigns1) {
		getCustomerCampaigns1().remove(customerCampaigns1);
		customerCampaigns1.setProduct1(null);

		return customerCampaigns1;
	}

	public List<CustomerCampaign> getCustomerCampaigns2() {
		return this.customerCampaigns2;
	}

	public void setCustomerCampaigns2(List<CustomerCampaign> customerCampaigns2) {
		this.customerCampaigns2 = customerCampaigns2;
	}

	public CustomerCampaign addCustomerCampaigns2(CustomerCampaign customerCampaigns2) {
		getCustomerCampaigns2().add(customerCampaigns2);
		customerCampaigns2.setProduct2(this);

		return customerCampaigns2;
	}

	public CustomerCampaign removeCustomerCampaigns2(CustomerCampaign customerCampaigns2) {
		getCustomerCampaigns2().remove(customerCampaigns2);
		customerCampaigns2.setProduct2(null);

		return customerCampaigns2;
	}

	public List<CustomerProduct> getCustomerProducts() {
		return this.customerProducts;
	}

	public void setCustomerProducts(List<CustomerProduct> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public CustomerProduct addCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().add(customerProduct);
		customerProduct.setProduct(this);

		return customerProduct;
	}

	public CustomerProduct removeCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().remove(customerProduct);
		customerProduct.setProduct(null);

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
		customerRespons.setProduct(this);

		return customerRespons;
	}

	public CustomerResponse removeCustomerRespons(CustomerResponse customerRespons) {
		getCustomerResponses().remove(customerRespons);
		customerRespons.setProduct(null);

		return customerRespons;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProduct(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProduct(null);

		return product;
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

}