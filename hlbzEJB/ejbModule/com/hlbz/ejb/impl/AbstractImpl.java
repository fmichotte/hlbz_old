package com.hlbz.ejb.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

public abstract class AbstractImpl implements Serializable {
	
	private static final long serialVersionUID = -8224610050652029238L;
	static Logger log = Logger.getLogger(AbstractImpl.class);

	
	public void doSomething() {
		log.info("**************************");
		log.info("* I'm doing Something !! *");
		log.info("**************************");
		
	}


}
