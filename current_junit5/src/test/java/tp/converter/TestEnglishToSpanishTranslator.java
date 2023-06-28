package tp.converter;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEnglishToSpanishTranslator  {
	
	private static Logger logger = LoggerFactory.getLogger(TestEnglishToSpanishTranslator.class);
	
	Translator translator;
	List<String> textList;
	
	@BeforeEach
	public void initBeforeEach(){
		logger.trace("initBeforeEach() called in jUnit5 if prefixed by @BeforeEach");
		translator = new EnglishToSpanishTranslator();
		textList = MyTranslationFixtureHelper.englishTextList();
	}
	
	@Test
	public void testGoodTranslations() {
		Map<String,String> translatedMap = this.translator.translate(this.textList);
		logger.trace("translatedMap="+translatedMap);
		assertTrue(translatedMap.size()==textList.size());
		assertEquals("rojo", translatedMap.get("red"));
		assertEquals("verde", translatedMap.get("green"));
	}
	
	

}
