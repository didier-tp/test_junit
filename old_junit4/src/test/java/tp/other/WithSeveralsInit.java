package tp.other;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithSeveralsInit {
	
	private static Logger logger = LoggerFactory.getLogger(WithSeveralsInit.class);
	
	@Before
	public void initA() {
		logger.trace("initA");
	}
	
	@Before
	public void initB() {
		logger.trace("initB");
	}
	
	
	@Test
	public void test1() {
		logger.trace("test1");
	}
	
	@Test
	public void test2() {
		logger.trace("test2");
	}

}
