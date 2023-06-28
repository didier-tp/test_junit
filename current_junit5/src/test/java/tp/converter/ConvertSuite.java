package tp.converter;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

//@RunWith(JUnitPlatform.class) will be deprecated , use @Suite instead
//but @Suite not already supported by some old IDE (ex: ok with eclipse 2023-03)
@Suite
@SelectClasses({
    TestConverter.class,
    TestEnglishToFrenchTranslator.class,
    TestEnglishToSpanishTranslator.class
})
public class ConvertSuite {
}
