package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String coderole;

	private String desstatus;

	private Integer idroles;

	//bi-directional many-to-one association to Userprofile
	@OneToMany(mappedBy="role")
	private List<Userprofile> userprofiles;

	public Role() {
	}

	public String getCoderole() {
		return this.coderole;
	}

	public void setCoderole(String coderole) {
		this.coderole = coderole;
	}

	public String getDesstatus() {
		return this.desstatus;
	}

	public void setDesstatus(String desstatus) {
		this.desstatus = desstatus;
	}

	public Integer getIdroles() {
		return this.idroles;
	}

	public void setIdroles(Integer idroles) {
		this.idroles = idroles;
	}

	public List<Userprofile> getUserprofiles() {
		return this.userprofiles;
	}

	public void setUserprofiles(List<Userprofile> userprofiles) {
		this.userprofiles = userprofiles;
	}

	public Userprofile addUserprofile(Userprofile userprofile) {
		getUserprofiles().add(userprofile);
		userprofile.setRole(this);

		return userprofile;
	}

	public Userprofile removeUserprofile(Userprofile userprofile) {
		getUserprofiles().remove(userprofile);
		userprofile.setRole(null);

		return userprofile;
	}

}