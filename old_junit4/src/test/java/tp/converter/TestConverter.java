package tp.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;  //NB: org.junit.Assert in JUnit4 , not old junit.framework.Assert
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.data.Personne;

public class TestConverter /* extends TestCase */ {
	
	private static Logger logger = LoggerFactory.getLogger(TestConverter.class);
	
	@Test
	public void testGoodDoubleFromStringConversion() {
		String sx = "12.34";
		double x = BasicConverter.doubleFromString(sx);
		logger.trace("testGoodDoubleToStringConversion ..., x = " + x);
		assertEquals(12.34,x,0.001);
	}
	
	@Test
	public void testBadDoubleFromStringConversion() {
			try {
				String sx = "12a.34";
				double x = BasicConverter.doubleFromString(sx);
				fail("NumberFormatException should be raised");
			} catch (NumberFormatException e) {
				logger.trace("NumberFormatException " +  e.getMessage());
				//e.printStackTrace();
				assertTrue(e.getClass().getSimpleName().equals("NumberFormatException"));
			}
		
	}
	
	@Test
	public void testBadDoubleFromStringConversionV2() {
		RuntimeException exception = assertThrows(/*RuntimeException.class*/ NumberFormatException.class,
				()->{ String sx = "12a.34";
					double x = BasicConverter.doubleFromString(sx);
				});
		assertTrue(exception.getMessage().contains("For input string"));
	}
	
	
	@Test(expected = NumberFormatException.class)//JUST IN JUNIT4 , NOT IN JUNIT5 !!!
	public void testBadDoubleFromStringConversionV3() {
		String sx = "12a.34";
		double x = BasicConverter.doubleFromString(sx);
	}
	
	@Test
	public void testPersonneInLowercase() {
		Personne originalPers = new Personne(2L,"Jean" , "Bon" , 172.4);
		Personne p = (Personne) BasicConverter.allPartsInLowercase(originalPers);
		logger.trace("p with allPartsInLowercase = " +  p);
		Personne expectedPers = new Personne(2L,"jean" , "bon" , 172.4);
		assertEquals(expectedPers, p);  //NB: Personne.equals(...) should be implemented .
	}
	
	@Test
	public void testPersonneWithHamcrestAssertThat() {
		Personne originalPers = new Personne(2L,"Jean" , "Bon" , 172.4);
		Personne p = (Personne) BasicConverter.allPartsInLowercase(originalPers);
		logger.trace("p with allPartsInLowercase = " +  p);
		MatcherAssert.assertThat(p.getNom(),Matchers.is("bon"));
		//NB: org.junit.Assert.assertThat() was now deprecated because for hamcrest 1.x Matcher only
		//org.hamcrest.MatcherAssert.assertThat() must be used instead (in Junit 4 and JUnit5)
	}
	
	@Test
	public void testSameVsEquals() {
		String s1="abc";
		String s1Maj = s1.toUpperCase();
		String s1Ref2 = s1;
		String s2="ABC";
		Assert.assertSame(s1Ref2,s1);  //teste si s1Ref2 == s1 (references on same object)
		Assert.assertNotSame(s1Maj,s2);
		Assert.assertEquals(s1Maj,s2);//teste si s1Maj.equals(s2))
	}
	
	@Test(timeout = 200) //200ms
	public void testWithTimeout() {
		try {
			Thread.sleep(100);//ok
			//Thread.sleep(300);//not_ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
