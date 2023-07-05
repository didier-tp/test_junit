package tp.other;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMyFileUtil {
	
	private static Logger logger = LoggerFactory.getLogger(TestMyFileUtil.class);
	
	
    public void testSizeOfExistingFile(){
		
			String pathName="C:\\Windows\\System32\\drivers\\etc\\hosts";
			long tailleFichier = 0; //... code à completer/améliorer .....
			logger.trace("tailleFichier="+tailleFichier + " pathName"+pathName);
		
    }
	
	
    public void testSizeOfNoExistingFile(){
		FileNotFoundException fnfEx = null;//... code à completer/améliorer .....
				
					String pathName="C:\\Windows\\FichierInconnuQuiExistePas";
					long tailleFichier = 0;//... code à completer/améliorer .....
					logger.trace("tailleFichier="+tailleFichier + " pathName"+pathName);
				
		logger.trace("message de l'exception attendue:");	
    }
}
