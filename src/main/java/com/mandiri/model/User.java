package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;

	private Timestamp createdon;

	private String fullname;

	private Timestamp lastlogin;

	private Timestamp modifiedon;

	private String password;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user1")
	private List<Customer> customers1;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user2")
	private List<Customer> customers2;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="user1")
	private List<CustomerCampaign> customerCampaigns1;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="user2")
	private List<CustomerCampaign> customerCampaigns2;

	//bi-directional many-to-one association to CustomerProduct
	@OneToMany(mappedBy="user1")
	private List<CustomerProduct> customerProducts1;

	//bi-directional many-to-one association to CustomerProduct
	@OneToMany(mappedBy="user2")
	private List<CustomerProduct> customerProducts2;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="user1")
	private List<Product> products1;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="user2")
	private List<Product> products2;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="user1")
	private List<Role> roles1;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="user2")
	private List<Role> roles2;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleid")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdby")
	private User user1;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user1")
	private List<User> users1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user2")
	private List<User> users2;

	//bi-directional many-to-one association to UserActivity
	@OneToMany(mappedBy="user")
	private List<UserActivity> userActivities;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Timestamp getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customer> getCustomers1() {
		return this.customers1;
	}

	public void setCustomers1(List<Customer> customers1) {
		this.customers1 = customers1;
	}

	public Customer addCustomers1(Customer customers1) {
		getCustomers1().add(customers1);
		customers1.setUser1(this);

		return customers1;
	}

	public Customer removeCustomers1(Customer customers1) {
		getCustomers1().remove(customers1);
		customers1.setUser1(null);

		return customers1;
	}

	public List<Customer> getCustomers2() {
		return this.customers2;
	}

	public void setCustomers2(List<Customer> customers2) {
		this.customers2 = customers2;
	}

	public Customer addCustomers2(Customer customers2) {
		getCustomers2().add(customers2);
		customers2.setUser2(this);

		return customers2;
	}

	public Customer removeCustomers2(Customer customers2) {
		getCustomers2().remove(customers2);
		customers2.setUser2(null);

		return customers2;
	}

	public List<CustomerCampaign> getCustomerCampaigns1() {
		return this.customerCampaigns1;
	}

	public void setCustomerCampaigns1(List<CustomerCampaign> customerCampaigns1) {
		this.customerCampaigns1 = customerCampaigns1;
	}

	public CustomerCampaign addCustomerCampaigns1(CustomerCampaign customerCampaigns1) {
		getCustomerCampaigns1().add(customerCampaigns1);
		customerCampaigns1.setUser1(this);

		return customerCampaigns1;
	}

	public CustomerCampaign removeCustomerCampaigns1(CustomerCampaign customerCampaigns1) {
		getCustomerCampaigns1().remove(customerCampaigns1);
		customerCampaigns1.setUser1(null);

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
		customerCampaigns2.setUser2(this);

		return customerCampaigns2;
	}

	public CustomerCampaign removeCustomerCampaigns2(CustomerCampaign customerCampaigns2) {
		getCustomerCampaigns2().remove(customerCampaigns2);
		customerCampaigns2.setUser2(null);

		return customerCampaigns2;
	}

	public List<CustomerProduct> getCustomerProducts1() {
		return this.customerProducts1;
	}

	public void setCustomerProducts1(List<CustomerProduct> customerProducts1) {
		this.customerProducts1 = customerProducts1;
	}

	public CustomerProduct addCustomerProducts1(CustomerProduct customerProducts1) {
		getCustomerProducts1().add(customerProducts1);
		customerProducts1.setUser1(this);

		return customerProducts1;
	}

	public CustomerProduct removeCustomerProducts1(CustomerProduct customerProducts1) {
		getCustomerProducts1().remove(customerProducts1);
		customerProducts1.setUser1(null);

		return customerProducts1;
	}

	public List<CustomerProduct> getCustomerProducts2() {
		return this.customerProducts2;
	}

	public void setCustomerProducts2(List<CustomerProduct> customerProducts2) {
		this.customerProducts2 = customerProducts2;
	}

	public CustomerProduct addCustomerProducts2(CustomerProduct customerProducts2) {
		getCustomerProducts2().add(customerProducts2);
		customerProducts2.setUser2(this);

		return customerProducts2;
	}

	public CustomerProduct removeCustomerProducts2(CustomerProduct customerProducts2) {
		getCustomerProducts2().remove(customerProducts2);
		customerProducts2.setUser2(null);

		return customerProducts2;
	}

	public List<Product> getProducts1() {
		return this.products1;
	}

	public void setProducts1(List<Product> products1) {
		this.products1 = products1;
	}

	public Product addProducts1(Product products1) {
		getProducts1().add(products1);
		products1.setUser1(this);

		return products1;
	}

	public Product removeProducts1(Product products1) {
		getProducts1().remove(products1);
		products1.setUser1(null);

		return products1;
	}

	public List<Product> getProducts2() {
		return this.products2;
	}

	public void setProducts2(List<Product> products2) {
		this.products2 = products2;
	}

	public Product addProducts2(Product products2) {
		getProducts2().add(products2);
		products2.setUser2(this);

		return products2;
	}

	public Product removeProducts2(Product products2) {
		getProducts2().remove(products2);
		products2.setUser2(null);

		return products2;
	}

	public List<Role> getRoles1() {
		return this.roles1;
	}

	public void setRoles1(List<Role> roles1) {
		this.roles1 = roles1;
	}

	public Role addRoles1(Role roles1) {
		getRoles1().add(roles1);
		roles1.setUser1(this);

		return roles1;
	}

	public Role removeRoles1(Role roles1) {
		getRoles1().remove(roles1);
		roles1.setUser1(null);

		return roles1;
	}

	public List<Role> getRoles2() {
		return this.roles2;
	}

	public void setRoles2(List<Role> roles2) {
		this.roles2 = roles2;
	}

	public Role addRoles2(Role roles2) {
		getRoles2().add(roles2);
		roles2.setUser2(this);

		return roles2;
	}

	public Role removeRoles2(Role roles2) {
		getRoles2().remove(roles2);
		roles2.setUser2(null);

		return roles2;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public User addUsers1(User users1) {
		getUsers1().add(users1);
		users1.setUser1(this);

		return users1;
	}

	public User removeUsers1(User users1) {
		getUsers1().remove(users1);
		users1.setUser1(null);

		return users1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

	public User addUsers2(User users2) {
		getUsers2().add(users2);
		users2.setUser2(this);

		return users2;
	}

	public User removeUsers2(User users2) {
		getUsers2().remove(users2);
		users2.setUser2(null);

		return users2;
	}

	public List<UserActivity> getUserActivities() {
		return this.userActivities;
	}

	public void setUserActivities(List<UserActivity> userActivities) {
		this.userActivities = userActivities;
	}

	public UserActivity addUserActivity(UserActivity userActivity) {
		getUserActivities().add(userActivity);
		userActivity.setUser(this);

		return userActivity;
	}

	public UserActivity removeUserActivity(UserActivity userActivity) {
		getUserActivities().remove(userActivity);
		userActivity.setUser(null);

		return userActivity;
	}

}