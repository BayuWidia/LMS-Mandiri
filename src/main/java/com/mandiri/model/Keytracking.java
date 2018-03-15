package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the keytracking database table.
 * 
 */
@Entity
@NamedQuery(name="Keytracking.findAll", query="SELECT k FROM Keytracking k")
public class Keytracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="input_class")
	private String inputClass;

	private String name;

	//bi-directional many-to-one association to Program
	@JsonIgnore
	@ManyToOne
	private Program program;

	public Keytracking() {
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

	public Program getProgram() {
		return this.program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

}