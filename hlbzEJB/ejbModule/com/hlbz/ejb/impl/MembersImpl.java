package com.hlbz.ejb.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


@Stateless
@LocalBean
public class MembersImpl extends AbstractImpl implements MembersRemote, MembersLocal  {

	private static final long serialVersionUID = 7375190584625975749L;
	static Logger log = Logger.getLogger(MembersImpl.class);

	@Override
	public void doSomething() {
		log.info("**************************");
		log.info("* I'm doing Something !! *");
		log.info("**************************");
	}

    
    

}
