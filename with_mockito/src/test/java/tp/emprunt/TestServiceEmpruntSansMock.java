package tp.emprunt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestServiceEmpruntSansMock {
	
	private static Logger logger = LoggerFactory.getLogger(TestServiceEmpruntSansMock.class);
	
	//private ServiceEmprunt serviceEmprunt; //à tester
	private ServiceEmpruntImpl serviceEmprunt; //à tester
	
	private ServiceTauxInteret serviceTauxInteret ;//sous service en arrière plan
	private ServiceFraisEmprunt serviceFraisEmprunt ;//sous service en arrière plan

	@BeforeEach
	public void initServiceEmprunt() {
		this.serviceTauxInteret = new ServiceTauxInteretImpl();
		this.serviceFraisEmprunt = new ServiceFraisEmpruntImpl();
		serviceEmprunt = new ServiceEmpruntImpl(serviceTauxInteret,serviceFraisEmprunt);
	}
	
	@Test
	public void testMensualite() {
		//par defaut (selon ServiceTauxInteretImpl) , tauxInteretBce = 3.5% pour 120mois
		//par defaut (selon ServiceTauxInteretImpl) , coeffMarge = 1.01; 
		//et donc tauxInteretBanque = 3.5 * 1.01 = 3.535 % par an
		//et donc mensualite = 990.499
		double tauxInteretBanque = this.serviceEmprunt.tauxInteretBanque(120);
		assertEquals(3.535 , tauxInteretBanque, 0.001);	
		double mensualite= this.serviceEmprunt.mensualite(100000, 120);//120mois =10ans
		logger.trace("mensualite="+mensualite);
		assertEquals(990.499 , mensualite, 0.001);	
	}
	
	@Test
	public void testEmprunt() {
		//par defaut (selon ServiceTauxInteretImpl) , tauxInteret = 3.5% pour 120mois
		//par defaut (selon ServiceTauxInteretImpl) , coeffMarge = 1.01; 
		//et donc tauxInteretBanque = 3.5 * 1.01 = 3.535 % par an
		//et donc mensualite = 990.499
		//par defaut (selon ServiceFraisEmpruntImpl) , fraisDossier = 150.0 pour montant = 100000
		//par defaut (selon ServiceFraisEmpruntImpl) , tauxAnnuelFraisAssurance = 0.4%
		//et donc frais_assurance_mensuel= (0.4 /12 /100) * 100000 = 33.3333
		//et donc mensualiteAvecAssurance =  990.499+ 33.3333 = 1023.8323
		Emprunt emprunt= this.serviceEmprunt.calculEmprunt(100000, 120);//120mois =10ans
		logger.trace("emprunt="+emprunt);
		assertEquals(100000 , emprunt.getMontant(), 0.01);
		assertEquals(120 , emprunt.getNbMois());
		assertEquals(3.535 , emprunt.getTauxInteret(), 0.01);
		assertEquals(990.499 , emprunt.getMensualite(), 0.001);
		assertEquals(150.0 , emprunt.getFraisDossier(), 0.01);
		assertEquals(0.4 , emprunt.getTauxAssurance(), 0.01);
		assertEquals(1023.8323 , emprunt.getMensualiteAvecAssurance(), 0.0001);
		//mensualités avec et sans assurance verifiées avec site meilleurtaux.com
	}
	
	@Test
	public void testEmpruntAvecMontantEmprunteTropPetit() {
		//NB: si montant emprunt trop petit , le sous service ServiceFraisEmprunt doit remonter une exception
		// de type MontantEmprunteException
		// et le service "serviceEmprunt" doit laisser remonter cette exception 
		MontantEmprunteException montantEmprunteException = 
				assertThrows(MontantEmprunteException.class,
						()->{
							Emprunt emprunt= this.serviceEmprunt.calculEmprunt(500, 120);//120mois =10ans
						});
		
		logger.trace("montantEmprunteException="+montantEmprunteException.getMessage());
	}
}
