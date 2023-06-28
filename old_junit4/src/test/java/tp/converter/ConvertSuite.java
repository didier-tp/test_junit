package tp.converter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestConverter.class , 
	TestEnglishToFrenchTranslator.class,
	TestEnglishToSpanishTranslator.class
})
public class ConvertSuite /* extends TestSuite */ {
}
