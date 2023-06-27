package tp.calculs;

public class XY {
	public double x;
	public double y;
	
	public XY(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public XY() {
		this(0.0,0.0);
	}

	@Override
	public String toString() {
		return "XY [x=" + x + ", y=" + y + "]";
	}
	
}
