package ch.epfl.flamemaker.geometry2d;

public final class Rectangle {
	
	private final Point center;
	private final double width;
	private final double height;
	
	public Rectangle(Point center, double width, double height) throws IllegalArgumentException{
		
		if (width<=0 || height<=0){
			throw new IllegalArgumentException();
		}
		
		this.center=center;
		this.width=width;
		this.height=height;
	}
	
	public double left(){
		return center.x() - 0.5*width;
	}
	
	public double right(){
		return center.x() + 0.5*width;
	}
	
	public double bottom(){
		return  center.y() - 0.5*height;
	}
	
	public double top(){
		return  center.y() + 0.5*height;
	}
	
	public double width(){
		return width;
	}
	
	public double height(){
		return height;
	}
	
	public Point center(){
		return center;
	}
	
	public boolean contains(Point p){
		return p.x()>=this.left() && p.x()<this.right() && p.y()>=this.bottom() && p.y()<this.top();
	}
	
	public double aspectRatio(){
		return width/height;
	}
	
	public Rectangle expandToAspectRatio(double aspectRatio) throws IllegalArgumentException{
		if (aspectRatio<=0){
			throw new IllegalArgumentException();
		}
		
		if (aspectRatio==this.aspectRatio()){
			return this;
		}
		else if(aspectRatio>this.aspectRatio()){
			return new Rectangle(this.center,aspectRatio*this.height,this.height);
		}
		else{
			return new Rectangle(this.center,this.width,this.width/aspectRatio);
		}
	}
	
	public String toString(){
		return "("+center.toString()+","+width+","+height+")";
	}
}
