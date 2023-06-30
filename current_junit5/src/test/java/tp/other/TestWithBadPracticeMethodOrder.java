package tp.other;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 NB: Fixer de manière rigide l'ordre d'excécution des méthodes de Test
     est une MAUVAISE PRATIQUE pour les TESTS UNITAIRES
     est NEANMOINS ENVISAGEABLE au sein d'un TEST d'INTEGRATION
 */

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class TestWithBadPracticeMethodOrder {
	
	private int compteur=-1;
	
	private static Logger logger = LoggerFactory.getLogger(TestWithBadPracticeMethodOrder.class);
	
	
	@Order(2)
	@RepeatedTest(4)
	public void testIncrementCompteur() {
		logger.trace("testIncrementCompteur: compteur=" + this.compteur);
		assertTrue(compteur>=0);
		this.compteur++;
	}
	
	@Test
	@Order(1)
	public void testInitCompteur() {
		logger.trace("testInitCompteur: compteur=" + this.compteur);
		assertTrue(compteur==-1);
		this.compteur=0;
	}
	

	@Test
	@Order(3)
	public void testIncrementedCompteur() {
		logger.trace("testIncrementedCompteur: compteur=" + this.compteur);
		assertTrue(compteur==4);
	}


}
