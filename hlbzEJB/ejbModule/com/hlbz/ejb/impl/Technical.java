package com.hlbz.ejb.impl;

import java.io.Serializable;
import java.util.List;

import com.hlbz.domain.TechnicalBean;

public interface Technical extends Serializable  {
	
	public void doSomething();

	public TechnicalBean addTechnicalBean(TechnicalBean bean);
	public TechnicalBean getTechnicalBean(String key);
	public List<TechnicalBean> getAll();
	public TechnicalBean updateTechnicalBean(TechnicalBean bean);
	public void removeTechnicalBean(TechnicalBean bean);

}
