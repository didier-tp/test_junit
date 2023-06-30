package tp.encadreur;

public class BasicSuffixeur  implements Suffixeur{
	
	private CustomSeparator customSeparator=null;

	@Override
	public String suffixer(String chaine, String suffixe) {
		String separator = this.customSeparator!=null
		           ?this.customSeparator.getSeparator()
		           :CustomSeparator.DEFAULT_SEPARATOR;
		return chaine+separator+suffixe;
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
