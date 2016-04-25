package ds;

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExprEval {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Expression? ");
        String expr = s.nextLine();
        //String expr = "((5 + 2) * (8 - 3)) / 4";
        s.close();
        
        Queue<Object> Q = toPostfix(expr);
        System.out.println("Postfix: " + Q);
        
        System.out.println(expr + " = " + calcPostFix(Q));
    }
    
    static double calcPostFix(Queue<Object> Q) {
        
        /* 여기를 구현하세요. */
        
    }
    
    static Queue<Object> toPostfix(String expr) {
        Queue<Object> Q = new LinkedList<Object>();
        Stack<String> S = new Stack<String>();

        // For the usage of regular expression (Pattern and Match), refer to
        //   http://stackoverflow.com/questions/3373885/splitting-a-simple-maths-expression-with-regex
        Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
        Matcher m = pattern.matcher(expr);
        while(m.find()) {
            String o = m.group();
            
            if (o.equals("+") || o.equals("-")) {
                while (!S.empty() && !S.peek().equals("(")) {
                    Q.add(S.pop());
                }
                S.push(o);
            } else if (o.equals("*") || o.equals("/")) {
                while (!S.empty() &&
                       (S.peek().equals("*") || S.peek().equals("/"))) {
                    Q.add(S.pop());
                }
                S.push(o);
            } else if (o.equals(")")) {
                while (!S.peek().equals("(")) {
                    Q.add(S.pop());
                }
                S.pop();  // Pop out "(".
            } else if (o.equals("(")) {
                S.push(o);
            } else {
                Q.add(Double.parseDouble(o));
            }
        }
        
        while (!S.empty()) {
            Q.add(S.pop());
        }

        return Q;
    }

}
