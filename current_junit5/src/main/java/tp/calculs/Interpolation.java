package tp.calculs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Interpolation {
	
	private SerieXY serieXY;
	private double a;
	private double b;
	
	public static void main(String[] args) {
		Interpolation interpolation= new Interpolation();
		//interpolation.initDefaultCoords();
		interpolation.initCoordsFromFile("serie1.txt");
		interpolation.buildInterpolation();
		interpolation.generateSvgFile("interpolation1.svg");
	}
	
	public Interpolation(){
		serieXY = new SerieXY();
	}
	
	public void initDefaultCoords(){
		serieXY.raz();
		serieXY.addXY(-23.0, 25.0);
		serieXY.addXY(0.0, 1.0);
		serieXY.addXY(25.0, 40.0);
		serieXY.addXY(125.5, 80.5);
	}
	
	public void initCoordsFromFile(String fileName){
		serieXY.raz();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
			String strLine=null;
			while ((strLine = br.readLine()) != null)   {
				  String[] t= strLine.split(";");
				  serieXY.addXY(Double.parseDouble(t[0]), Double.parseDouble(t[1]));
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildInterpolation() {
		StatXY statXY = serieXY.calculerStatXY();
		a = statXY.covarianceXY / statXY.statX.variance;
	    b = statXY.statY.average - a * statXY.statX.average;
	    System.out.println("resInterpolation=y=a*x+b avec a="+a+" et b="+b);
	}
	
	
	public int svgX(double x) {
		return ((int)x + 400);//400=milieu de [0,800]
	}
	
	public int svgY(double y) {
		return (300 - (int)y);//300=milieu de [0,600] et //axe Y inversé
	}
	
	
	public void generateSvgFile(String fileName) {
		//ex de fileName : "interpolation.svg"
		try(PrintStream ps = new PrintStream(new FileOutputStream(fileName))) {
			ps.println("<svg xmlns='http://www.w3.org/2000/svg' height='600' width='800'>");
			
			//nuage de points
			for(XY xy : this.serieXY.getXYEntries())
			ps.printf("<circle cx='%d' cy='%d' r='%d' stroke='%s' stroke-width='%d' fill='%s' />\n", 
					svgX(xy.x) ,  svgY(xy.y) , 3 , "red" , 1 , "red");
			
			//droite d'interpolation y=a*x+b
	        var x1 = -400; 
	        var y1 = a*x1+b;
	        var x2=+400;
	        var y2 = a*x2+b;
			ps.printf("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='%s' stroke-width='%d' />\n", 
					svgX(x1) , svgY(y1) , svgX(x2),  svgY(y2), "blue" , 2);
			
			ps.println("</svg>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
