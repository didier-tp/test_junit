package tp.calculs;

public class Stat {
	int size=0;
	double sum=0;
	double average=0;
	double variance=0;
	double ecartType() { return Math.sqrt(this.variance); }//standard deviation
	
	public String toString() {
		return "Stat [size=" + size + ", sum=" + sum + ", average=" + average + ", variance=" + variance + "]";
	}
	
	
}
