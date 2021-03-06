package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_offer database table.
 * 
 */
@Entity
@Table(name="t_offer")
@NamedQuery(name="TOffer.findAll", query="SELECT t FROM TOffer t")
public class TOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String area;

	@Column(name="branch_category")
	private String branchCategory;

	@Column(name="branch_product")
	private String branchProduct;

	private String channel;

	private Timestamp createdon;

	private Timestamp expirydate;

	private BigDecimal income;

	@Column(name="indicative_limit")
	private BigDecimal indicativeLimit;

	private Boolean ishunter;

	@Column(name="model_id")
	private String modelId;

	private Timestamp modifiedon;

	private BigDecimal nominal;

	private Timestamp offerdate;

	@Column(name="product_id")
	private String productId;

	private Integer rac;

	private String region;

	private String script;

	private String sequence;

	@Column(name="source_type")
	private Integer sourceType;

	private Integer status;

	//bi-directional many-to-one association to TCustomerResponse
	@OneToMany(mappedBy="TOffer", cascade = CascadeType.ALL)
	private List<TCustomerResponse> TCustomerResponses;

	//bi-directional many-to-one association to Program
	@ManyToOne
	private Program program;

	//bi-directional many-to-one association to TCpi
	@ManyToOne
	@JoinColumn(name="cif")
	private TCpi TCpi;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="createdby")
	private Userprofile userprofile1;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private Userprofile userprofile2;

	public TOffer() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBranchCategory() {
		return this.branchCategory;
	}

	public void setBranchCategory(String branchCategory) {
		this.branchCategory = branchCategory;
	}

	public String getBranchProduct() {
		return this.branchProduct;
	}

	public void setBranchProduct(String branchProduct) {
		this.branchProduct = branchProduct;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public Timestamp getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Timestamp expirydate) {
		this.expirydate = expirydate;
	}

	public BigDecimal getIncome() {
		return this.income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getIndicativeLimit() {
		return this.indicativeLimit;
	}

	public void setIndicativeLimit(BigDecimal indicativeLimit) {
		this.indicativeLimit = indicativeLimit;
	}

	public Boolean getIshunter() {
		return this.ishunter;
	}

	public void setIshunter(Boolean ishunter) {
		this.ishunter = ishunter;
	}

	public String getModelId() {
		return this.modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public BigDecimal getNominal() {
		return this.nominal;
	}

	public void setNominal(BigDecimal nominal) {
		this.nominal = nominal;
	}

	public Timestamp getOfferdate() {
		return this.offerdate;
	}

	public void setOfferdate(Timestamp offerdate) {
		this.offerdate = offerdate;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getRac() {
		return this.rac;
	}

	public void setRac(Integer rac) {
		this.rac = rac;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getSequence() {
		return this.sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<TCustomerResponse> getTCustomerResponses() {
		return this.TCustomerResponses;
	}

	public void setTCustomerResponses(List<TCustomerResponse> TCustomerResponses) {
		this.TCustomerResponses = TCustomerResponses;
	}

	public TCustomerResponse addTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().add(TCustomerRespons);
		TCustomerRespons.setTOffer(this);

		return TCustomerRespons;
	}

	public TCustomerResponse removeTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().remove(TCustomerRespons);
		TCustomerRespons.setTOffer(null);

		return TCustomerRespons;
	}

	public Program getProgram() {
		return this.program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public TCpi getTCpi() {
		return this.TCpi;
	}

	public void setTCpi(TCpi TCpi) {
		this.TCpi = TCpi;
	}

	public Userprofile getUserprofile1() {
		return this.userprofile1;
	}

	public void setUserprofile1(Userprofile userprofile1) {
		this.userprofile1 = userprofile1;
	}

	public Userprofile getUserprofile2() {
		return this.userprofile2;
	}

	public void setUserprofile2(Userprofile userprofile2) {
		this.userprofile2 = userprofile2;
	}

}