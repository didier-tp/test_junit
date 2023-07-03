package tp.calculs;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class TestParameterizedMyChecker {
	
	private static Logger logger = LoggerFactory.getLogger(TestParameterizedMyChecker.class);
	
	 private int inputNumber;
	 private boolean shouldBeEven;
	 private boolean shouldBePrime;

	//constructor params should be the sames as parameters set 
	public TestParameterizedMyChecker(Integer inputNumber, Boolean shouldBeEven , Boolean shouldBePrime){
		this.inputNumber = inputNumber;
		this.shouldBeEven = shouldBeEven;
		this.shouldBePrime = shouldBePrime;
		
		//éventuelle variante au constructeur récupérateur de paramètres:
		//des annotations @Parameter(0), @Parameter(1) , @Parameter(2) placées sur les attributs
		//inputNumber , shouldBeEven et shouldBePrime
	}
	
	//parameters set :
	 @Parameterized.Parameters
	   public static Collection<?> evenOrPrimeNumbers() {
		 //return collection of { inputNumber , shouldBeEven , shouldBePrime}
	      return Arrays.asList(new Object[][] {
	    	 { 1, false, true },
	         { 2, true, true },
	         { 3, false, true },
	         { 4, true, false },
	         { 5, false, true },
	         { 6, true, false },
	         { 19, false, true },
	         { 22, true , false },
	         { 23, false, true }
	      });
	   }

	   // This test will run n times since we have n values of parameters_set defined
	   @Test
	   public void testEvenOddPrimeNumberChecker() {
	      logger.trace("Parameterized values: [inputNumber=" + this.inputNumber 
	    		       + ",shouldBeEven=" + this.shouldBeEven 
	    		       + ",shouldBePrime=" + this.shouldBePrime + "]");
	      logger.trace("for inputNumber=" + this.inputNumber 
   		       + " MyChecker.isEven=" + MyChecker.isEven(inputNumber) 
   		       + " MyChecker.isPrimeNumber=" + MyChecker.isPrimeNumber(inputNumber) );
	      assertTrue(MyChecker.isEven(inputNumber)==this.shouldBeEven);
	      assertTrue(MyChecker.isOdd(inputNumber)!=this.shouldBeEven);
	      assertTrue(MyChecker.isPrimeNumber(inputNumber)==this.shouldBePrime);
	   }
}
