package ds;


public class Matrix {
	
	public static void main(String[] args) {
		Mat a = new Mat(1, 1, 1, 2);
		Mat b = new Mat(-2, -1, -2, -1);
		
		System.out.println("a =");
		a.display();
		
		System.out.println("b =");
		b.display();
		
		System.out.println("c = a + b =");
		Mat c = a.add(b);
		c.display();
		
		System.out.println("d = a - b =");
		Mat d = a.sub(b);
		d.display();
		
		System.out.println("e = d * -1 = (a - b) * -1 =");
		Mat e = d.mul(-1);
		e.display();
		
		System.out.println("f = c * e = (a + b) * ((a - b) * -1) =");
		Mat f = c.mul(e);
		f.display();
		
		double x = a.add(b).mul(a.sub(b).mul(-1)).det();
		System.out.println("x = |f| = |c * e| = |(a + b) * ((a - b) * -1)| = " + x);
	}
}


class Mat {

	double a, b, c, d;

	Mat() {
	}

	Mat(double c11, double c12, double c21, double c22) {
		a = c11;
		b = c12;
		c = c21;
		d = c22;
	}

	void display() {
		System.out.println("  [" + a + "  " + b + "]");
		System.out.println("  [" + c + "  " + d + "]");
	}

	Mat add(Mat m) {
		Mat result = new Mat();

		result.a = a + m.a;
		result.b = b + m.b;
		result.c = c + m.c;
		result.d = d + m.d;
		
		return result;
	}
	
	Mat sub(Mat m) {
		Mat result = new Mat();

		/* 여기에 코드를 작성하세요. */
		
		return result;
	}
	
	Mat mul(double k) {
		Mat result = new Mat();

		/* 여기에 코드를 작성하세요. */
		
		return result;
	}
	
	Mat mul(Mat m) {
		Mat result = new Mat();

		/* 여기에 코드를 작성하세요. */
		
		return result;
	}
	
	double det() {
		/* 아래의 return 값을 제대로 계산하세요. */
		return 0;
	}
}
