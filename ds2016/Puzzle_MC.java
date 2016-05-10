package ds;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;


// Node class that represents states.
class Node {
    
    int c1, m1;  // the number of cannibals and missionaries at left side.
    int c2, m2;  // the number of cannibals and missionaries at right side.
    int boat;    // 1, if boat is at right side; -1, otherwise
    Node parent;
    
    Node(int _c1, int _m1, int _c2, int _m2, int _boat, Node _parent) {
        c1 = _c1; m1 = _m1; c2 = _c2; m2 = _m2; boat = _boat; parent = _parent;
    }
    
    // Check valid state, i.e., non-negative numbers and the number of cannibals,
    // for each side, not to be greater than the number of missionaries if there
    // are missionaries.
    boolean isValid() {
        return c1 >= 0 && m1 >= 0 && m2 >= 0 && m2 >= 0 &&
               (m1 == 0 || c1 <= m1) && (m2 == 0 || c2 <= m2);
    }
    
    public String toString() {
        return c1 + ":" + m1 + (boat == -1 ? " u___ " : " ___u ") + c2 + ":" + m2;
    }
}


public class Puzzle_MC {
    
    public static void main(String[] args) {
        // Solve puzzle.
        Node s0 = solve();
        
        // Reverse sequence using stack because s0 is the last state (goal).
        Stack<Node> S = new Stack<Node>();
        while (s0 != null) {
            S.push(s0);
            s0 = s0.parent;
        }
        
        // Print out sequence of states from the initial state to the goal.
        while (!S.isEmpty()) {
            Node s = S.pop();
            System.out.println(s);
        }
    }

    static Node solve() {
        // Prepare queue and enqueue the root (the initial state where all are
        // at the right side).
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(new Node(0, 0, 3, 3, 1, null));

        // Do breadth-first traversal to get the solution with the minimum length.
        while (!Q.isEmpty()) {
            // Dequeue.
            Node s = Q.remove();
            
            // Check if it is the goal.
            if (s.c1 == 3 && s.m1 == 3) {
                return s;
            }
            
            // every possible movement {x, y}, which means x cannibals and
            // y missionaries will move to the other side
            int D[][] = {{0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 0}};
            
            // For each possible movement, create a new state and enqueue.
            for (int d[]: D) {
                // Create a child node (new state) s1 from s by moving d[0]
                // cannibals, d[1] missionaries, and the boat, to the other side.
                // Note (s.boat * d[i]) is used to calculate the change in the
                // number at each side based on where the boat is. (Without this
                // scheme, the code will be much more verbose and repetitive.)
                Node s1 = new Node(s.c1 + s.boat * d[0], s.m1 + s.boat * d[1],
                                   s.c2 - s.boat * d[0], s.m2 - s.boat * d[1],
                                   -1 * s.boat, s);
                
                // Enqueue if it is valid.
                if (s1.isValid()) {
                    Q.add(s1);
                }
            }
        }
        
        return null;  // It is impossible to be here.
    }
}
