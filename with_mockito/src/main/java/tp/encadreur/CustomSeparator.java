package tp.encadreur;

public interface CustomSeparator {
	public static String DEFAULT_SEPARATOR="";
	public void setSeparator(String separator); //ex "_" or " " or "-"
	public void setRepeatedSeparator(String separator,int n); //ex: 2 "_" de suite
	public String getSeparator();
	public int getSeparatorLength();
}
