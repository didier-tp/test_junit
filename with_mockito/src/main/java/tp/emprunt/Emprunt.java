package tp.emprunt;

public class Emprunt {
	private Double montant;
	private int nbMois;//ex: 24mois pour 2ans ,60 mois pour 5ans , 120mois pour 10ans
	private Double tauxInteret;//en % par an
	private Double tauxAssurance;//en % par an
	private Double fraisDossier;//fixe , selon montant emprunté
	private Double mensualite;//constante (même valeur chaque mois)
	private Double mensualiteAvecAssurance;//**
	
	public Emprunt(Double montant, int nbMois) {
		this.montant = montant;
		this.nbMois = nbMois;
	}
	
	public Emprunt() {
		this(0.0,0);
	}
	
	@Override
	public String toString() {
		return "Emprunt [montant=" + montant + ", nbMois=" + nbMois + ", tauxInteret=" + tauxInteret
				+ ", tauxAssurance=" + tauxAssurance + ", fraisDossier=" + fraisDossier + ", mensualite=" + mensualite
				+ ", mensualiteAvecAssurance=" + mensualiteAvecAssurance + "]";
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public int getNbMois() {
		return nbMois;
	}
	public void setNbMois(int nbMois) {
		this.nbMois = nbMois;
	}
	public Double getTauxInteret() {
		return tauxInteret;
	}
	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	public Double getTauxAssurance() {
		return tauxAssurance;
	}
	public void setTauxAssurance(Double tauxAssurance) {
		this.tauxAssurance = tauxAssurance;
	}
	public Double getFraisDossier() {
		return fraisDossier;
	}
	public void setFraisDossier(Double fraisDossier) {
		this.fraisDossier = fraisDossier;
	}
	public Double getMensualite() {
		return mensualite;
	}
	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}
	public Double getMensualiteAvecAssurance() {
		return mensualiteAvecAssurance;
	}
	public void setMensualiteAvecAssurance(Double mensualiteAvecAssurance) {
		this.mensualiteAvecAssurance = mensualiteAvecAssurance;
	}
	
	
}
