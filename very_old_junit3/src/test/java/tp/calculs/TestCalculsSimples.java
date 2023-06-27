package tp.calculs;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestCalculsSimples extends TestCase {
	
	public static CalculsSimples calculsSimples;
	
	//pas d'optimisation simple pour static en JUnit3
	//Tout de meme cette possibilité:
	public static Test suite() {
	    return new TestSetup(new TestSuite(TestCalculsSimples.class)) {

	        protected void setUp() throws Exception {
	            System.out.println("Global setUp ");
	            myGlobalSetUp();
	        }
	        protected void tearDown() throws Exception {
	            System.out.println("Global tearDown ");
	            myGlobalTearDown();
	        }
	    };
	}
	
	public static void myGlobalSetUp() {
		System.out.println("myGlobalSetUp() in JUnit3 TestSetup/TestSuite called on TestCalculsSimples");
		calculsSimples= new CalculsSimples();
	}
	
	public static void myGlobalTearDown() {
		System.out.println("myGlobalTearDown() in JUnit3 TestSetup/TestSuite called on TestCalculsSimples");
	}
	
	/*
	public void setUp() {
		System.out.println("setUp() of JUnit3 called on " + this);
		//calculsSimples= new CalculsSimples();
	}
	
	public void tearDown() {
		System.out.println("tearDown() of JUnit3 called on " + this);
	}
	*/
	
	public void testAddInt() {
		int res = calculsSimples.addInt(5, 6);
		System.out.println("testAddInt() , res="+res);
		//assertEquals(11, res);
		assertTrue(11==res);
	}
	
	public void testAddDouble() {
		double res = calculsSimples.addDouble(5.0, 6.0);
		System.out.println("testAddDouble() , res="+res);
		assertEquals(11, res,0.000001);
	}
	
	
	
	

}
