package ds;

class MyComplex {
	
	double a, b;
	
	MyComplex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		return a + " + " + b + "i";
	}
}

public class Complex3 {
	
	public static void main(String[] args) {
		MyComplex c1 = new MyComplex(3, 2);
		MyComplex c2 = new MyComplex(1, 1);
		MyComplex c3 = new MyComplex(2, 4);
		
		MyComplex c4 = new MyComplex(c1.a + c2.a, c1.b + c2.b);
		MyComplex c5 = new MyComplex(c1.a + c3.a, c1.b + c3.b);
		
		System.out.println("Result: " + c4 + ", " + c5);
	}
}
