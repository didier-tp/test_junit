package tp.dynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDynamique {
	
	private static Logger logger = LoggerFactory.getLogger(TestDynamique.class);
	
	@TestFactory
	  Collection<DynamicTest> dynamicTestsWithCollection() {
	    Collection<DynamicTest> myDynamicTests = new ArrayList<>();
	    for (int i = 1; i <= 5; i++) {
	      int val = i;
	      myDynamicTests.add(DynamicTest.dynamicTest("Ajout " + val + "+" + val, 
	          () -> assertEquals(val * 2, val + val)));
	    }
	    return myDynamicTests;
	  }

	//à toutes fins utiles !!!!
}
