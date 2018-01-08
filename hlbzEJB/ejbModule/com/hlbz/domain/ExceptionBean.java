package com.hlbz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table (name="exception")
@NamedQueries (
		@NamedQuery(name="exception.findAll", query="select t from ExceptionBean t")
)
public class ExceptionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public ExceptionBean() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int hashCode() {
		return (this.id == null) ? 0 : this.id.hashCode();
	}

	public boolean equals(Object object) {
		if (object instanceof ExceptionBean) {
			final ExceptionBean obj = (ExceptionBean) object;
			return (this.id != null) ? this.id.equals(obj.id) : (obj.id == null);
		}
		return false;
	}

}
