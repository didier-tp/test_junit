package tp.emprunt;

public interface ServiceTauxInteret {
	double tauxCourantAnnuelBce(int nbMois);  //ex: 2% par an pour 24mois
	double coeffMarge() ; //ex: 1.01 pour tauxBanque = tauxBce * 1.01
}
