package tp.other;

import java.io.File;
import java.io.FileNotFoundException;

public class MyFileUtil {
	public static long tailleFichier(String filePathName) throws FileNotFoundException{
		long s=0;
		File file = new File(filePathName);
		if(!file.exists())
			throw new FileNotFoundException(filePathName + " does not exists");
		s=file.length();
		return s;
	}
}
