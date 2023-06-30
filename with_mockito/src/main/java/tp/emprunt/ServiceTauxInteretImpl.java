package tp.emprunt;

public class ServiceTauxInteretImpl implements ServiceTauxInteret{
	
	/*
	 * 2ans = 24mois
	 * 5ans = 60mois
	 */

	@Override
	public double tauxCourantAnnuelBce(int nbMois) {
		if(nbMois<=24) return 2.0; //en % par an
		if(nbMois<=60) return 3.0;//en % par an
		else return 3.5;//en % par an
	}

	@Override
	public double coeffMarge() {
		return 1.01;
	}

}
