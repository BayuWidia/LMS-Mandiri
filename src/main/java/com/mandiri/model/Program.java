package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the program database table.
 * 
 */
@Entity
@NamedQuery(name="Program.findAll", query="SELECT p FROM Program p")
public class Program implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	//bi-directional many-to-one association to Keytracking
	@JsonIgnore
	@OneToMany(mappedBy="program")
	private List<Keytracking> keytrackings;

	//bi-directional many-to-one association to TProduct
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_id")
	private TProduct TProduct;

	//bi-directional many-to-one association to TCpo
	@JsonIgnore
	@OneToMany(mappedBy="program")
	private List<TCpo> TCpos;

	//bi-directional many-to-one association to TCustomerResponse
	@JsonIgnore
	@OneToMany(mappedBy="program")
	private List<TCustomerResponse> TCustomerResponses;

	//bi-directional many-to-one association to TOffer
	@JsonIgnore
	@OneToMany(mappedBy="program")
	private List<TOffer> TOffers;

	public Program() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Keytracking> getKeytrackings() {
		return this.keytrackings;
	}

	public void setKeytrackings(List<Keytracking> keytrackings) {
		this.keytrackings = keytrackings;
	}

	public Keytracking addKeytracking(Keytracking keytracking) {
		getKeytrackings().add(keytracking);
		keytracking.setProgram(this);

		return keytracking;
	}

	public Keytracking removeKeytracking(Keytracking keytracking) {
		getKeytrackings().remove(keytracking);
		keytracking.setProgram(null);

		return keytracking;
	}

	public TProduct getTProduct() {
		return this.TProduct;
	}

	public void setTProduct(TProduct TProduct) {
		this.TProduct = TProduct;
	}

	public List<TCpo> getTCpos() {
		return this.TCpos;
	}

	public void setTCpos(List<TCpo> TCpos) {
		this.TCpos = TCpos;
	}

	public TCpo addTCpo(TCpo TCpo) {
		getTCpos().add(TCpo);
		TCpo.setProgram(this);

		return TCpo;
	}

	public TCpo removeTCpo(TCpo TCpo) {
		getTCpos().remove(TCpo);
		TCpo.setProgram(null);

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
		TCustomerRespons.setProgram(this);

		return TCustomerRespons;
	}

	public TCustomerResponse removeTCustomerRespons(TCustomerResponse TCustomerRespons) {
		getTCustomerResponses().remove(TCustomerRespons);
		TCustomerRespons.setProgram(null);

		return TCustomerRespons;
	}

	public List<TOffer> getTOffers() {
		return this.TOffers;
	}

	public void setTOffers(List<TOffer> TOffers) {
		this.TOffers = TOffers;
	}

	public TOffer addTOffer(TOffer TOffer) {
		getTOffers().add(TOffer);
		TOffer.setProgram(this);

		return TOffer;
	}

	public TOffer removeTOffer(TOffer TOffer) {
		getTOffers().remove(TOffer);
		TOffer.setProgram(null);

		return TOffer;
	}

}