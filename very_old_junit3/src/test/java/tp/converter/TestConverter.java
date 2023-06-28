package tp.converter;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;
import tp.data.Personne;

public class TestConverter extends TestCase {
	
	
	public void testGoodDoubleFromStringConversion() {
		String sx = "12.34";
		double x = BasicConverter.doubleFromString(sx);
		System.out.println("testGoodDoubleToStringConversion ..., x = " + x);
		assertEquals(12.34,x,0.001);
	}
	
	public void testBadDoubleFromStringConversion() {
			try {
				String sx = "12a.34";
				double x = BasicConverter.doubleFromString(sx);
				fail("NumberFormatException should be raised");
			} catch (NumberFormatException e) {
				System.err.println("NumberFormatException " +  e.getMessage());
				//e.printStackTrace();
				assertTrue(e.getClass().getSimpleName().equals("NumberFormatException"));
			}
		
	}
	
	public void testPersonneInLowercase() {
		Personne originalPers = new Personne(2L,"Jean" , "Bon" , 172.4);
		Personne p = (Personne) BasicConverter.allPartsInLowercase(originalPers);
		System.err.println("p with allPartsInLowercase = " +  p);
		Personne expectedPers = new Personne(2L,"jean" , "bon" , 172.4);
		assertEquals(expectedPers, p);  //NB: Personne.equals(...) should be implemented .
	}
	
	
	public void testSameVsEquals() {
		String s1="abc";
		String s1Maj = s1.toUpperCase();
		String s1Ref2 = s1;
		String s2="ABC";
		Assert.assertSame(s1Ref2,s1);  //teste si s1Ref2 == s1 (references on same object)
		Assert.assertNotSame(s1Maj,s2);
		Assert.assertEquals(s1Maj,s2);//teste si s1Maj.equals(s2))
	}
	
	
}
