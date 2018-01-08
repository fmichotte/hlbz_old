package com.hlbz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table (name="address")
@NamedQueries (
		@NamedQuery(name="address.findAll", query="select t from AddressBean t")
)
public class AddressBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public AddressBean() {
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
		if (object instanceof AddressBean) {
			final AddressBean obj = (AddressBean) object;
			return (this.id != null) ? this.id.equals(obj.id) : (obj.id == null);
		}
		return false;
	}

}
