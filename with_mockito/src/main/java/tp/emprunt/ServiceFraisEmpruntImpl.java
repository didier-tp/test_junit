package tp.emprunt;

public class ServiceFraisEmpruntImpl implements ServiceFraisEmprunt {

	@Override
	public double fraisDossierSelonMontant(double montant)throws MontantEmprunteException {
		if(montant<1000) 
			throw new MontantEmprunteException("montant emprunte trop petit , minimum=1000");
		if(montant<=3000) return 50.0;
		if(montant<=30000) return 100.0;
		else return 150.0;
	}

	@Override
	public double tauxAnnuelFraisAssurance() {
		return 0.4;//en % par an
	}

}
