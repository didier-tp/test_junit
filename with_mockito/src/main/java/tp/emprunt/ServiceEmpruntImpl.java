package tp.emprunt;

public class ServiceEmpruntImpl implements ServiceEmprunt {
	
	
	
	private ServiceTauxInteret serviceTauxInteret;
	
	private ServiceFraisEmprunt serviceFraisEmprunt;
	
	
    //constructeur pour injection de dépendance
	public ServiceEmpruntImpl( ServiceTauxInteret serviceTauxInteret , ServiceFraisEmprunt serviceFraisEmprunt) {
		this.serviceFraisEmprunt = serviceFraisEmprunt;
		this.serviceTauxInteret = serviceTauxInteret;
	}
	
	
	public ServiceEmpruntImpl() {
		this(null,null);
	}
	
	public double tauxInteretBanque(int nbMois) {
		double tauxInteretAnnuelBce = this.serviceTauxInteret.tauxCourantAnnuelBce(nbMois); //en %
		double tauxInteretAnnuelBanque = tauxInteretAnnuelBce * this.serviceTauxInteret.coeffMarge(); //en %
		return tauxInteretAnnuelBanque;
	}


	@Override
	public double mensualite(double montant, int nbMois) {
		double tauxInteretAnnuelBanque = this.tauxInteretBanque(nbMois); //en % par an
		double tauxInteretMensuelBanque = (tauxInteretAnnuelBanque / 12) / 100;
		double mensualite = ( montant * tauxInteretMensuelBanque ) / 
				             (1 - Math.pow(1+tauxInteretMensuelBanque,-nbMois) );
		return mensualite;
	}


	@Override
	public Emprunt calculEmprunt(double montant, int nbMois) {
		Emprunt emprunt = new Emprunt(montant, nbMois);
		emprunt.setTauxInteret(this.tauxInteretBanque(nbMois));//en % par an
		emprunt.setFraisDossier(this.serviceFraisEmprunt.fraisDossierSelonMontant(montant));//fixe
		emprunt.setTauxAssurance(this.serviceFraisEmprunt.tauxAnnuelFraisAssurance()); //en % par an
		emprunt.setMensualite(this.mensualite(montant, nbMois));
		//calcul mensualiteAssurance:
		double tauxMensuelAssurance = emprunt.getTauxAssurance() / 12 /100;
		double mensualiteAssurance = montant * tauxMensuelAssurance;
		emprunt.setMensualiteAvecAssurance(emprunt.getMensualite()+mensualiteAssurance);
		return emprunt;
	}

}
