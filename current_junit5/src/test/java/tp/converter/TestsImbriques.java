package tp.converter;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//choisir @TestInstance(Lifecycle.PER_METHOD) (par défaut) dans un premier temps
//puis optimiser éventuellement/ultérieurement via @TestInstance(Lifecycle.PER_CLASS) 
public class TestsImbriques {
	private static Logger logger = LoggerFactory.getLogger(TestsImbriques.class);
	
	List<String> textList;//ex: "red","green"
	
	
	//@.... 
    void mainInit() {
      //textList = ...
      logger.trace("Before..../ first level , textList="+textList);
    }
	
	//@...
	class TestImbriqueEnglishToFrench {
		
		//à coder en s'inspirant de TestEnglishToFrenchTranslator
		
	}//end of TestImbriqueEnglishToFrench 
	
	@Nested
	class TestImbriqueEnglishToSpanish {
		
		//à coder en s'inspirant de TestEnglishToSpanishTranslator
		
	}//end of TestImbriqueEnglishToSpanish

}
