package tp.emprunt;

public interface ServiceEmprunt {
	double mensualite(double montant,int nbMois);
	Emprunt calculEmprunt(double montant,int nbMois)throws MontantEmprunteException;
}
