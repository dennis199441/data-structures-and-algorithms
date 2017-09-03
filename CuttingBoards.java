import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CuttingBoards {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        for(int k = 0; k < q; k++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            // indicate number of pieces
            long x = 1;
            long y = 1;
            
            ArrayList<Long> c_y = new ArrayList<Long>();
            for(int i = 0; i < m - 1; i++) {
                c_y.add(sc.nextLong());
            }
            
            ArrayList<Long> c_x = new ArrayList<Long>();
            for(int i = 0; i < n - 1; i++) {
                c_x.add(sc.nextLong());
            }

            Collections.sort(c_y, Collections.reverseOrder());
            Collections.sort(c_x, Collections.reverseOrder());

            // cut: most expensive = cut first
            int index_X = 0;
            int index_Y = 0;
            long totalCost = 0;

            while(!(x == n && y == m)) {
                if(x < n && y < m) {
                    // compare cost to decide whether cut horizontally or vertically
                    if(c_y.get(index_Y) >= c_x.get(index_X)) {
                        totalCost += c_y.get(index_Y) * x;
                        y++;
                        index_Y++;
                    } else if(c_y.get(index_Y) < c_x.get(index_X)) {
                        totalCost += c_x.get(index_X) * y;
                        x++;
                        index_X++;   
                    }
                } else if(x == n && y < m) {
                    totalCost += c_y.get(index_Y) * x;
                    index_Y++;
                    y++;
                } else if(x < n && y == m) {
                    totalCost += c_x.get(index_X) * y;
                    index_X++;
                    x++;
                }
            }

            totalCost = totalCost % (long)(Math.pow(10, 9) + 7);
            System.out.println(totalCost );
        }
    }


}