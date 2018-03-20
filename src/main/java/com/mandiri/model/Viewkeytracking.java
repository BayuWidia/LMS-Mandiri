package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viewkeytracking database table.
 * 
 */
@Entity
@NamedQuery(name="Viewkeytracking.findAll", query="SELECT v FROM Viewkeytracking v")
public class Viewkeytracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="input_class")
	private String inputClass;

	private String name;

	@Column(name="program_id")
	private Long programId;

	public Viewkeytracking() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInputClass() {
		return this.inputClass;
	}

	public void setInputClass(String inputClass) {
		this.inputClass = inputClass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProgramId() {
		return this.programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

}