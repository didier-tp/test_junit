package tp.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(Lifecycle.PER_CLASS)
public class TestsImbriques {
	private static Logger logger = LoggerFactory.getLogger(TestsImbriques.class);
	
	List<String> textList;//ex: "red","green"
	
	//@BeforeEach //NB: will be very often re-launched if @BeforeEach !!! 
	@BeforeAll //NB: @BeforeAll can be used on main test class level because of @TestInstance(Lifecycle.PER_CLASS)
    void mainInit() {
      textList = MyTranslationFixtureHelper.englishTextList();
      logger.trace("BeforeEach / first level , textList="+textList);
    }
	
	@Nested
	class TestImbriqueEnglishToFrench {
		
		private Translator translator;
	
	    @BeforeEach
	    void subInit() {
	      logger.trace("BeforeEach imbrique (EnglishToFrench)");
	      translator = new EnglishToFrenchTranslator();
	    }
	    
	    @Test
		public void testGoodTranslationsImbrique() {
			Map<String,String> translatedMap = this.translator.translate(textList);
			logger.trace("translatedMap="+translatedMap);
			assertTrue(translatedMap.size()==textList.size());
			assertEquals("rouge", translatedMap.get("red"));
			assertEquals("vert", translatedMap.get("green"));
		}
	}//end of TestImbriqueEnglishToFrench
	
	@Nested
	class TestImbriqueEnglishToSpanish {
		
		private Translator translator;
	
	    @BeforeEach
	    void subInit() {
	      logger.trace("BeforeEach imbrique (EnglishToSpanish)");
	      translator = new EnglishToSpanishTranslator();
	    }
	    
	    @Test
		public void testGoodTranslationsImbrique() {
			Map<String,String> translatedMap = this.translator.translate(textList);
			logger.trace("translatedMap="+translatedMap);
			assertTrue(translatedMap.size()==textList.size());
			assertEquals("rojo", translatedMap.get("red"));
			assertEquals("verde", translatedMap.get("green"));
		}
	}//end of TestImbriqueEnglishToSpanish

}
