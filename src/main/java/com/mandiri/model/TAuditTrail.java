package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_audit_trail database table.
 * 
 */
@Entity
@Table(name="t_audit_trail")
@NamedQuery(name="TAuditTrail.findAll", query="SELECT t FROM TAuditTrail t")
public class TAuditTrail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Timestamp audited;

	private Timestamp createdon;

	private Integer criteria;

	private String info;

	private Timestamp modifiedon;

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
	@JoinColumn(name="user_nip")
	private Userprofile userprofile3;

	public TAuditTrail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAudited() {
		return this.audited;
	}

	public void setAudited(Timestamp audited) {
		this.audited = audited;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public Integer getCriteria() {
		return this.criteria;
	}

	public void setCriteria(Integer criteria) {
		this.criteria = criteria;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
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