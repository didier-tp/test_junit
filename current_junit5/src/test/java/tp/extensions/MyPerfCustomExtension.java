package tp.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//NB1: just one instance of this class 
//(don't use attributes but context.getStore(Namespace.GLOBAL or SPECIFIC_NAMESPACE))
//NB2: JUnit5 Extensions seems to be rather slow (may be aop/weaver) ...
public class MyPerfCustomExtension implements AfterEachCallback, BeforeEachCallback {
	
	private static final Namespace NAMESPACE = Namespace.create("tp", "extensions", "MyPerfCustomExtension");
	
	private static Logger logger = LoggerFactory.getLogger(MyPerfCustomExtension.class);
	
	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		long startTime =System.nanoTime();
		logger.info("MyPerfCustomExtension, before execution of " +context.getDisplayName()
		            + " at startTime=" +startTime );
		Namespace methodNamespace = NAMESPACE.append(context.getDisplayName());
		context.getStore(methodNamespace).put("startTime", startTime);
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		long endTime = System.nanoTime();
		Namespace methodNamespace = NAMESPACE.append(context.getDisplayName());
		long startTime = (Long) context.getStore(methodNamespace).get("startTime");
    	logger.info("MyPerfCustomExtension, after execution of " +context.getDisplayName() 
    	            + " execDuration (ms) without good precision = " + ((double)(endTime - startTime)/1000000)
    	            + " startTime=" +startTime  + " endTime=" +endTime );
		
	}

}
