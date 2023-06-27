package tp.calculs;

import junit.framework.TestCase;

public class TestSerie extends TestCase {
	
	private Serie serie;
	
	
	public void setUp() {
		System.out.println("setUp() of JUnit3 called on " + this);
		serie= new Serie();
		serie.add(2.0);serie.add(4.0);serie.add(3.0);
	}
	
	public void tearDown() {
		System.out.println("tearDown() of JUnit3 called on " + this);
	}
	
	
	public void testComputeStats() {
		Stat stat = serie.computeStats();
		System.out.println("testComputeStats() , stat="+stat);
		assertTrue(stat.size==3);
		assertEquals(9.0,stat.sum,0.000001);
		assertEquals(3.0,stat.average,0.000001);
		assertEquals(0.666667,stat.variance,0.000001);
	}
	
	public void testEcartType() {
		Stat stat = serie.computeStats();
		System.out.println("testEcartType ..., ecartType = " + stat.ecartType());
		assertEquals(0.816496,stat.ecartType(),0.000001);
	}
	

}
