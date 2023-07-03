package tp.other;

public class DecorateWithPrefix implements IDecorate{
	@Override
	public String decorate(String inputString) {
		return ">>>"+inputString;
	}
}
