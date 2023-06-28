package tp.converter;

import java.util.List;
import java.util.Map;

public interface Translator {
	String translate(String s);
	Map<String,String> translate(List<String> liste);
}
