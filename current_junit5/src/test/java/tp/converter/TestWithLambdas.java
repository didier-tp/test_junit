package tp.converter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.data.Personne;

public class TestWithLambdas {
	
	private static Logger logger = LoggerFactory.getLogger(TestWithLambdas.class);
	
	@Test
	public void testPersonneInLowercaseWithAssertAllLambdas() {
		Personne originalPers = new Personne(2L,"Jean" , "Bon" , 172.4);
		Personne p = (Personne) BasicConverter.allPartsInLowercase(originalPers);
		logger.trace("p with allPartsInLowercase = " +  p);
		assertAll("wrong personne in lowercase", 
				()-> assertEquals(2L ,p.getId(), "wrong id"),
				()-> assertEquals("jean" ,p.getPrenom(), "wrong prenom"),
				()-> assertEquals("bon" , p.getNom(), "wrong name"),
				()-> assertEquals(172.4, p.getTaille(), 0.0001 , "wrong taille")); 
	}

}
