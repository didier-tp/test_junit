package tp.converter;

import java.lang.reflect.Field;

public class BasicConverter {
   static double doubleFromString(String s) throws NumberFormatException{
	   return Double.parseDouble(s);
   }
   
   static Object allPartsInLowercase(Object obj) {
	   Object resObj=null;
	   try {
		   Class<?> c = obj.getClass();
		   resObj = c.getDeclaredConstructor().newInstance();
		   Field[] fields = c.getDeclaredFields();
		   for(Field f : fields) {
			   f.setAccessible(true);
			   Object value = f.get(obj);
			   if(value instanceof String)
				   value= ((String)value).toLowerCase();
			   f.set(resObj, value);
		   }
		   return resObj;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	   return resObj;
   }
}
