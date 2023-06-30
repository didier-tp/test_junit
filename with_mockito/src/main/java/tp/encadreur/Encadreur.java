package tp.encadreur;

public class Encadreur implements Suffixeur, Prefixeur{
	
	private Prefixeur prefixeur ;
	private Suffixeur suffixeur ;
	private CustomSeparator customCommonSeparator=null;//separateur commun par défaut pour prefixeur et suffixeur  

	//constructeur avec injection de dépendances
	public Encadreur(Prefixeur prefixeur, Suffixeur suffixeur) {
		super();
		this.prefixeur = prefixeur;
		this.suffixeur = suffixeur;
	}
	
	//constructeur avec injection par défaut
	public Encadreur() {
		this(new BasicPrefixeur(), new BasicSuffixeur());
	}
	
	public String encadrer(String chaine,String prefixe,String suffixe) {
		return this.suffixeur.suffixer(this.prefixeur.prefixer(chaine, prefixe), suffixe);
	}

	@Override
	public String prefixer(String chaine, String prefixe) {
		return this.prefixeur.prefixer(chaine, prefixe);
	}

	@Override
	public String suffixer(String chaine, String suffixe) {
		return this.suffixeur.suffixer(chaine, suffixe);
	}

	@Override
	public void setCustomSeparator(CustomSeparator cs) {
		this.customCommonSeparator=cs;
		if(this.prefixeur.getCustomSeparator()==null) 
			this.prefixeur.setCustomSeparator(cs);
		if(this.suffixeur.getCustomSeparator()==null) 
			this.suffixeur.setCustomSeparator(cs);
	}

	@Override
	public CustomSeparator getCustomSeparator() {
		return this.customCommonSeparator;
	}
	
	

}
