package tp.other;

public class DecorateWithSuffix implements IDecorate{
	@Override
	public String decorate(String inputString) {
		return inputString+"<<<";
	}
}
