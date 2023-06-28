package tp.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractTranslator implements Translator {


	@Override
	public Map<String,String> translate(List<String> liste) {
		Map<String,String> translatedMap = new HashMap<>();
		for(String s : liste) {
			translatedMap.put(s,this.translate(s));
		}
		return translatedMap;
	}

}
