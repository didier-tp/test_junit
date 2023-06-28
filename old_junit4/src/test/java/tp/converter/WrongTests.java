package tp.converter;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class WrongTests {
	
	@Test
	@Ignore //test désactivé/ignoré
	public void testWithError() {
		int a=3;
		int b=0;
		assertTrue(a/b==0);//div by zero exception/error !!!
	}
	
	@Test
	@Ignore //test désactivé/ignoré
	public void testWithBadAssertion() {
		assertTrue(2+2==5); //2+2==4 !!!! not 5 !!!
	}
	
	@Test
	public void goodTrivialTest() {
		assertTrue(2+2==4); 
	}

}
