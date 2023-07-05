package tp.data;

import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPersonne {

	private static Logger logger = LoggerFactory.getLogger(TestPersonne.class);

	private Personne personne; // à tester

	// ...
	public void init() {
		personne = new Personne(1L, "jean", "Bon", 67.2 /* cm */ );
	}

	// ...
	public void test10cmDePlus() {
		// après appel de .grandir(10);
		// tester si nouvelle taille = 77.2 à 0.5cm près
	}

	// ...
	public void test5cmDePlus() {
		// après appel de .grandir(5);
		// tester si nouvelle taille = 72.2 à 0.5cm près
	}

	// ...
	public void testChangementDeNom() {
		String nomInitial = personne.getNom();// "Bon"
		// .... //changement de nom avec nouveauNom = "Aimare"
		String nouveauNom = personne.getNom();
		logger.trace("personne avec nouveau nom=" + personne);
		// .... //vérifier nouveauNom pas null
		// .... //vérifier nouveauNom valant "Aimare"
		// .... //vérifier nouveauNom différent de nomInitial
		// .... //vérifier taille toujours positive
	}

	@After
	public void tearDown() {
		logger.trace("fin d'un test ...");
	}

}
