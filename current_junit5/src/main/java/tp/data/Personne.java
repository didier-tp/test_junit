package tp.data;

import java.util.Objects;

public class Personne {
	private Long id;
	private String prenom;
	private String nom;
	private Double taille; //en cm (ex: 172.4)
	
	public Personne() {
		super();
	}

	public Personne(Long id, String prenom, String nom, Double taille) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.taille = taille;
	}
	
	public void grandir(int augmentationEnCm) {
		this.taille += augmentationEnCm;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", taille=" + taille + "]";
	}
	
	/*
	@Override
	public int hashCode() {
		return Objects.hash(id, nom, prenom, taille);
	}
	*/

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id) && Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom)
				&& Objects.equals(taille, other.taille);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getTaille() {
		return taille;
	}
	public void setTaille(Double taille) {
		this.taille = taille;
	}
	
	
	
}
