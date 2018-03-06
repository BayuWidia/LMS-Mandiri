package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;


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
	@Column(name="customer_response_id")
	private String customerResponseId;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="actual_edm_id")
	private String actualEdmId;

	private Long amount;

	private String companyid;

	private Timestamp createdon;

	@Column(name="customer_comment")
	private String customerComment;

	@Column(name="cycle_next_id")
	private Integer cycleNextId;

	@Column(name="cycle_now_id")
	private Integer cycleNowId;

	@Column(name="data_type")
	private Integer dataType;

	private String dobisnis;

	private String durasi;

	private String email;

	@Column(name="follow_up")
	private String followUp;

	@Column(name="groupcr_id")
	private Long groupcrId;

	private Timestamp modifiedon;

	private String nik;

	private String npwp;

	@Column(name="offering_date")
	private Timestamp offeringDate;

	private String phone;

	private String polisnumber;

	@DateTimeFormat(pattern = "dd-MM-yy HH:mm")
	@Column(nullable = false, columnDefinition= "TIMESTAMP WITHOUT TIME ZONE")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date reminder;

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

	//bi-directional many-to-one association to Reason
	@ManyToOne
	@JoinColumn(name="reasonid")
	private Reason reason;

	//bi-directional many-to-one association to TCpi
	@ManyToOne
	@JoinColumn(name="cif")
	private TCpi TCpi;

	//bi-directional many-to-one association to TProduct
	@ManyToOne
	@JoinColumn(name="product_id")
	private TProduct TProduct1;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="createdby")
	private Userprofile userprofile1;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private Userprofile userprofile2;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userprofile userprofile3;

	//bi-directional many-to-one association to TProduct
	@ManyToOne
	@JoinColumn(name="subproduct_id")
	private TProduct TProduct2;

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

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
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

	public String getDobisnis() {
		return this.dobisnis;
	}

	public void setDobisnis(String dobisnis) {
		this.dobisnis = dobisnis;
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

	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNpwp() {
		return this.npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
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

	public String getPolisnumber() {
		return this.polisnumber;
	}

	public void setPolisnumber(String polisnumber) {
		this.polisnumber = polisnumber;
	}

	public Date getReminder() {
		return this.reminder;
	}

	public void setReminder(Date reminder) {
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

	public Reason getReason() {
		return this.reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public TCpi getTCpi() {
		return this.TCpi;
	}

	public void setTCpi(TCpi TCpi) {
		this.TCpi = TCpi;
	}

	public TProduct getTProduct1() {
		return this.TProduct1;
	}

	public void setTProduct1(TProduct TProduct1) {
		this.TProduct1 = TProduct1;
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

	public TProduct getTProduct2() {
		return this.TProduct2;
	}

	public void setTProduct2(TProduct TProduct2) {
		this.TProduct2 = TProduct2;
	}

}