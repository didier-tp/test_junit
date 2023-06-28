package tp;

import junit.framework.Test;
import junit.framework.TestSuite;
import tp.calculs.CalculSuite;
import tp.converter.ConvertSuite;

public class AllTestsSuite extends TestSuite {
	public static Test suite() {
        final TestSuite s = new TestSuite();
        s.addTest(CalculSuite.suite());
        s.addTest(ConvertSuite.suite());
        return s;
    }
}
