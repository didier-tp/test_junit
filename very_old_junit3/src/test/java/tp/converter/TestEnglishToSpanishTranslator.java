package tp.converter;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class TestEnglishToSpanishTranslator extends TestCase {
	
	private Translator translator;
	private List<String> textList;
	
	public void setUp(){
		translator = new EnglishToSpanishTranslator();
		textList = MyTranslationFixtureHelper.englishTextList();
	}
	
	
	public void testGoodTranslations() {
		Map<String,String> translatedMap = this.translator.translate(this.textList);
		System.out.println("translatedMap="+translatedMap);
		assertTrue(translatedMap.size()==textList.size());
		assertEquals("rojo", translatedMap.get("red"));
		assertEquals("verde", translatedMap.get("green"));
	}
	
}
