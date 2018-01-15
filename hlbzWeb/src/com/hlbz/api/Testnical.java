package com.hlbz.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author frederic.michotte
 * Sample URL - http://localhost:8100/hlbzWeb/hlapi/ztestnical
 *
 */
@Path("ztestnical")
public class Testnical {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTechnical() {
		

		System.out.println("API - It Works");
		
		return "It works";
	}
	
}


