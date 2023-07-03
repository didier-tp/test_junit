package tp.other;

public class TestDecorateWithSuffix implements IDecorateContract{
	
	@Override
	public IDecorate create() {
		return new DecorateWithSuffix();
	}
	
	//AVEC DECLENCHEMENT AUTOMATIQUE du @Test postcondition() defini dans l'interface IDecorateContract

}
