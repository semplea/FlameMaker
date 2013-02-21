package ch.epfl.flamemaker.geometry2d;

public final class AffineTransformation implements Transformation{
	
	private final double a;
	private final double b;
	private final double c;
	private final double d;
	private final double e;
	private final double f;
	public static final AffineTransformation IDENTITY=new AffineTransformation(1,0,0,0,1,0);
	
	public AffineTransformation(double a, double b, double c, double d, double e, double f){
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
	}
	
	public AffineTransformation(AffineTransformation transformation){
		this.a=transformation.a;
		this.b=transformation.b;
		this.c=transformation.c;
		this.d=transformation.d;
		this.e=transformation.e;
		this.f=transformation.f;
	}
	
	public static AffineTransformation newTranslation(double dx, double dy){
		return new AffineTransformation(1,0,dx,0,1,dy);
	}
	
	public static AffineTransformation newRotation(double theta){
		return new AffineTransformation(Math.cos(theta),-Math.sin(theta),0,Math.sin(theta),Math.cos(theta),0);	
	}
	
	public static AffineTransformation newScaling(double sx, double sy){
		return new AffineTransformation(sx,0,0,0,sy,0);
	}
	
	public static AffineTransformation newShearX(double sx){
		return new AffineTransformation(1,sx,0,0,1,0);
	}
	
	public static AffineTransformation newShearY(double sy){
		return new AffineTransformation(1,0,0,sy,1,0);
	}
	
	public Point transformPoint(Point p){
		return new Point(a*p.x()+b*p.y()+c,d*p.x()+e*p.y()+f);
	}
	
	public double translationX(){
		return c;
	}
	
	public double translationY(){
		return f;
	}
	
	public AffineTransformation composeWith(AffineTransformation that){
		return new AffineTransformation(a*that.a+b*that.d,a*that.b+b*that.e,a*that.c+b*that.f+c,d*that.a+e*that.d,d*that.b+e*that.e,d*that.c+e*that.f+f);
	}
	
	public AffineTransformation clone(){
		return new AffineTransformation(this);
	}
}
