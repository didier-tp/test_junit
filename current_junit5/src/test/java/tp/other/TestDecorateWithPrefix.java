package tp.other;

public class TestDecorateWithPrefix implements IDecorateContract{
	
	@Override
	public IDecorate create() {
		return new DecorateWithPrefix();
	}
	
	//AVEC DECLENCHEMENT AUTOMATIQUE du @Test postcondition() defini dans l'interface IDecorateContract


}
