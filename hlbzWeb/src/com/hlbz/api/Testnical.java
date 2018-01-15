package com.hlbz.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("hlapi")
public class Testnical {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		

		System.out.println("API - It Works");
		
		return "It works";
	}
	
}


