package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_cph database table.
 * 
 */
@Entity
@Table(name="t_cph")
@NamedQuery(name="TCph.findAll", query="SELECT t FROM TCph t")
public class TCph implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cph_id")
	private String cphId;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="card_number")
	private String cardNumber;

	private String createdby;

	private Timestamp createdon;

	@Column(name="date_open_account")
	private Timestamp dateOpenAccount;

	private String modifiedby;

	private Timestamp modifiedon;

	@Column(name="product_description")
	private String productDescription;

	private Integer status;

	@Column(name="sub_product_id")
	private String subProductId;

	//bi-directional many-to-one association to TCpi
	@ManyToOne
	@JoinColumn(name="cif")
	private TCpi TCpi;

	//bi-directional many-to-one association to TProduct
	@ManyToOne
	@JoinColumn(name="product_id")
	private TProduct TProduct;

	public TCph() {
	}

	public String getCphId() {
		return this.cphId;
	}

	public void setCphId(String cphId) {
		this.cphId = cphId;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public Timestamp getDateOpenAccount() {
		return this.dateOpenAccount;
	}

	public void setDateOpenAccount(Timestamp dateOpenAccount) {
		this.dateOpenAccount = dateOpenAccount;
	}

	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSubProductId() {
		return this.subProductId;
	}

	public void setSubProductId(String subProductId) {
		this.subProductId = subProductId;
	}

	public TCpi getTCpi() {
		return this.TCpi;
	}

	public void setTCpi(TCpi TCpi) {
		this.TCpi = TCpi;
	}

	public TProduct getTProduct() {
		return this.TProduct;
	}

	public void setTProduct(TProduct TProduct) {
		this.TProduct = TProduct;
	}

}