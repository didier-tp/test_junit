package tp.calculs;

import java.util.ArrayList;
import java.util.List;

public class Serie {
	
	protected  List<Double> values;
	
	public void reset(){
		this.values = new ArrayList<Double>();
	}
	
	public Serie(){
		reset();
	}
	
	public void add(Double v) {
		this.values.add(v);
	}
	
	public Stat computeStats() {
		Stat stat = new Stat();
		stat.size=this.values.size();
		for(Double v : values) {
			stat.sum += v;
		}
		stat.average = stat.sum / stat.size;
		double s = 0;//somme des carres de la diff avec moyenne
		for(Double v : values) {
			s += Math.pow(v - stat.average, 2);
		}
		stat.variance = s / stat.size;
		return stat;
	}

}
