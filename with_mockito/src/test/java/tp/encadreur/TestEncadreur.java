package tp.encadreur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEncadreur {
	
	private static Logger logger = LoggerFactory.getLogger(TestEncadreur.class);
	
	private Encadreur encadreur; //à tester
	
	@BeforeEach
	public void initEncadreurWithDefaultImplemententation() {
		encadreur = new Encadreur();//with default internal BasicPrefixeur et BasicSuffixeur
		BasicSeparator basicSeparator = new BasicSeparator();
		basicSeparator.setRepeatedSeparator("_", 2);
		encadreur.setCustomSeparator(basicSeparator);
	}
	
	@Test
	public void testPrefixer() {
		String s="junit";
		String prefixe="jaime";
		String sRes = encadreur.prefixer(s, prefixe);
		assertEquals("jaime__junit",sRes);
		logger.trace("testPrefixer:"+sRes);
	}
	
	@Test
	public void testSuffixer() {
		String s="junit";
		String suffixe="5";
		String sRes = encadreur.suffixer(s, suffixe);
		assertEquals("junit__5",sRes);
		logger.trace("testSuffixer:"+sRes);
	}
	
	
	@Test
	public void testEncadrer() {
		String s="junit";
		String prefixe="[";
		String suffixe="]";
		String sRes = encadreur.encadrer(s, prefixe, suffixe);
		assertEquals("[__junit__]",sRes);
		logger.trace("testEncadrer:"+sRes);
	}
	
	

}
