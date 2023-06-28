package tp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestSuite;
import tp.calculs.CalculSuite;
import tp.converter.ConvertSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CalculSuite.class , 
	ConvertSuite.class
})
public class AllTestsSuite  {
}
