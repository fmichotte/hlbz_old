package com.hlbz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table (name="zair")
@NamedQueries (
		@NamedQuery(name="zair.findAll", query="select t from ZairBean t")
)
public class ZairBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public ZairBean() {
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
		if (object instanceof ZairBean) {
			final ZairBean obj = (ZairBean) object;
			return (this.id != null) ? this.id.equals(obj.id) : (obj.id == null);
		}
		return false;
	}

}
