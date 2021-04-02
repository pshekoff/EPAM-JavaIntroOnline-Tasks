package javaIntro_4_Classes;

public class Triangle {
	private Point a, b, c;	
	
	public Triangle() {
		this.a = new Point(0,0);
		this.b = new Point(0,1);
		this.c = new Point(1,0);
	}
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double perimeter() {
		double len1 = Point.length(a, b);
		double len2 = Point.length(b, c);
		double len3 = Point.length(c, a);
		return len1 + len2 + len3;
	}
	
	public double square() {
		double len1 = Point.length(a, b);
		double len2 = Point.length(b, c);
		double len3 = Point.length(c, a);
		double pp = (len1 + len2 + len3) / 2;
		return Math.sqrt(pp * (pp - len1) * (pp - len2) * (pp - len3));
	}
	
	public Point medianCross() {
		double x = (a.x + b.x + c.x) / 3;
		double y = (a.y + b.y + c.y) / 3;
		return new Point(x,y);
	}
	
}
