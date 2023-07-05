package tp.converter;

public class MyStringUtil {
	
	//NB: cette méthode ultra simple aurait pu être déclarée static
	//MAIS ELLE NE L'EST PAS ET IL FAUT FAIRE AVEC ...
	public String snakeToCamelCase(String str)
    { 
        // Convert to StringBuilder
        StringBuilder builder
            = new StringBuilder(str);
 
        // Traverse the string character by
        // character and remove underscore
        // and capitalize next letter
        for (int i = 0; i < builder.length(); i++) {
 
            // Check char is underscore
            if (builder.charAt(i) == '_') {
 
                builder.deleteCharAt(i);
                builder.replace(
                    i, i + 1,
                    String.valueOf(
                        Character.toUpperCase(
                            builder.charAt(i))));
            }
        }
 
        // Return in String type
        return builder.toString();
    }
}
