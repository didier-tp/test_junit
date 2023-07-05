package tp.calculs;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlowTestMyQuickSort {
	private static Logger logger = LoggerFactory.getLogger(SlowTestMyQuickSort.class);
	
	@Test
	public void testQuickSortSmallArray(){
		int taille = 20;
		logger.trace("testQuickSortSmallArray , taille="+taille);
		double[] t = produce_init_tab(taille);
		display_tab(t);//avant tri
		MyQuickSortAlgo.quick_sort(t);
		display_tab(t);//apres tri
	}
	
	@Test
	public void testQuickSortMediumArray(){
		int taille = 200000;
		logger.trace("testQuickSortMediumArray , taille="+taille);
		double[] t = produce_init_tab(taille);
		MyQuickSortAlgo.quick_sort(t);
		display_tab(t);//apres tri
	}
	
	@Test
	public void testQuickSortBigArray(){
		int taille = 10000000;
		logger.trace("testQuickSortBigArray , taille="+taille);
		double[] t = produce_init_tab(taille);
		MyQuickSortAlgo.quick_sort(t);
		display_tab(t);//apres tri
	}
	
	static double[] produce_init_tab(int taille){
		 final double coeff = 1000;
		 double[] t = new double[taille];
		 for(int i=0;i<taille;i++){
			 t[i]=Math.random()*coeff;
		 }
		 return t;
	}
	
	
	static void display_tab(double[] tab){
		if(tab.length <= 30) {
		  StringBuilder sb = new StringBuilder();
		   for(double x : tab)
			  sb.append(x + " ");
		   logger.info("tab=" + sb.toString());
		}
		else{
			logger.info("tableau de taille = " + tab.length);
		}
	}
	
}
