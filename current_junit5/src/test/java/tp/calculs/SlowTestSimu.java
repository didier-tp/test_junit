package tp.calculs;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag("SlowTests")
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
