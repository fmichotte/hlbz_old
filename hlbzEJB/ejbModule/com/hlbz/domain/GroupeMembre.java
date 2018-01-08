package com.hlbz.domain;

import java.io.Serializable;

public class GroupeMembre implements Serializable {

	private static final long serialVersionUID = 106183269856317925L;
	private Integer groupID;
	private Integer membreID;
	
	
	public Integer getGroupID() {
		return groupID;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	public Integer getMembreID() {
		return membreID;
	}
	public void setMembreID(Integer membreID) {
		this.membreID = membreID;
	}

}
