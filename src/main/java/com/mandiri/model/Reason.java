package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reason database table.
 * 
 */
@Entity
@NamedQuery(name="Reason.findAll", query="SELECT r FROM Reason r")
public class Reason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reason_id")
	private String reasonId;

	@Column(name="reason_name")
	private String reasonName;

	@Column(name="response_id")
	private String responseId;

	//bi-directional many-to-one association to TProduct
	@ManyToOne
	@JoinColumn(name="product_id")
	private TProduct TProduct;

	public Reason() {
	}

	public String getReasonId() {
		return this.reasonId;
	}

	public void setReasonId(String reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonName() {
		return this.reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	public String getResponseId() {
		return this.responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public TProduct getTProduct() {
		return this.TProduct;
	}

	public void setTProduct(TProduct TProduct) {
		this.TProduct = TProduct;
	}

}