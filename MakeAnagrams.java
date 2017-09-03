import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MakeAnagrams {

    public static int numberNeeded(String first, String second) {
		int[] letters = new int[26];

		for(char c: first.toCharArray()) {
			letters[c - 'a']++;
		}

		for(char c: second.toCharArray()) {
			letters[c - 'a']--;
		}
		
		int result = 0;
		for(int i: letters) {
			result += Math.abs(i);
		}

		return result;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

}
