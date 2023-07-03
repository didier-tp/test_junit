package tp.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyBasicLogExtension implements AfterEachCallback, BeforeEachCallback , AfterAllCallback , BeforeAllCallback{
	
	
	
	private static Logger logger = LoggerFactory.getLogger(MyBasicLogExtension.class);
	
	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		logger.info("MyBasicLogExtension, beforeEach execution of " +context.getDisplayName() );
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		logger.info("MyBasicLogExtension, afterEach execution of " +context.getDisplayName() );
		
	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		logger.info("MyBasicLogExtension, beforeAll execution of " +context.getDisplayName() );
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		logger.info("MyBasicLogExtension, afterAll execution of " +context.getDisplayName() );
	}

}
