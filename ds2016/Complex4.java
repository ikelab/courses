package ds;

class NewComplex {
	
	double a, b;
	
	NewComplex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	NewComplex add(NewComplex other) {
		NewComplex rv = new NewComplex(a + other.a, b + other.b);
		return rv;
	}
	
	public String toString() {
		return a + " + " + b + "i";
	}
}

public class Complex4 {
	
	public static void main(String[] args) {
		NewComplex c1 = new NewComplex(3, 2);
		NewComplex c2 = new NewComplex(1, 1);
		NewComplex c3 = new NewComplex(2, 4);
		
		System.out.println("Result: " + c1.add(c2) + ", " + c1.add(c3));
	}
}
