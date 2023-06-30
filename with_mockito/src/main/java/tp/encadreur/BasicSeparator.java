package tp.encadreur;

public class BasicSeparator  implements CustomSeparator{
	
	private String separator = CustomSeparator.DEFAULT_SEPARATOR;

	@Override
	public void setSeparator(String separator) {
		this.separator=separator;
	}

	@Override
	public void setRepeatedSeparator(String separator, int n) {
		this.separator=separator.repeat(n);
	}

	@Override
	public String getSeparator() {
		return this.separator;
	}

	@Override
	public int getSeparatorLength() {
		return this.separator.length();
	}
}
