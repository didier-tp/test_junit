package tp.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import tp.calculs.TestParameterizedMyChecker;
import tp.converter.WrongTests;

public class MyTestRunner {
	
	public static void main(String[] args) {
		runThisTest(TestParameterizedMyChecker.class);
		runThisTest(WrongTests.class);
	}
	
	public static void runThisTest(Class<?> testClass) {
		System.out.println("runThisTest --> " + testClass.getSimpleName());
		Result result = JUnitCore.runClasses(testClass);
	    for (Failure failure : result.getFailures()) {
	         System.err.println("\t" +failure.toString());
	      }
	    System.out.println("\t wasSuccessful=" + result.wasSuccessful());
	}

}
