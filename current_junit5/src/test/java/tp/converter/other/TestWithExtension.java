package tp.converter.other;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.extensions.MyPerfCustomExtension;

@ExtendWith(MyPerfCustomExtension.class)
public class TestWithExtension {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithExtension.class);
	
	/*
	 NB: Junit4 Rule can be replaced by JUnit5 extension
	 */
	
	
	@Test
	public void fastTest() {
		try {
			Thread.sleep(20);//ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	//@Ignore
	public void tooSlowTest() {
		try {
			Thread.sleep(60);//ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

}
