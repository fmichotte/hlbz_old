package com.hlbz.ejb.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.hlbz.domain.TechnicalBean;

@Stateless
@LocalBean
public class TechnicalImpl extends AbstractImpl implements TechnicalLocal, TechnicalRemote {
	

	@PersistenceContext	(name = "hlbzEJB")
    EntityManager entityManager;
	
	private static final long serialVersionUID = 10126898800006612L;
	static Logger log = Logger.getLogger(TechnicalImpl.class);

	@Override
	public void doSomething() {
		
		log.info("**************************");
		log.info("* I'm doing Something !! *");
		log.info("**************************");

	}

	@Override
	public TechnicalBean addTechnicalBean(TechnicalBean bean) {
		
		log.info("add a bean");		
		
		entityManager.persist(bean);
		return bean;
	}

	@Override
	public TechnicalBean getTechnicalBean(String key) {
		TechnicalBean bean = entityManager.find(TechnicalBean.class, key);
		return bean;
	}

	@Override
	public List<TechnicalBean> getAll() {

		log.info("getAll");		

		TypedQuery<TechnicalBean>  q = entityManager.createNamedQuery("technical.findAll", TechnicalBean.class);
		List<TechnicalBean> results = q.getResultList();
		
		return results;
	}

	@Override
	public TechnicalBean updateTechnicalBean(TechnicalBean bean) {
		TechnicalBean bean2 = entityManager.find(TechnicalBean.class, bean.getKey());
		
		bean2.setValue(bean.getValue());
		entityManager.merge(bean2);
		
		return bean2;
	}

	@Override
	public void removeTechnicalBean(TechnicalBean bean){
		log.info("remove a bean");		
		try{
			TechnicalBean bean2 = entityManager.find(TechnicalBean.class, bean.getKey());

			entityManager.remove(bean2);		
}catch (Exception e) {
			log.info("REMOVE ERROR", e);
		}
		
	}

	
}
