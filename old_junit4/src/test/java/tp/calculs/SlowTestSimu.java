package tp.calculs;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.converter.categories.SlowTests;

@Category(SlowTests.class)
public class SlowTestSimu {
	private static Logger logger = LoggerFactory.getLogger(SlowTestSimu.class);
	
	@Test
	public void testLent(){
		try {
			Thread.sleep(400); //400ms
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.trace("testLent (400ms)");
	}
	
	
	
}
