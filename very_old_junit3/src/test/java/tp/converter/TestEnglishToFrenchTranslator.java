package tp.converter;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class TestEnglishToFrenchTranslator extends TestCase {
	
	private Translator translator;
	private List<String> textList;
	
	public void setUp(){
		translator = new EnglishToFrenchTranslator();
		textList = MyTranslationFixtureHelper.englishTextList();
	}
	
	
	public void testGoodTranslations() {
		Map<String,String> translatedMap = this.translator.translate(this.textList);
		System.out.println("translatedMap="+translatedMap);
		assertTrue(translatedMap.size()==textList.size());
		assertEquals("rouge", translatedMap.get("red"));
		assertEquals("vert", translatedMap.get("green"));
	}
	
	public void testNullNotNull() {
		//System.out.println("PI="+Math.PI);
		//String s1="Que J aime a faire connaitre un nombre utile aux sages";//3.1415926535
	    String resCannotTranslate = this.translator.translate("unknown_Word");
	    assertNull(resCannotTranslate);
	    
	    String greenTranslation = this.translator.translate("green");
	    assertNotNull(greenTranslation);
	}
	
	
	

}
