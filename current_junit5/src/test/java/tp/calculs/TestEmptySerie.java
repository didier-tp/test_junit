package tp.calculs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEmptySerie {
	
	private static Logger logger = LoggerFactory.getLogger(TestEmptySerie.class);
	
	private Serie serie;
	
	@BeforeEach
	public void setUpBeforeEach() {
		logger.trace("setUpBeforeEach() with JUnit5 @BeforeEach called on " + this);
		serie= new Serie();
	}
	
	@AfterEach
	public void tearDownAfterEach() {
		logger.trace("tearDownAfterEach()  with JUnit5 @AfterEach called on " + this);
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
