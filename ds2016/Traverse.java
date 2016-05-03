package ds;


class TNode {
    
    Object element;
    TNode parent, left, right;
    
    TNode(Object e) {
        element = e;
    }

    TNode(Object e, TNode l, TNode r) {
        element = e;
        
        if (l != null) {
            left = l;
            left.parent = this;
        }
        
        if (r != null) {
            right = r;
            right.parent = this;
        }
    }
}


public class Traverse {
    
    static void postOrderDisplay(TNode v) {
        if (v != null) {
            postOrderDisplay(v.left);
            postOrderDisplay(v.right);
            
            System.out.print(v.element);
        }
    }
    
    static void inOrderDisplay(TNode v) {
        if (v.left != null) {
            System.out.print("(");
            inOrderDisplay(v.left);
        }
        
        System.out.print(v.element);
        
        if (v.left != null) {
            inOrderDisplay(v.right);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        // Instantiate tree of expression "((2 * (a - 1)) + (3 * b))".
        TNode root = new TNode("+",
                         new TNode("*",
                             new TNode(2),
                             new TNode("-",
                                 new TNode("a"),
                                 new TNode(1))),
                         new TNode("*",
                             new TNode(3),
                             new TNode("b")));
        
        // Display expression in infix.
        System.out.print("Infix  : ");
        inOrderDisplay(root);
        System.out.println();
        
        // Display expression in postfix.
        System.out.print("Postfix: ");
        postOrderDisplay(root);
        System.out.println();
    }
}
