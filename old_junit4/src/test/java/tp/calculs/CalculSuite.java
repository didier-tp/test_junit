package tp.calculs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestCalculsSimples.class , 
	TestEmptySerie.class,
	TestSerie.class
})
public class CalculSuite  {
}
