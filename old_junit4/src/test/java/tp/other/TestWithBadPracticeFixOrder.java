package tp.other;

import org.apache.logging.log4j.core.config.Order;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//proche de par défaut selon version
public class TestWithBadPracticeFixOrder {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithBadPracticeFixOrder.class);
	
	
	@Test
	public void testB() {
		logger.trace("testB");
	}
	
	@Test
	public void testA() {
		logger.trace("testA");
	}
	

	@Test
	public void testC() {
		logger.trace("testC");
	}


}
