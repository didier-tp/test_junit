package tp.other;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.other.rules.MyPerfCustomRule;

public class TestWithTimeoutRule {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithTimeoutRule.class);
	
	@Rule	    
    public Timeout globalTimeout = new Timeout(40, TimeUnit.MILLISECONDS);
	/*
	 NB: org.junit.rules.Timeout is a predefined Junit4 Rule 
	     When applied/declared this rule will be used on each test method of this test class
	     A rule is like :
	        - an interceptor on test method
	        - an compact/reusable way to add an equivalent of @Before and @After code
	 */
	
	@Rule
	public MyPerfCustomRule myPerfCustomRule = new MyPerfCustomRule();
	
	//NB: il existe également @ClassRule en JUnit4
	
	@Test
	public void fastTest() {
		try {
			Thread.sleep(20);//ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void tooSlowTest() {
		try {
			Thread.sleep(60);//not ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

}
