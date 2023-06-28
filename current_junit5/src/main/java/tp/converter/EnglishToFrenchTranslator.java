package tp.converter;

public class EnglishToFrenchTranslator extends AbstractTranslator {

	@Override
	public String translate(String s) {
		switch(s) {
		  case "translate" : return "traduire";
		  case "green" : return "vert";
		  case "red" : return "rouge";
		  default : return null;
		}
	}

	

}
