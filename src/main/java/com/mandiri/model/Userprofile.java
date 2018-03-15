package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the userprofile database table.
 * 
 */
@Entity
@NamedQuery(name="Userprofile.findAll", query="SELECT u FROM Userprofile u")
public class Userprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nip;

	@Column(name="approve_date")
	private Timestamp approveDate;

	private String approveby;

	private String area;

	private String branchcode;

	@Column(name="branchcode_alt2")
	private String branchcodeAlt2;

	@Column(name="branchcode_alt3")
	private String branchcodeAlt3;

	@Column(name="branchcode_alt4")
	private String branchcodeAlt4;

	private Timestamp dob;

	private String groupsales;

	private String groupuser;

	private String isallowedholidayaccess;

	private String isnewpassword;

	private Timestamp joindate;

	@Column(name="login_status")
	private String loginStatus;

	private String mobilephone1;

	private String mobilephone2;

	private String name;

	private String password;

	@Column(name="password_expired_date")
	private Timestamp passwordExpiredDate;

	private String region;

	private String remarks;

	@Column(name="sales_subtype")
	private String salesSubtype;

	private String salescodeccg;

	private String salescodeclg;

	private String salesgroup;

	private String saleslevel;

	private String salestype;

	private String status;

	@Column(name="upload_date")
	private Timestamp uploadDate;

	private String uploadby;

	private String userrole;

	//bi-directional many-to-one association to TAuditTrail
	@OneToMany(mappedBy="userprofile1")
	private List<TAuditTrail> TAuditTrails1;

	//bi-directional many-to-one association to TAuditTrail
	@OneToMany(mappedBy="userprofile2")
	private List<TAuditTrail> TAuditTrails2;

	//bi-directional many-to-one association to TAuditTrail
	@OneToMany(mappedBy="userprofile3")
	private List<TAuditTrail> TAuditTrails3;

	//bi-directional many-to-one association to TCpi
	@OneToMany(mappedBy="userprofile1")
	private List<TCpi> TCpis1;

	//bi-directional many-to-one association to TCpi
	@OneToMany(mappedBy="userprofile2")
	private List<TCpi> TCpis2;

	//bi-directional many-to-one association to TCpo
	@OneToMany(mappedBy="userprofile1")
	private List<TCpo> TCpos1;

	//bi-directional many-to-one association to TCpo
	@OneToMany(mappedBy="userprofile2")
	private List<TCpo> TCpos2;

	//bi-directional many-to-one association to TCustomerResponse
	@OneToMany(mappedBy="userprofile1")
	private List<TCustomerResponse> TCustomerResponses1;

	//bi-directional many-to-one association to TCustomerResponse
	@OneToMany(mappedBy="userprofile2")
	private List<TCustomerResponse> TCustomerResponses2;

	//bi-directional many-to-one association to TCustomerResponse
	@OneToMany(mappedBy="userprofile3")
	private List<TCustomerResponse> TCustomerResponses3;

	//bi-directional many-to-one association to TLoginHistory
	@OneToMany(mappedBy="userprofile")
	private List<TLoginHistory> TLoginHistories;

	//bi-directional many-to-one association to TOffer
	@OneToMany(mappedBy="userprofile1")
	private List<TOffer> TOffers1;

	//bi-directional many-to-one association to TOffer
	@OneToMany(mappedBy="userprofile2")
	private List<TOffer> TOffers2;

	public Userprofile() {
	}

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public Timestamp getApproveDate() {
		return this.approveDate;
	}

	public void setApproveDate(Timestamp approveDate) {
		this.approveDate = approveDate;
	}

	public String getApproveby() {
		return this.approveby;
	}

	public void setApproveby(String approveby) {
		this.approveby = approveby;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBranchcode() {
		return this.branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getBranchcodeAlt2() {
		return this.branchcodeAlt2;
	}

	public void setBranchcodeAlt2(String branchcodeAlt2) {
		this.branchcodeAlt2 = branchcodeAlt2;
	}

	public String getBranchcodeAlt3() {
		return this.branchcodeAlt3;
	}

	public void setBranchcodeAlt3(String branchcodeAlt3) {
		this.branchcodeAlt3 = branchcodeAlt3;
	}

	public String getBranchcodeAlt4() {
		return this.branchcodeAlt4;
	}

	public void setBranchcodeAlt4(String branchcodeAlt4) {
		this.branchcodeAlt4 = branchcodeAlt4;
	}

	public Timestamp getDob() {
		return this.dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public String getGroupsales() {
		return this.groupsales;
	}

	public void setGroupsales(String groupsales) {
		this.groupsales = groupsales;
	}

	public String getGroupuser() {
		return this.groupuser;
	}

	public void setGroupuser(String groupuser) {
		this.groupuser = groupuser;
	}

	public String getIsallowedholidayaccess() {
		return this.isallowedholidayaccess;
	}

	public void setIsallowedholidayaccess(String isallowedholidayaccess) {
		this.isallowedholidayaccess = isallowedholidayaccess;
	}

	public String getIsnewpassword() {
		return this.isnewpassword;
	}

	public void setIsnewpassword(String isnewpassword) {
		this.isnewpassword = isnewpassword;
	}

	public Timestamp getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

	public String getLoginStatus() {
		return this.loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getMobilephone1() {
		return this.mobilephone1;
	}

	public void setMobilephone1(String mobilephone1) {
		this.mobilephone1 = mobilephone1;
	}

	public String getMobilephone2() {
		return this.mobilephone2;
	}

	public void setMobilephone2(String mobilephone2) {
		this.mobilephone2 = mobilephone2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getPasswordExpiredDate() {
		return this.passwordExpiredDate;
	}

	public void setPasswordExpiredDate(Timestamp passwordExpiredDate) {
		this.passwordExpiredDate = passwordExpiredDate;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSalesSubtype() {
		return this.salesSubtype;
	}

	public void setSalesSubtype(String salesSubtype) {
		this.salesSubtype = salesSubtype;
	}

	public String getSalescodeccg() {
		return this.salescodeccg;
	}

	public void setSalescodeccg(String salescodeccg) {
		this.salescodeccg = salescodeccg;
	}

	public String getSalescodeclg() {
		return this.salescodeclg;
	}

	public void setSalescodeclg(String salescodeclg) {
		this.salescodeclg = salescodeclg;
	}

	public String getSalesgroup() {
		return this.salesgroup;
	}

	public void setSalesgroup(String salesgroup) {
		this.salesgroup = salesgroup;
	}

	public String getSaleslevel() {
		return this.saleslevel;
	}

	public void setSaleslevel(String saleslevel) {
		this.saleslevel = saleslevel;
	}

	public String getSalestype() {
		return this.salestype;
	}

	public void setSalestype(String salestype) {
		this.salestype = salestype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadby() {
		return this.uploadby;
	}

	public void setUploadby(String uploadby) {
		this.uploadby = uploadby;
	}

	public String getUserrole() {
		return this.userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public List<TAuditTrail> getTAuditTrails1() {
		return this.TAuditTrails1;
	}

	public void setTAuditTrails1(List<TAuditTrail> TAuditTrails1) {
		this.TAuditTrails1 = TAuditTrails1;
	}

	public TAuditTrail addTAuditTrails1(TAuditTrail TAuditTrails1) {
		getTAuditTrails1().add(TAuditTrails1);
		TAuditTrails1.setUserprofile1(this);

		return TAuditTrails1;
	}

	public TAuditTrail removeTAuditTrails1(TAuditTrail TAuditTrails1) {
		getTAuditTrails1().remove(TAuditTrails1);
		TAuditTrails1.setUserprofile1(null);

		return TAuditTrails1;
	}

	public List<TAuditTrail> getTAuditTrails2() {
		return this.TAuditTrails2;
	}

	public void setTAuditTrails2(List<TAuditTrail> TAuditTrails2) {
		this.TAuditTrails2 = TAuditTrails2;
	}

	public TAuditTrail addTAuditTrails2(TAuditTrail TAuditTrails2) {
		getTAuditTrails2().add(TAuditTrails2);
		TAuditTrails2.setUserprofile2(this);

		return TAuditTrails2;
	}

	public TAuditTrail removeTAuditTrails2(TAuditTrail TAuditTrails2) {
		getTAuditTrails2().remove(TAuditTrails2);
		TAuditTrails2.setUserprofile2(null);

		return TAuditTrails2;
	}

	public List<TAuditTrail> getTAuditTrails3() {
		return this.TAuditTrails3;
	}

	public void setTAuditTrails3(List<TAuditTrail> TAuditTrails3) {
		this.TAuditTrails3 = TAuditTrails3;
	}

	public TAuditTrail addTAuditTrails3(TAuditTrail TAuditTrails3) {
		getTAuditTrails3().add(TAuditTrails3);
		TAuditTrails3.setUserprofile3(this);

		return TAuditTrails3;
	}

	public TAuditTrail removeTAuditTrails3(TAuditTrail TAuditTrails3) {
		getTAuditTrails3().remove(TAuditTrails3);
		TAuditTrails3.setUserprofile3(null);

		return TAuditTrails3;
	}

	public List<TCpi> getTCpis1() {
		return this.TCpis1;
	}

	public void setTCpis1(List<TCpi> TCpis1) {
		this.TCpis1 = TCpis1;
	}

	public TCpi addTCpis1(TCpi TCpis1) {
		getTCpis1().add(TCpis1);
		TCpis1.setUserprofile1(this);

		return TCpis1;
	}

	public TCpi removeTCpis1(TCpi TCpis1) {
		getTCpis1().remove(TCpis1);
		TCpis1.setUserprofile1(null);

		return TCpis1;
	}

	public List<TCpi> getTCpis2() {
		return this.TCpis2;
	}

	public void setTCpis2(List<TCpi> TCpis2) {
		this.TCpis2 = TCpis2;
	}

	public TCpi addTCpis2(TCpi TCpis2) {
		getTCpis2().add(TCpis2);
		TCpis2.setUserprofile2(this);

		return TCpis2;
	}

	public TCpi removeTCpis2(TCpi TCpis2) {
		getTCpis2().remove(TCpis2);
		TCpis2.setUserprofile2(null);

		return TCpis2;
	}

	public List<TCpo> getTCpos1() {
		return this.TCpos1;
	}

	public void setTCpos1(List<TCpo> TCpos1) {
		this.TCpos1 = TCpos1;
	}

	public TCpo addTCpos1(TCpo TCpos1) {
		getTCpos1().add(TCpos1);
		TCpos1.setUserprofile1(this);

		return TCpos1;
	}

	public TCpo removeTCpos1(TCpo TCpos1) {
		getTCpos1().remove(TCpos1);
		TCpos1.setUserprofile1(null);

		return TCpos1;
	}

	public List<TCpo> getTCpos2() {
		return this.TCpos2;
	}

	public void setTCpos2(List<TCpo> TCpos2) {
		this.TCpos2 = TCpos2;
	}

	public TCpo addTCpos2(TCpo TCpos2) {
		getTCpos2().add(TCpos2);
		TCpos2.setUserprofile2(this);

		return TCpos2;
	}

	public TCpo removeTCpos2(TCpo TCpos2) {
		getTCpos2().remove(TCpos2);
		TCpos2.setUserprofile2(null);

		return TCpos2;
	}

	public List<TCustomerResponse> getTCustomerResponses1() {
		return this.TCustomerResponses1;
	}

	public void setTCustomerResponses1(List<TCustomerResponse> TCustomerResponses1) {
		this.TCustomerResponses1 = TCustomerResponses1;
	}

	public TCustomerResponse addTCustomerResponses1(TCustomerResponse TCustomerResponses1) {
		getTCustomerResponses1().add(TCustomerResponses1);
		TCustomerResponses1.setUserprofile1(this);

		return TCustomerResponses1;
	}

	public TCustomerResponse removeTCustomerResponses1(TCustomerResponse TCustomerResponses1) {
		getTCustomerResponses1().remove(TCustomerResponses1);
		TCustomerResponses1.setUserprofile1(null);

		return TCustomerResponses1;
	}

	public List<TCustomerResponse> getTCustomerResponses2() {
		return this.TCustomerResponses2;
	}

	public void setTCustomerResponses2(List<TCustomerResponse> TCustomerResponses2) {
		this.TCustomerResponses2 = TCustomerResponses2;
	}

	public TCustomerResponse addTCustomerResponses2(TCustomerResponse TCustomerResponses2) {
		getTCustomerResponses2().add(TCustomerResponses2);
		TCustomerResponses2.setUserprofile2(this);

		return TCustomerResponses2;
	}

	public TCustomerResponse removeTCustomerResponses2(TCustomerResponse TCustomerResponses2) {
		getTCustomerResponses2().remove(TCustomerResponses2);
		TCustomerResponses2.setUserprofile2(null);

		return TCustomerResponses2;
	}

	public List<TCustomerResponse> getTCustomerResponses3() {
		return this.TCustomerResponses3;
	}

	public void setTCustomerResponses3(List<TCustomerResponse> TCustomerResponses3) {
		this.TCustomerResponses3 = TCustomerResponses3;
	}

	public TCustomerResponse addTCustomerResponses3(TCustomerResponse TCustomerResponses3) {
		getTCustomerResponses3().add(TCustomerResponses3);
		TCustomerResponses3.setUserprofile3(this);

		return TCustomerResponses3;
	}

	public TCustomerResponse removeTCustomerResponses3(TCustomerResponse TCustomerResponses3) {
		getTCustomerResponses3().remove(TCustomerResponses3);
		TCustomerResponses3.setUserprofile3(null);

		return TCustomerResponses3;
	}

	public List<TLoginHistory> getTLoginHistories() {
		return this.TLoginHistories;
	}

	public void setTLoginHistories(List<TLoginHistory> TLoginHistories) {
		this.TLoginHistories = TLoginHistories;
	}

	public TLoginHistory addTLoginHistory(TLoginHistory TLoginHistory) {
		getTLoginHistories().add(TLoginHistory);
		TLoginHistory.setUserprofile(this);

		return TLoginHistory;
	}

	public TLoginHistory removeTLoginHistory(TLoginHistory TLoginHistory) {
		getTLoginHistories().remove(TLoginHistory);
		TLoginHistory.setUserprofile(null);

		return TLoginHistory;
	}

	public List<TOffer> getTOffers1() {
		return this.TOffers1;
	}

	public void setTOffers1(List<TOffer> TOffers1) {
		this.TOffers1 = TOffers1;
	}

	public TOffer addTOffers1(TOffer TOffers1) {
		getTOffers1().add(TOffers1);
		TOffers1.setUserprofile1(this);

		return TOffers1;
	}

	public TOffer removeTOffers1(TOffer TOffers1) {
		getTOffers1().remove(TOffers1);
		TOffers1.setUserprofile1(null);

		return TOffers1;
	}

	public List<TOffer> getTOffers2() {
		return this.TOffers2;
	}

	public void setTOffers2(List<TOffer> TOffers2) {
		this.TOffers2 = TOffers2;
	}

	public TOffer addTOffers2(TOffer TOffers2) {
		getTOffers2().add(TOffers2);
		TOffers2.setUserprofile2(this);

		return TOffers2;
	}

	public TOffer removeTOffers2(TOffer TOffers2) {
		getTOffers2().remove(TOffers2);
		TOffers2.setUserprofile2(null);

		return TOffers2;
	}

}