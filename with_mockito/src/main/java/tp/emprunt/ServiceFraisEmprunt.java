package tp.emprunt;

public interface ServiceFraisEmprunt {
	double fraisDossierSelonMontant(double montant) throws MontantEmprunteException;
	double tauxAnnuelFraisAssurance();//ex: 0.4%
}
