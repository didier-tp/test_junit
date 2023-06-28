package tp.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@TestInstance(Lifecycle.PER_METHOD) by default
//a new instance of this test class per test method (ex: TestPerClassInstance@6eeade6c et @5c42d2b7)
public class TestPerMethodInstance {
	
	private static Logger logger = LoggerFactory.getLogger(TestPerMethodInstance.class);
	
	
	@BeforeAll
	public static void initBeforeAll() {
		logger.trace("TestPerMethodInstance.initBeforeAll() called (static way)" );
	}
	
	@BeforeEach
	public void initBeforeEach() {
		logger.trace("TestPerMethodInstance.initBeforeEach() called on this="+this );
	}
	
	@Test
	public void test1() {
		logger.trace("TestPerMethodInstance.test1() called on this="+this );
	}
	
	@Test
	public void test2() {
		logger.trace("TestPerMethodInstance.test2() called on this="+this );
	}

}
