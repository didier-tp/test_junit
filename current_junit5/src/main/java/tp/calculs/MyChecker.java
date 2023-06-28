package tp.calculs;

public class MyChecker {
	
	public static boolean isPrimeNumber(final int primeNumber) {
	      for (int i = 2; i <= (primeNumber / 2); i++) {
	         if (primeNumber % i == 0) {
	            return false;
	         }
	      }
	      return true;
	   }
	
	
	public static boolean isEven(final int number) {
		return (number % 2)==0 ;//pair
	}
	
	public static boolean isOdd(final int number) {
		return (number % 2)!=0 ;//impair
	}

}
