import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StackMaximumElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<StackNode> s = new Stack<StackNode>();
        int N = sc.nextInt();
        int max = 0;
        
        while(N > 0) {
            int operation = sc.nextInt();
            if(operation == 1) {
                int value = sc.nextInt();
                if(value > max) {
                    max = value;
                }
                s.push(new StackNode(value, max));
            } else if(operation == 2) {
                int temp = s.pop().currentMax;
                if(s.empty()) {
                    max = 0;
                } else {
                    max = s.peek().currentMax;
                } 
            } else if(operation == 3) {
                System.out.println(s.peek().currentMax);
            }
            
            N--;
        }
        
    }
}

class StackNode {
    int value;
    int currentMax;
    
    public StackNode(int value, int currentMax) {
        this.value = value;
        this.currentMax = currentMax;
    }
}