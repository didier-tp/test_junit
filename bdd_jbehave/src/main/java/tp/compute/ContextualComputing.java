package tp.compute;

public class ContextualComputing {
	
	private double value;
	
	public void multiplyBy(double x) {
		this.value *= x; // ok ( this.value= this.value * x)
		//this.value *= (x + 1);  //erreur temporaire
	}
	
	public void plus(double x) {
		this.value += x; // ok ( this.value= this.value + x)
		//this.value += (x + 1);  //erreur temporaire
	}
	
	public ContextualComputing() {
		this.value = 0;
	}

	public ContextualComputing(double initialValue) {
		this.value = initialValue;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	

}
