package ds;

import java.util.Vector;


class BinaryTree {
    
    Vector<Object> A = new Vector<>();
    
    Object get(int rank) {
        if (rank < A.size()) {
            return A.get(rank);
        }
        
        return null;
    }

    void set(int rank, Object e) {
        if (A.size() <= rank) {
            A.setSize(rank + 1);
        }
        
        A.set(rank, e);
    }
    
    int left(int rank) {
        return rank * 2 + 1;
    }
    
    int right(int rank) {
        return rank * 2 + 2;
    }
}


public class TraverseArr {
    
    static void postOrderDisplay(BinaryTree t, int rank) {
        Object e = t.get(rank);
        if (e != null) {
            postOrderDisplay(t, t.left(rank));
            postOrderDisplay(t, t.right(rank));
            System.out.print(e);
        }
    }
    
    static void inOrderDisplay(BinaryTree t, int rank) {
        if (t.get(t.left(rank)) != null) {
            System.out.print("(");
            inOrderDisplay(t, t.left(rank));
        }
        
        System.out.print(t.get(rank));
        
        if (t.get(t.right(rank)) != null) {
            inOrderDisplay(t, t.right(rank));
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        
        // Instantiate tree of expression "((2 * (a - 1)) + (3 * b))".

        int rr = 0;  // rank of root
        t.set(rr, "+");
        
        int rrl = t.left(rr), rrr = t.right(rr);
        t.set(rrl, "*");
        t.set(rrr, "*");
        
        t.set(t.left(rrl), 2);
        t.set(t.right(rrl), "-");
        t.set(t.left(t.right(rrl)), "a");
        t.set(t.right(t.right(rrl)), "1");

        t.set(t.left(rrr), 3);
        t.set(t.right(rrr), "b");
        
        System.out.print("Array  : ");
        System.out.println(t.A);
        
        // Display expression in infix and in postfix.
        
        System.out.print("Infix  : ");
        inOrderDisplay(t, 0);
        System.out.println();
        
        System.out.print("Postfix: ");
        postOrderDisplay(t, 0);
        System.out.println();
    }
}
