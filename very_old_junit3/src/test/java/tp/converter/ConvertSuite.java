package tp.converter;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ConvertSuite extends TestSuite {
	public static Test suite() {
        final TestSuite s = new TestSuite();
        s.addTestSuite(TestConverter.class);
        s.addTestSuite(TestEnglishToFrenchTranslator.class);
        s.addTestSuite(TestEnglishToSpanishTranslator.class);
        return s;
    }
}
