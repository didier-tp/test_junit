package tp.encadreur;

public class BasicPrefixeur implements Prefixeur{
	
	private CustomSeparator customSeparator=null;
	
	
    //constructeur pour injection de dépendance
	public BasicPrefixeur(CustomSeparator customSeparator) {
		this.customSeparator = customSeparator;
	}
	
	
    //par défaut sans séparateur
	public BasicPrefixeur() {
		this(null);
	}



	@Override
	public String prefixer(String chaine, String prefixe) {
		String separator = this.customSeparator!=null
				           ?this.customSeparator.getSeparator()
				           :CustomSeparator.DEFAULT_SEPARATOR;
		return prefixe+separator+chaine;
	}

	@Override
	public void setCustomSeparator(CustomSeparator cs) {
		this.customSeparator=cs;
	}

	@Override
	public CustomSeparator getCustomSeparator() {
		return this.customSeparator;
	}

}
