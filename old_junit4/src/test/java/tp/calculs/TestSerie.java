package tp.calculs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSerie /* extends TestCase */ {
	
	private static Logger logger = LoggerFactory.getLogger(TestSerie.class);
	
	private Serie serie;
	
	@Before
	public void setUpBefore() {
		logger.trace("setUpBefore() with JUnit4 @Before called on " + this);
		serie= new Serie();
		serie.add(2.0);serie.add(4.0);serie.add(3.0);
	}
	
	@After
	public void tearDownAfter() {
		logger.trace("tearDownAfter()  with JUnit4 @After called on " + this);
	}
	
	@Test
	public void testComputeStats() {
		Stat stat = serie.computeStats();
		logger.trace("testComputeStats() , stat="+stat);
		assertTrue(stat.size==3);
		assertEquals(9.0,stat.sum,0.000001);
		assertEquals(3.0,stat.average,0.000001);
		assertEquals(0.666667,stat.variance,0.000001);
	}
	
	@Test
	public void testEcartType() {
		Stat stat = serie.computeStats();
		logger.trace("testEcartType ..., ecartType = " + stat.ecartType());
		assertEquals(0.816496,stat.ecartType(),0.000001);
	}
	

}
