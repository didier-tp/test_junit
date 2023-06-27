package tp.calculs;

import junit.framework.TestCase;

public class TestEmptySerie extends TestCase {
	
	private Serie serie;
	
	
	public void setUp() {
		System.out.println("setUp() of JUnit3 called on " + this);
		serie= new Serie();
	}
	
	public void tearDown() {
		System.out.println("tearDown() of JUnit3 called on " + this);
	}
	
	
	public void testComputeStats() {
		Stat stat = serie.computeStats();
		System.out.println("testComputeStats() , stat="+stat);
		assertTrue(stat.size==0);
		assertEquals(0.0,stat.sum,0.000001);
		assertEquals(Double.NaN,stat.average,0.000001);
		assertEquals(Double.NaN,stat.variance,0.000001);
	}
	
	public void testEcartType() {
		Stat stat = serie.computeStats();
		System.out.println("testEcartType ..., ecartType = " + stat.ecartType());
		assertEquals(Double.NaN,stat.ecartType(),0.000001);
	}
	

}
