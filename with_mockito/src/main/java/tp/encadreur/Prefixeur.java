package tp.encadreur;

public interface Prefixeur {
	public String prefixer(String chaine,String prefixe);
	public void setCustomSeparator(CustomSeparator cs);//optional
	public CustomSeparator getCustomSeparator();
}
