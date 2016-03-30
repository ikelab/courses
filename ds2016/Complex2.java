package ds;

public class Complex2 {
	
	static double[] add(double a1, double b1, double a2, double b2) {
		double[] rv = {a1 + a2, b1 + b2};
		return rv;
	}
	
	public static void main(String[] args) {
		double a1 = 3, b1 = 2;
		double a2 = 1, b2 = 1;
		double a3 = 2, b3 = 4;
		
		double[] c1 = add(a1, b1, a2, b2);
		double[] c2 = add(a1, b1, a3, b3);
		
		System.out.println("Result: " + c1[0] + " + " + c1[1] + "i, " + c2[0] + " + " + c2[1] + "i");
	}
}
