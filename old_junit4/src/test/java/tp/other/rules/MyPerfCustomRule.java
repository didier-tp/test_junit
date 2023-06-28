package tp.other.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPerfCustomRule implements TestRule {
	
	private static Logger logger = LoggerFactory.getLogger(MyPerfCustomRule.class);
	

	@Override
	public Statement apply(Statement base, Description description) {
        return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                	//BEFORE
                	logger.info("MyPerfCustomRule, before execution of " +description.getMethodName());
            		long startTime = System.nanoTime();
            		
                	try {	
                		base.evaluate(); //TEST EXECUTION
                	} catch(Exception ex){
                		logger.error("MyPerfCustomRule, exception after execution of " +description.getMethodName()
                		             + " " + ex.getMessage());
                	}finally {
                		//AFTER (bad or good test)
                    	long endTime = System.nanoTime();
                    	logger.info("MyPerfCustomRule, after execution of " +description.getMethodName()
                    	            + " execDuration (ms)= " + ((double)(endTime - startTime)/1000000));
                    }
            	}
            };
	}

}
