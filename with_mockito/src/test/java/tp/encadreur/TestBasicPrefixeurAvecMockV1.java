package tp.encadreur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//V1 avec Mockito sans annotations
public class TestBasicPrefixeurAvecMockV1 {
	
	private static Logger logger = LoggerFactory.getLogger(TestBasicPrefixeurAvecMockV1.class);
	
	private BasicPrefixeur prefixeur; //à tester
	
	
	private CustomSeparator customSeparatorMock;
	
	@BeforeEach
	public void initPrefixeurWithMocks() {
		MockitoAnnotations.openMocks(this);
		this.customSeparatorMock = Mockito.mock(CustomSeparator.class);
		this.prefixeur = new BasicPrefixeur(this.customSeparatorMock);
	}
	
	@Test
	public void testPrefixer() {
		String s="junit";
		String prefixe="jaime";
		String expectedRes="jaime__junit";
		Mockito.when(customSeparatorMock.getSeparator()).thenReturn("__");
		
		
		String sRes = prefixeur.prefixer(s, prefixe);
		assertEquals(expectedRes,sRes);
		logger.trace("testPrefixer:"+sRes);
		
		Mockito.verify(customSeparatorMock).getSeparator();
	}
	
	

}
