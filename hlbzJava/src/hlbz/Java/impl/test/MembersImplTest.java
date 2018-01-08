package hlbz.Java.impl.test;

import static org.junit.Assert.fail;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.hlbz.ejb.impl.Members;

public class MembersImplTest {

	private final String URL_MEMBERS="hlbz/hlbzEJB/MembersImpl!com.hlbz.ejb.impl.MembersRemote"; 
	Members bean;
	
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testMemberSomething() {
		try{
			
			Properties jndiProps = new Properties();
            jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProps.put("jboss.naming.client.ejb.context", true);
            
            Context ctx = new InitialContext(jndiProps);

            bean = (Members) ctx.lookup(URL_MEMBERS);
			bean.doSomething();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			fail("Boum !");
		}
		
		
	}

}
