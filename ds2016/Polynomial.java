package ds;


public class Polynomial {

	public static void main(String[] args) {
		int[][] CE_f = {{1, 4}, {2, 3}, {3, 2}, {4, 1}, {5, 0}};
	    Poly f = new Poly(CE_f);
	    System.out.println("f = " + f);
	    Poly g = new Poly(new int[][] {{-2, 3}, {-2, 1}, {-3, 0}});
	    System.out.println("g = " + g);
	    Poly h = f.add(g);
	    System.out.println("h = f + g = " + h);
	    System.out.println("h = g + f = " + g.add(f));
	    System.out.println("h + g = " + h.add(g));
	}
}


class Term {
	
	int coeff, expon;
	Term next;
	
	Term(int c, int e, Term n) {
		coeff = c;
		expon = e;
		next = n;
	}
}


class Poly {
	
	Term last = new Term(0, -1, null);

	Poly() {
        last.next = last;
	}

    Poly(int[][] CE) {
        last.next = last;
        for (int i = CE.length - 1; i >= 0; i--) {
        	int c = CE[i][0], e = CE[i][1];
            assert c != 0 && e > last.next.expon;
            last.next = new Term(c, e, last.next);
        }
    }
    
    Poly add(Poly other) {
        Poly result = new Poly();
        result.accumulate(this);
        result.accumulate(other);
        return result;
    }
    
    void accumulate(Poly other) {
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
