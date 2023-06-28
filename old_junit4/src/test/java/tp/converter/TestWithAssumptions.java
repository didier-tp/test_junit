package tp.converter;

import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWithAssumptions {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithAssumptions.class);
	
	private String javaVersion;//ex: 17.0.6
	private int javaMajorVersion; //ex: 17
	
	@Before() //or @BeforeClass
	public void initBefore() {
		this.javaVersion = System.getProperty("java.version");
		this.javaMajorVersion=Integer.parseInt( javaVersion.split("\\.")[0] );
		logger.trace("javaVersion="+javaVersion + " javaMajorVersion=" + javaMajorVersion);
	}
	
	
	@Test()
	public void test1() {
		logger.trace("first step of test1");
		assumeTrue(this.javaMajorVersion>=11);
		logger.trace("other steps of test1 if javaVersion >= 11");
		assumeTrue(this.javaMajorVersion>=17);
		logger.trace("other steps of test1 if javaVersion >= 17");
		assumeTrue(this.javaMajorVersion>=22);
		logger.trace("other steps of test1 if javaVersion >= 22");
	}

}
