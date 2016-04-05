package ds;


public class Polynomial2 {

	public static void main(String[] args) {
		int[][] CE_f = {{1, 4}, {2, 3}, {3, 2}, {4, 1}, {5, 0}};
	    Poly2 f = new Poly2(CE_f);
	    System.out.println("f = " + f);
	    Poly2 g = new Poly2(new int[][] {{-2, 3}, {-2, 1}, {-3, 0}});
	    System.out.println("g = " + g);
	    Poly2 h = f.add(g);
	    System.out.println("h = f + g = " + h);
	    System.out.println("h = g + f = " + g.add(f));
	    System.out.println("h + g = " + h.add(g));
	    Poly2 q = new Poly2(new int[][] {{1, 2}, {-2, 1}, {1, 0}});
	    System.out.println("q = " + q);
	    Poly2 r = f.mul(q);
	    System.out.println("q = fq = " + r);
	}
}


class Poly2 {
	
	Term last = new Term(0, -1, null);
	
	Poly2() {
        last.next = last;
	}

    Poly2(int[][] CE) {
        last.next = last;
        for (int i = CE.length - 1; i >= 0; i--) {
        	int c = CE[i][0], e = CE[i][1];
            assert c != 0 && e > last.next.expon;
            last.next = new Term(c, e, last.next);
        }
    }
    
    Poly2 add(Poly2 other) {
    	Poly2 result = new Poly2();
        result.accumulate(this, 1, 0);
        result.accumulate(other, 1, 0);
        return result;
    }
    
    Poly2 mul(Poly2 other) {
    	Poly2 result = new Poly2();
        Term t = last.next;
        while (t != last) {
            result.accumulate(other, t.coeff, t.expon);
            t = t.next;
        }
        return result;
    }
    
    void accumulate(Poly2 other, int mul_coeff, int mul_expon) {
        Term t = other.last.next;
        Term q0 = last;
        Term q = last.next;
        
        /* 여기를 작성하세요. */
    }
    
    public String toString() {
        Term t = last.next;
        if (t == last) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (t.expon == 0) {
            return "" + t.coeff;
        }
        
        sb.append(t.coeff > 0 ? "" : "-");
        while (t != last) {
            int acoeff = Math.abs(t.coeff);
            if (t.expon == 0) {
                sb.append(acoeff);
            } else {
                sb.append(acoeff == 1 ? "" : acoeff);
                sb.append(t.expon == 1 ? "x" : ("x^" + t.expon));
            }
            t = t.next;
            if (t != last) {
            	sb.append(t.coeff > 0 ? " + " : " - ");
            }
        }
        
        return sb.toString();
    }
}
