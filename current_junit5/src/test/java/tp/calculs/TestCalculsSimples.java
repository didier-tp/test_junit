package tp.calculs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCalculsSimples {
	
	private static Logger logger = LoggerFactory.getLogger(TestCalculsSimples.class);
	
	public static CalculsSimples calculsSimples;
	
	@BeforeAll //with static init method
	public static void initBeforeAll() {
		logger.trace("static initBeforeAll() with JUnit5 @BeforeAll called on TestCalculsSimples");
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
	
	@AfterAll
	public static void cleanAfterAll() {
		logger.trace("static cleanAfterAll() with JUnit5 @AfterAll called on TestCalculsSimples");
	}

}
