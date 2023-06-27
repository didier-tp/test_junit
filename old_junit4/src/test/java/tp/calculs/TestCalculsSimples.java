package tp.calculs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCalculsSimples {
	
	private static Logger logger = LoggerFactory.getLogger(TestCalculsSimples.class);
	
	public static CalculsSimples calculsSimples;
	
	@BeforeClass //with static init method
	public static void initBeforeClass() {
		logger.trace("static initBeforeClass() with junit4 @BeforeClass called on TestCalculsSimples");
		calculsSimples= new CalculsSimples();
	}
	
	@Test
	public void testAddInt() {
		int res = calculsSimples.addInt(5, 6);
		logger.trace("testAddInt() , res="+res);
		//assertEquals(11, res);
		assertTrue(11==res);
	}
	
	@Test
	public void testAddDouble() {
		double res = calculsSimples.addDouble(5.0, 6.0);
		logger.trace("testAddDouble() , res="+res);
		assertEquals(11, res,0.000001);
	}
	
	@AfterClass
	public static void cleanAfterClass() {
		logger.trace("static cleanAfterClass() with JUnit4 @AfterClass called on TestCalculsSimples");
	}

}
