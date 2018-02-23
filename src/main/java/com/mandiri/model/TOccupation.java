package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_occupation database table.
 * 
 */
@Entity
@Table(name="t_occupation")
@NamedQuery(name="TOccupation.findAll", query="SELECT t FROM TOccupation t")
public class TOccupation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String occp;

	private String occpdsc;

	//bi-directional many-to-one association to TCpi
	@OneToMany(mappedBy="TOccupation")
	private List<TCpi> TCpis;

	public TOccupation() {
	}

	public String getOccp() {
		return this.occp;
	}

	public void setOccp(String occp) {
		this.occp = occp;
	}

	public String getOccpdsc() {
		return this.occpdsc;
	}

	public void setOccpdsc(String occpdsc) {
		this.occpdsc = occpdsc;
	}

	public List<TCpi> getTCpis() {
		return this.TCpis;
	}

	public void setTCpis(List<TCpi> TCpis) {
		this.TCpis = TCpis;
	}

	public TCpi addTCpi(TCpi TCpi) {
		getTCpis().add(TCpi);
		TCpi.setTOccupation(this);

		return TCpi;
	}

	public TCpi removeTCpi(TCpi TCpi) {
		getTCpis().remove(TCpi);
		TCpi.setTOccupation(null);

		return TCpi;
	}

}