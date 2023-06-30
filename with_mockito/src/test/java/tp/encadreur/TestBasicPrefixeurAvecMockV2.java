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

//V2 avec Mockito avec annotations

//@RunWith(MockitoJUnitRunner.class) //for JUnit 4
//@ExtendWith(MockitoExtension.class) //or MockitoAnnotations.openMocks(this) in @BeforeEach for JUnit 5
public class TestBasicPrefixeurAvecMockV2 {
	
	private static Logger logger = LoggerFactory.getLogger(TestBasicPrefixeurAvecMockV2.class);
	
	@InjectMocks
	private BasicPrefixeur prefixeur; //à tester
	
	
	@Mock
	private CustomSeparator customSeparatorMock;
	
	@BeforeEach
	public void initPrefixeurWithMocks() {
		MockitoAnnotations.openMocks(this);
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
