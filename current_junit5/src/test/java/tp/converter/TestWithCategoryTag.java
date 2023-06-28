package tp.converter;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TestWithCategoryTag {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithCategoryTag.class);
	
	@Test
	@Tag("SlowTests")
	public void testA() {
		logger.trace("slow testA");
	}
	
	@Test
	@Tag("FastTests")
	public void testB() {
		logger.trace("fast testB");
	}
	

	@Test
	@Tag("FastTests")	@Tag("ImportantTests")
	public void testC() {
		logger.trace("important fast testC");
	}
	
	@Test
	@Tag("SlowTests")	@Tag("SecondaryTests")
	public void testD() {
		logger.trace("secondary slow testD");
	}

}
