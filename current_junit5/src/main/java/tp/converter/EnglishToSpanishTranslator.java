package tp.converter;

public class EnglishToSpanishTranslator extends AbstractTranslator {

	@Override
	public String translate(String s) {
		switch(s) {
		  case "translate" : return "traducir";
		  case "green" : return "verde";
		  case "red" : return "rojo";
		  default : return null;
		}
	}

	

}
