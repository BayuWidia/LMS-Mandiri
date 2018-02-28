package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_cpi database table.
 * 
 */
@Entity
@Table(name="t_cpi")
@NamedQuery(name="TCpi.findAll", query="SELECT t FROM TCpi t")
public class TCpi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cif;

	public TCpi(String cif) {
		super();
		this.cif = cif;
	}

	private String address;

	@Column(name="birth_date")
	private Timestamp birthDate;

	@Column(name="birth_place")
	private String birthPlace;

	private String branch;

	private String cluster1;

	private String cluster2;

	private Timestamp createdon;

	private String email;

	private String employer;

	private String gender;

	private String hp;

	private String identity;

	private Timestamp modifiedon;

	@Column(name="mother_name")
	private String motherName;

	private String name;

	private String nik;

	private Integer payrollflag;

	private Boolean pep;

	private Integer priorityflag;

	private String segment;

	@Column(name="source_type")
	private Integer sourceType;

	//bi-directional many-to-one association to TCph
	@OneToMany(mappedBy="TCpi")
	private List<TCph> TCphs;

	//bi-directional many-to-one association to TOccupation
	@ManyToOne
	@JoinColumn(name="occp")
	private TOccupation TOccupation;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="createdby")
	private Userprofile userprofile1;

	//bi-directional many-to-one association to Userprofile
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private Userprofile userprofile2;

	//bi-directional many-to-one association to TCpo
	@OneToMany(mappedBy="TCpi")
	private List<TCpo> TCpos;

	//bi-directional many-to-one association to TCustomerResponse
	@OneToMany(mappedBy="TCpi")
	private List<TCustomerResponse> TCustomerResponses;

	public TCpi() {
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCluster1() {
		return this.cluster1;
	}

	public void setCluster1(String cluster1) {
		this.cluster1 = cluster1;
	}

	public String getCluster2() {
		return this.cluster2;
	}

	public void setCluster2(String cluster2) {
		this.cluster2 = cluster2;
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

	public String getEmployer() {
		return this.employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHp() {
		return this.hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public Integer getPayrollflag() {
		return this.payrollflag;
	}

	public void setPayrollflag(Integer payrollflag) {
		this.payrollflag = payrollflag;
	}

	public Boolean getPep() {
		return this.pep;
	}

	public void setPep(Boolean pep) {
		this.pep = pep;
	}

	public Integer getPriorityflag() {
		return this.priorityflag;
	}

	public void setPriorityflag(Integer priorityflag) {
		this.priorityflag = priorityflag;
	}

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public List<TCph> getTCphs() {
		return this.TCphs;
	}

	public void setTCphs(List<TCph> TCphs) {
		this.TCphs = TCphs;
	}

	public TCph addTCph(TCph TCph) {
		getTCphs().add(TCph);
		TCph.setTCpi(this);

		return TCph;
	}

	public TCph removeTCph(TCph TCph) {
		getTCphs().remove(TCph);
		TCph.setTCpi(null);

		return TCph;
	}

	public TOccupation getTOccupation() {
		return this.TOccupation;
	}

	public void setTOccupation(TOccupation TOccupation) {
		this.TOccupation = TOccupation;
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

	public List<TCpo> getTCpos() {
		return this.TCpos;
	}

	public void setTCpos(List<TCpo> TCpos) {
		this.TCpos = TCpos;
	}

	public TCpo addTCpo(TCpo TCpo) {
		getTCpos().add(TCpo);
		TCpo.setTCpi(this);

		return TCpo;
	}

	public TCpo removeTCpo(TCpo TCpo) {
		getTCpos().remove(TCpo);
		TCpo.setTCpi(null);

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
		TCustomerRespons.setTCpi(this);

		return TCustomerRespons;
	}

	public TCustomerResponse removeTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().remove(TCustomerRespons);
		TCustomerRespons.setTCpi(null);

		return TCustomerRespons;
	}

}