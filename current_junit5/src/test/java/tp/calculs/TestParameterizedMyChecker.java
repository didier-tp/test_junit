package tp.calculs;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestParameterizedMyChecker {
	
	private static Logger logger = LoggerFactory.getLogger(TestParameterizedMyChecker.class);
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5 , -3, 15} ) // 5 odd numbers
	public void testOddNumbersWithChecker(int number) {
	      logger.trace("for number=" + number  + " MyChecker.isOdd=" + MyChecker.isOdd(number)  );
	      assertTrue(MyChecker.isOdd(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 4, 6 , -2, 16} ) // 5 even numbers
	public void testEvenNumbersWithChecker(int number) {
	      logger.trace("for number=" + number  + " MyChecker.isEven=" + MyChecker.isEven(number)  );
	      assertTrue(MyChecker.isEven(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5 , 23, 29} ) // 5 prime numbers
	public void testPrimeNumbersWithChecker(int number) {
	      logger.trace("for number=" + number  + " MyChecker.isPrimeNumber=" + MyChecker.isPrimeNumber(number)  );
	      assertTrue(MyChecker.isPrimeNumber(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 4, 6 , 8, 9 , 10} ) // 5 no prime numbers
	public void testNoPrimeNumbersWithChecker(int number) {
	      logger.trace("for number=" + number  + " MyChecker.isPrimeNumber=" + MyChecker.isPrimeNumber(number)  );
	      assertFalse(MyChecker.isPrimeNumber(number));
	}
	
}
