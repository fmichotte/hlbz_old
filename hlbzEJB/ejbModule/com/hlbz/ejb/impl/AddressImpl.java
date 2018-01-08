package com.hlbz.ejb.impl;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class AddressImpl extends AbstractImpl implements AddressLocal, AddressRemote  {
	
	private static final long serialVersionUID = -1068737118864523853L;
	static Logger log = Logger.getLogger(AddressImpl.class);

	@Override
	public void doSomething() {
		log.info("**************************");
		log.info("* I'm doing Something !! *");
		log.info("**************************");
		
	}

}
