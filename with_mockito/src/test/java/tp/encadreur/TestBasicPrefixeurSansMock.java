package tp.encadreur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBasicPrefixeurSansMock {
	
	private static Logger logger = LoggerFactory.getLogger(TestBasicPrefixeurSansMock.class);
	
	private BasicPrefixeur prefixeur;  //à tester
	
	@BeforeEach
	public void initBasicPrefixeurWithBasicCustomeSeparator() {
		BasicSeparator basicSeparator = new BasicSeparator();
		basicSeparator.setRepeatedSeparator("_", 2);
		prefixeur = new BasicPrefixeur(basicSeparator);
	}
	
	@Test
	public void testPrefixer() {
		String s="junit";
		String prefixe="jaime";
		String sRes = prefixeur.prefixer(s, prefixe);
		assertEquals("jaime__junit",sRes);
		logger.trace("testPrefixer:"+sRes);
	}
	
	

}
