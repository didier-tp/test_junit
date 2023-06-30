package tp.encadreur;

public interface Suffixeur{
	public String suffixer(String chaine,String suffixe);
	public void setCustomSeparator(CustomSeparator cs);//optional
	public CustomSeparator getCustomSeparator();
}
