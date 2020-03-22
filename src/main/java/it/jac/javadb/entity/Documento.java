package it.jac.javadb.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cod_doc", length = 45)
	private String codDoc;

	@Column(name = "desc_doc", length = 45)
	private String descDoc;

	@Column(name = "data_doc")
	private Date dataDoc;

	@Column(name = "tipo_doc", length = 45)
	private String tipoDoc;
	
	@Column(name = "num_pagine")
	private Integer numPagine;

	@Column(name = "creation_time")
	private Timestamp creationTime;
	
	@Column(name = "creation_user")
	private String creationUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(String codDoc) {
		this.codDoc = codDoc;
	}

	public String getDescDoc() {
		return descDoc;
	}

	public void setDescDoc(String descDoc) {
		this.descDoc = descDoc;
	}

	public Date getDataDoc() {
		return dataDoc;
	}

	public void setDataDoc(Date dataDoc) {
		this.dataDoc = dataDoc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Integer getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(Integer numPagine) {
		this.numPagine = numPagine;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", codDoc=" + codDoc + ", descDoc=" + descDoc + ", dataDoc=" + dataDoc
				+ ", tipoDoc=" + tipoDoc + ", numPagine=" + numPagine + ", creationTime=" + creationTime
				+ ", creationUser=" + creationUser + "]";
	}

}
