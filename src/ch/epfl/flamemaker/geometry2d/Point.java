package ch.epfl.flamemaker.geometry2d;

public final class Point {
	
	private final double xCoord;
	private final double yCoord;
	private double r;
	private double theta;
	public final static Point ORIGIN = new Point(0,0);
	
	public Point(double x, double y){
		xCoord=x;
		yCoord=y;
		r=Math.sqrt(x*x + y*y);
		theta=Math.atan2(y,x);
	}
	
	public double x(){
		return xCoord;
	}
	
	public double y(){
		return yCoord;
	}
	
	public String toString(){
		return "("+xCoord+","+yCoord+")";
	}
	
	public double r(){
		return r;
	}
	
	public double theta(){
		return theta;
	}
}
