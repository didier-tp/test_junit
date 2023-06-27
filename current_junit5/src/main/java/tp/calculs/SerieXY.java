package tp.calculs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SerieXY {
	
	protected  Serie serieX;
	protected  Serie serieY;
	protected  int size; //effectif
	//********************
	protected StatXY statXY;


	
	public void raz(){
		serieX = new Serie();
		serieY = new Serie();
		this.size=0; //effectif
	}
	
	public SerieXY(){
		raz();
	}
	
	public void addXY(double x,double y) {
		this.serieX.add(x);
		this.serieY.add(y);
		this.size++;
	}
	
	public List<XY> getXYEntries() {
		List<XY> xyEntries = new ArrayList<>();
		Iterator<Double> itX = serieX.values.iterator();
		Iterator<Double> itY = serieY.values.iterator();
		while(itX.hasNext()) {
			xyEntries.add( new XY(itX.next(),itY.next()) );
		}
		 return xyEntries;
	}
	
	public StatXY calculerStatXY() {
		this.statXY = new StatXY();
		this.statXY.size=this.size;
		this.statXY.statX = this.serieX.computeStats();
		this.statXY.statY = this.serieY.computeStats();
		//covariance computing:
		Iterator<Double> itX = serieX.values.iterator();
		Iterator<Double> itY = serieY.values.iterator();
	    double s = 0;
		while(itX.hasNext()) {
			double x = itX.next();
			double y = itY.next();
			s += (x - this.statXY.statX.average)* (y - this.statXY.statY.average);
		}
		this.statXY.covarianceXY=s/this.size;
		return statXY;
	}
	
	

}
