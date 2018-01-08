package com.hlbz.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@Table (name="testchical")
@NamedQueries (
		@NamedQuery(name="technical.findAll", query="select t from TechnicalBean t")
)
public class TechnicalBean implements Serializable {

	private static final long serialVersionUID = 6373369188404538363L;

	@Id
	protected String key;

	public TechnicalBean() {
		
	}

	public TechnicalBean(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Column
	protected String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
