package tp.data;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListePersonnes {

	private static Logger logger = LoggerFactory.getLogger(TestListePersonnes.class);

	private List<Personne> personnes; // à tester

	
	public void init() {
		personnes = Arrays.asList( 
				   new Personne(1L, "jean", "Bon", 167.2  ) ,
				   new Personne(4L, "axelle", "Aire", 161.2  ),
				   new Personne(3L, "joe", "Dalton", 152.2  ),
				   new Personne(2L, "lucky", "Lucke", 182.2  )
				);
	}

	
	public void testPersonnesTrieesSelonTaille() {
		//1. trier les personnes selon leurs tailles croissantes
		List<Personne> personnesTriees = 
				this.personnes.stream()
				.sorted( (p1,p2)-> (int)(p1.getTaille() - p2.getTaille()))
				.collect(Collectors.toList());
		logger.trace("personnesTriees="+personnesTriees);
		
		//2. tester via quelques assertions si la liste triée:
		//  comporte les éléments attendus dans le bon ordre
		
	}
	
	
	public void testPersonnesFiltreesSelonTaille() {
			//1. filtrer les personnes selon leurs tailles pas trop grandes (on excluera si >= 165.0 )
		List<Personne> personnesFiltrees = 
				this.personnes.stream()
				.filter( p-> p.getTaille() <= 165.0 )
				.collect(Collectors.toList());
		logger.trace("personnesFiltrees="+personnesFiltrees);
		
		//2. tester via quelques assertions si la liste filtrée:
		//  comporte les éléments attendus 
		//  comporte 2 éléments
	}
		

}
