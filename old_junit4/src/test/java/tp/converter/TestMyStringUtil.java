package tp.converter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMyStringUtil {
	
    private static Logger logger = LoggerFactory.getLogger(TestMyStringUtil.class);
    
    //private ... myStringUtil;
    private static int nbTests;
    
    
    public static void initStatic() {
    	nbTests=0;
    	//...
    }
    
 
    public void testCamelToSnakeCase() {
    	nbTests++;
    	//Tester si "leJourLePlusLong" donne "le_jour_le_plus_long" une fois converti en snake_case
    	
    }
    

    public void testSnakeToCamelCase() {
    	nbTests++;
    	//Tester si "le_jour_le_plus_long" donne "leJourLePlusLong" une fois converti en camelCase
    	
    }
    
   
    public static void afterStatic() {
    	logger.trace("nombre de tests lancés [TestMyStringUtil]=" + nbTests);
    }
	
}
