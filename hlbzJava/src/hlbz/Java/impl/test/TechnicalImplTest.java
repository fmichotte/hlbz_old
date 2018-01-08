package hlbz.Java.impl.test;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.hlbz.domain.TechnicalBean;
import com.hlbz.ejb.impl.Technical;

@FixMethodOrder (MethodSorters.DEFAULT)
public class TechnicalImplTest {

	private static Logger log = Logger.getLogger(TechnicalImplTest.class);

	private final String URL_TECHNICAL="hlbz/hlbzEJB/TechnicalImpl!com.hlbz.ejb.impl.TechnicalRemote"; 
	private final TechnicalBean DATA_BEAN = new TechnicalBean("xx", "xxx");
	private final String WRONG_KEY = "WRONG";
	
	
	Technical bean;
	TechnicalBean dataBean;
	Context ctx = null;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	private void setContext(){
		if (ctx == null){
		
			try {
				Properties jndiProps = new Properties();
				jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
				jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
				jndiProps.put("jboss.naming.client.ejb.context", true);
				
				ctx = new InitialContext(jndiProps);
	            bean = (Technical) ctx.lookup(URL_TECHNICAL);

			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testTechnicalSomething() {

		setContext();		
		bean.doSomething();
		
	}
	
	
	
	@Test
	public void testTechnicalFlow(){
		setContext();		

		log.info("******************** remove a wrong Technical Bean ***************************");
		bean.removeTechnicalBean(DATA_BEAN);

		log.info("******************** Add a Technical Bean ******************************");
		bean.addTechnicalBean(DATA_BEAN);
		
		log.info("******************** Find a Technical Bean *****************************");
		TechnicalBean b = bean.getTechnicalBean(DATA_BEAN.getKey());
		assertEquals(b.getValue(), DATA_BEAN.getValue());
		
		log.info("******************** update a Technical Bean ***************************");
		DATA_BEAN.setValue("UPDATED");
		TechnicalBean bu = bean.updateTechnicalBean(DATA_BEAN);
		assertEquals(bu.getValue(), DATA_BEAN.getValue());

		log.info("******************** find All Technical Bean ***************************");
		bean.getAll();

		log.info("******************** remove a Technical Bean ***************************");
		bean.removeTechnicalBean(DATA_BEAN);

		log.info("******************** Find a WRONG Technical Bean *****************************");
		b = bean.getTechnicalBean(WRONG_KEY);

		
	}
	

}
