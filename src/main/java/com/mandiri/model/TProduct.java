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

	//bi-directional many-to-one association to Campaign
	@OneToMany(mappedBy="TProduct")
	private List<Campaign> campaigns;

	//bi-directional many-to-one association to TCph
	@OneToMany(mappedBy="TProduct")
	private List<TCph> TCphs;

	//bi-directional many-to-one association to TCpo
	@OneToMany(mappedBy="TProduct")
	private List<TCpo> TCpos;

	//bi-directional many-to-one association to TCustomerResponse
	@OneToMany(mappedBy="TProduct")
	private List<TCustomerResponse> TCustomerResponses;

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

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public Campaign addCampaign(Campaign campaign) {
		getCampaigns().add(campaign);
		campaign.setTProduct(this);

		return campaign;
	}

	public Campaign removeCampaign(Campaign campaign) {
		getCampaigns().remove(campaign);
		campaign.setTProduct(null);

		return campaign;
	}

	public List<TCph> getTCphs() {
		return this.TCphs;
	}

	public void setTCphs(List<TCph> TCphs) {
		this.TCphs = TCphs;
	}

	public TCph addTCph(TCph TCph) {
		getTCphs().add(TCph);
		TCph.setTProduct(this);

		return TCph;
	}

	public TCph removeTCph(TCph TCph) {
		getTCphs().remove(TCph);
		TCph.setTProduct(null);

		return TCph;
	}

	public List<TCpo> getTCpos() {
		return this.TCpos;
	}

	public void setTCpos(List<TCpo> TCpos) {
		this.TCpos = TCpos;
	}

	public TCpo addTCpo(TCpo TCpo) {
		getTCpos().add(TCpo);
		TCpo.setTProduct(this);

		return TCpo;
	}

	public TCpo removeTCpo(TCpo TCpo) {
		getTCpos().remove(TCpo);
		TCpo.setTProduct(null);

		return TCpo;
	}

	public List<TCustomerResponse> getTCustomerResponses() {
		return this.TCustomerResponses;
	}

	public void setTCustomerResponses(List<TCustomerResponse> TCustomerResponses) {
		this.TCustomerResponses = TCustomerResponses;
	}

	public TCustomerResponse addTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().add(TCustomerRespons);
		TCustomerRespons.setTProduct(this);

		return TCustomerRespons;
	}

	public TCustomerResponse removeTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().remove(TCustomerRespons);
		TCustomerRespons.setTProduct(null);

		return TCustomerRespons;
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