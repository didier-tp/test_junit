package tp.calculs;

public class CalculsFinanciers {
	
	public double mensualite(double montant, int nbMois, double tauxInteretAnnuelEnPourcentage) {
		double tauxInteretMensuelBanque = (tauxInteretAnnuelEnPourcentage / 12) / 100;
		double mensualite = ( montant * tauxInteretMensuelBanque ) / 
				             (1 - Math.pow(1+tauxInteretMensuelBanque,-nbMois) );
		return mensualite;
	}

}
