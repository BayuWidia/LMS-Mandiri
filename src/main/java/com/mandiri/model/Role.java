package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;


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

}