package tp.calculs;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CalculSuite extends TestSuite {
	public static Test suite() {
        final TestSuite s = new TestSuite();
        s.addTest(TestCalculsSimples.suite());
        s.addTestSuite(TestEmptySerie.class);
        s.addTestSuite(TestSerie.class);
        return s;
    }
}
