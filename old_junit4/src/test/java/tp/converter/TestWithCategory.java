package tp.converter;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.converter.categories.FastTests;
import tp.converter.categories.ImportantTests;
import tp.converter.categories.SecondaryTests;
import tp.converter.categories.SlowTests;

public class TestWithCategory {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithCategory.class);
	
	@Test
	@Category(SlowTests.class)
	public void testA() {
		logger.trace("slow testA");
	}
	
	@Test
	@Category(FastTests.class)
	public void testB() {
		logger.trace("fast testB");
	}
	
	@Test
	@Category({FastTests.class , ImportantTests.class})
	public void testC() {
		logger.trace("important fast testC");
	}
	
	@Test
	@Category({SlowTests.class , SecondaryTests.class})
	public void testD() {
		logger.trace("secondary slow testD");
	}

}
