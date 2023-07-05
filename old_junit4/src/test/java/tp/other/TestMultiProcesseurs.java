package tp.other;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMultiProcesseurs {
	
	private static Logger logger = LoggerFactory.getLogger(TestMultiProcesseurs.class);
	
	
	@Test
	public void testMultiProcesseurs(){
		int nbProcesseurs = Runtime.getRuntime().availableProcessors();
		logger.trace("nbProcesseurs="+nbProcesseurs);
		
		//supposition/assumption qui va bien
		//...
		logger.trace("nbProcesseurs au moins égal à 2");
		logger.trace("i3 ou i5 ou i7 ou autres");
		
		//supposition/assumption qui va bien
		//...
		logger.trace("nbProcesseurs au moins égal à 4");
		logger.trace("i5 ou i7 ou autres");
		try {
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			Future<String> future = executorService.submit(() -> "Hello World");
			// some operations
			String result = future.get();
			logger.trace("result="+result);
			assertEquals("Hello World",result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//supposition/assumption qui va bien
		//...
		logger.trace("nbProcesseurs au moins égal à 8");
		logger.trace("i7 ou autres");
		
		//supposition/assumption qui va bien
		//...
		logger.trace("nbProcesseurs au moins égal à 10");
		logger.trace("i9 ou autres");
	}

}
