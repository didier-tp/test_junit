package tp.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(Lifecycle.PER_CLASS)
//a single reused and reinitialized instance of this test class for all test methods (ex: TestPerClassInstance@aeab9a1)
public class TestPerClassInstance {
	
	private static Logger logger = LoggerFactory.getLogger(TestPerClassInstance.class);
	
	@BeforeAll
	public void initBeforeAll() {
		logger.trace("TestPerMethodInstance.initBeforeAll() called (no static way) on this="+this );
	}
	
	@BeforeEach
	public void initBeforeEach() {
		logger.trace("TestPerClassInstance.initBeforeEach() called on this="+this );
	}
	
	@Test
	public void test1() {
		logger.trace("TestPerClassInstance.test1() called on this="+this );
	}
	
	@Test
	public void test2() {
		logger.trace("TestPerClassInstance.test2() called on this="+this );
	}


}
