package tp.calculs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEmptySerie /* extends TestCase */ {
	
	private static Logger logger = LoggerFactory.getLogger(TestEmptySerie.class);
	
	private Serie serie;
	
	@Before
	public void setUpBefore() {
		logger.trace("setUpBefore() with JUnit4 @Before called on " + this);
		serie= new Serie();
	}
	
	@After
	public void tearDownAfter() {
		logger.trace("tearDownAfter()  with JUnit4 @After called on " + this);
	}
	
	@Test
	public void testComputeStats() {
		Stat stat = serie.computeStats();
		logger.trace("testComputeStats() , stat="+stat);
		assertTrue(stat.size==0);
		assertEquals(0.0,stat.sum,0.000001);
		assertEquals(Double.NaN,stat.average,0.000001);
		assertEquals(Double.NaN,stat.variance,0.000001);
	}
	
	@Test
	public void testEcartType() {
		Stat stat = serie.computeStats();
		logger.trace("testEcartType ..., ecartType = " + stat.ecartType());
		assertEquals(Double.NaN,stat.ecartType(),0.000001);
	}
	

}
