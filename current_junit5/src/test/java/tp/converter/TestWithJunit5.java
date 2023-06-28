package tp.converter;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWithJunit5 {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithJunit5.class);
	
	@Test
	public void testCollectionsEquals() {
		Iterable<Integer> expectedCollection = new ArrayList<>(Arrays.asList(1, 2, 3));
		Iterable<Integer> goodCollection = new ArrayList<>(Arrays.asList(1, 2 , 3)); //
		Iterable<Integer> wrongCollection1 = new ArrayList<>(Arrays.asList(1, 2)); //manque 3
		Iterable<Integer> wrongCollection2 = new ArrayList<>(Arrays.asList(1, 2, 4)); //4 à la place de 3
		Iterable<Integer> wrongCollection3 = new ArrayList<>(Arrays.asList(3, 2, 1)); //pas même ordre
		//assertIterableEquals(expectedCollection, wrongCollection1); //not same length 
		//assertIterableEquals(expectedCollection, wrongCollection2); //not same value at index=2
		//assertIterableEquals(expectedCollection, wrongCollection3); //not same value at index=0
		assertIterableEquals(expectedCollection, goodCollection); //same length , same values
		
		/*
		Iterable<Integer> expectedCollectionB = new HashSet<>(Arrays.asList(1, 2, 3 , 5));
		Iterable<Integer> goodCollectionB = new HashSet<>(Arrays.asList(3,5, 2, 1)); //pas même ordre
		assertIterableEquals(expectedCollectionB, goodCollectionB); //ok because expectedCollectionB is a Set
		*/ 
	}
	
	@RepeatedTest(value = 3)
	public void testLance3fois() {
		double x = Math.random();
		logger.trace("testLance3fois avec x= " + x);
		assertTrue(x<=1.0);
	}
	
	@Test
	public void testAvecSupposition(){
		assumeTrue(  System.getenv("OS").startsWith("Windows") );
		//la suite du test ne sera exécutée que si os courant est Windows
		//si le test n'est pas exécuté --> même comportement que si test vide --> ok/réussi/vert 
		logger.trace("fin de testAvecSupposition executé que sur OS=Windows");
	}
	
	@Test
	public void testAvecSuppositionEtLambda(){
		assumingThat(  System.getenv("OS").startsWith("Windows") ,
				()-> {
					logger.trace("lambda dans testAvecSuppositionEtLambda executée que sur OS=Windows");
					assertTrue(new File("C:/Windows").exists(), "Repertoire Windows anormalement inexistant");
				});
		
	}

}
