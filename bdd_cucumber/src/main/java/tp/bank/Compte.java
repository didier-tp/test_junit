package tp.bank;

public class Compte {
    public enum Status { OK, A_DECOUVERT }
    public static double DECOUVERT_AUTORISE = -300.0;
    
	private Long numero;
	private String label;
	private Double solde;

	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	
	public Compte() {
		this(null,null,0.0);
	}
	
	public void crediter(double montant) {
		this.solde += montant;
	}
	
	public void debiter(double montant) {
		//this.solde -= montant;
		
		double nouveauSolde = this.solde -montant;
		if(nouveauSolde >= DECOUVERT_AUTORISE)
			this.solde = nouveauSolde;
		else throw new RuntimeException("decouvert trop important pas accepté");
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde  + "]";
	}

	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Status getStatut() {
		if(this.solde>=0)
		   return Status.OK;
		else
		   return Status.A_DECOUVERT;
	}
	


}
