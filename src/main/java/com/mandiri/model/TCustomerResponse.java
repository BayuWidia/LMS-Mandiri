package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_customer_response database table.
 * 
 */
@Entity
@Table(name="t_customer_response")
@NamedQuery(name="TCustomerResponse.findAll", query="SELECT t FROM TCustomerResponse t")
public class TCustomerResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_response_id")
	private String customerResponseId;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="actual_edm_id")
	private String actualEdmId;

	private Timestamp createdon;

	@Column(name="customer_comment")
	private String customerComment;

	@Column(name="cycle_next_id")
	private Integer cycleNextId;

	@Column(name="cycle_now_id")
	private Integer cycleNowId;

	@Column(name="data_type")
	private Integer dataType;

	private String durasi;

	private String email;

	@Column(name="follow_up")
	private String followUp;

	@Column(name="groupcr_id")
	private Long groupcrId;

	private Timestamp modifiedon;

	@Column(name="offering_date")
	private Timestamp offeringDate;

	private String phone;

	private Timestamp reminder;

	@Column(name="response_code")
	private String responseCode;

	@Column(name="response_result")
	private Integer responseResult;

	@Column(name="response_result_desc")
	private String responseResultDesc;

	private String sequence;

	@Column(name="source_type")
	private Integer sourceType;

	private Boolean status;

	@Column(name="sub_response_code")
	private String subResponseCode;

	@Column(name="tanggal_sales")
	private Timestamp tanggalSales;

	//bi-directional many-to-one association to TCpi
	@ManyToOne
	@JoinColumn(name="cif")
	private TCpi TCpi;

	//bi-directional many-to-one association to TProduct
	@ManyToOne
	@JoinColumn(name="product_id")
	private TProduct TProduct;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userprofile userprofile1;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="createdby")
	private Userprofile userprofile2;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private Userprofile userprofile3;

	public TCustomerResponse() {
	}

	public String getCustomerResponseId() {
		return this.customerResponseId;
	}

	public void setCustomerResponseId(String customerResponseId) {
		this.customerResponseId = customerResponseId;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getActualEdmId() {
		return this.actualEdmId;
	}

	public void setActualEdmId(String actualEdmId) {
		this.actualEdmId = actualEdmId;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public String getCustomerComment() {
		return this.customerComment;
	}

	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}

	public Integer getCycleNextId() {
		return this.cycleNextId;
	}

	public void setCycleNextId(Integer cycleNextId) {
		this.cycleNextId = cycleNextId;
	}

	public Integer getCycleNowId() {
		return this.cycleNowId;
	}

	public void setCycleNowId(Integer cycleNowId) {
		this.cycleNowId = cycleNowId;
	}

	public Integer getDataType() {
		return this.dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getDurasi() {
		return this.durasi;
	}

	public void setDurasi(String durasi) {
		this.durasi = durasi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFollowUp() {
		return this.followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	public Long getGroupcrId() {
		return this.groupcrId;
	}

	public void setGroupcrId(Long groupcrId) {
		this.groupcrId = groupcrId;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public Timestamp getOfferingDate() {
		return this.offeringDate;
	}

	public void setOfferingDate(Timestamp offeringDate) {
		this.offeringDate = offeringDate;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getReminder() {
		return this.reminder;
	}

	public void setReminder(Timestamp reminder) {
		this.reminder = reminder;
	}

	public String getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public Integer getResponseResult() {
		return this.responseResult;
	}

	public void setResponseResult(Integer responseResult) {
		this.responseResult = responseResult;
	}

	public String getResponseResultDesc() {
		return this.responseResultDesc;
	}

	public void setResponseResultDesc(String responseResultDesc) {
		this.responseResultDesc = responseResultDesc;
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

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getSubResponseCode() {
		return this.subResponseCode;
	}

	public void setSubResponseCode(String subResponseCode) {
		this.subResponseCode = subResponseCode;
	}

	public Timestamp getTanggalSales() {
		return this.tanggalSales;
	}

	public void setTanggalSales(Timestamp tanggalSales) {
		this.tanggalSales = tanggalSales;
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

	public Userprofile getUserprofile3() {
		return this.userprofile3;
	}

	public void setUserprofile3(Userprofile userprofile3) {
		this.userprofile3 = userprofile3;
	}

}