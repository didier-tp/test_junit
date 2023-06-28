package tp.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEnglishToFrenchTranslator /* extends TestCase */ {
	
	private static Logger logger = LoggerFactory.getLogger(TestEnglishToFrenchTranslator.class);
	
	Translator translator;
	List<String> textList;
	
	@Before
	public void setUp(){
		logger.trace("setUp() called in jUnit4 if extends TestCase or if prefixed by @Before");
		translator = new EnglishToFrenchTranslator();
		textList = MyTranslationFixtureHelper.englishTextList();
	}
	
	@Test
	public void testGoodTranslations() {
		Map<String,String> translatedMap = this.translator.translate(this.textList);
		logger.trace("translatedMap="+translatedMap);
		assertTrue(translatedMap.size()==textList.size());
		assertEquals("rouge", translatedMap.get("red"));
		assertEquals("vert", translatedMap.get("green"));
	}
	
	@Test
	public void testNullNotNull() {
		//System.out.println("PI="+Math.PI);
		//String s1="Que J aime a faire connaitre un nombre utile aux sages";//3.1415926535
	    String resCannotTranslate = this.translator.translate("unknown_Word");
	    assertNull(resCannotTranslate);
	    
	    String greenTranslation = this.translator.translate("green");
	    assertNotNull(greenTranslation);
	}
	
	
	

}
