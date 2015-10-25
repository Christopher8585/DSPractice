import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;

import java.lang.reflect.Array;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;

public class StringManipulation {
	public static void printAllSubsets(char[] nos) {
		int max = 1 << nos.length;

		for (int i = 0; i < max; i++) {
			int k = i;
			int index = 0;
			String s="";
			while (k > 0) {
				if ((k & 1) > 0)
					s+=nos[index];

				k >>= 1;
				index++;
			}
			System.out.println(s);

		}
	}
	
;
	public static void countPalindromes(String s){
		int count=0;
		for(int len=1;len<s.length();len++){
			for(int i=0;i<s.length()-len;i++){
				if(isPalindrome(s.substring(i, i+len))){
					count++;
					System.out.println(s.substring(i, i+len));
				}
			}
		}
		System.out.println(count);
	}
	
	public static boolean isPalindrome(String s) {
	    // i moves forward, and j moves backward.
	    int i = 0, j = s.length() - 1;
	    while (i < j) {
	      // i and j both skip non-alphanumeric characters.
	      while (!isLetterOrDigit(s.charAt(i)) && i < j) {
	        ++i;
	      }
	      while (!isLetterOrDigit(s.charAt(j)) && i < j) {
	        --j;
	      }
	      if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j))) {
	        return false;
	      }
	      ++i;
	      --j;
	    }
	    return true;
	  }

	static char[][] c = { { ' ' }, { ' ' }, { 'a', 'b', 'c' },
			{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
			{ 'w', 'x', 'y', 'z' } };

	public static void printAllDigits(int[] i) {
		char[] result = new char[i.length + 1];
		printDigits(i, 0, result);
	}

	private static void printDigits(int[] input, int cur, char[] output) {
		if (cur == input.length) {
			for (char i : output)
				System.out.print(i);
			return;
		}

		for (int i = 0; i < c[input[cur]].length; i++) {
			output[cur] = c[input[cur]][i];
			printDigits(input, cur + 1, output);
			if (cur < input.length)
				if (input[cur] == 0 || input[cur] == 1)
					return;

		}
	}

	public static void allPermutations(char[] c, int cur) {
		if (cur == c.length - 1) {
			for (char ch : c)
				System.out.print(ch);
			System.out.print("  ");
			return;
		}
		for (int i = cur; i < c.length; i++) {
			char tmp = c[cur];
			c[cur] = c[i];
			c[i] = tmp;
			allPermutations(c, cur + 1);
			char tmp2 = c[cur];
			c[cur] = c[i];
			c[i] = tmp2;
		}
	}

	public static int medianFinder(int[] a, int[] b, int size) {
		if (size == 0)
			return -1;
		if (size == 1)
			return (a[0] + b[0]) / 2;
		if (size == 2)
			return (max(a[0], b[0]) + min(a[1], b[1])) / 2;
		int m1 = median(a, size);
		int m2 = median(b, size);
		if (m1 == m2) {
			return m1;
		} else if (m1 > m2) {
			if (size % 2 == 0)
				return medianFinder(Arrays.copyOfRange(a, 0, size / 2),
						Arrays.copyOfRange(b, size / 2, size), size - size / 2);
			else
				return medianFinder(Arrays.copyOfRange(a, 0, size / 2 + 1),
						Arrays.copyOfRange(b, size / 2, size), size - size / 2);
		} else {
			if (size % 2 == 0)
				return medianFinder(Arrays.copyOfRange(b, 0, size / 2),
						Arrays.copyOfRange(a, size / 2, size), size - size / 2);
			else
				return medianFinder(Arrays.copyOfRange(b, 0, size / 2 + 1),
						Arrays.copyOfRange(a, size / 2, size), size - size / 2);
		}
	}

	private static int median(int[] b, int size) {
		if (size % 2 == 0)
			return (b[size / 2] + b[size / 2 - 1]) / 2;
		else
			return b[size / 2];
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int min(int a, int b) {
		return a > b ? b : a;
	}

	public static void main(String args[]) {
		 //printAllDigits(new int []{0,3,4});
		//printAllSubsets(new char[] { 'a', 'b', 'c' });
		//printAllSubsets("abc".toCharArray());
		 //allPermutations(new char[]{'a', 'b','c','d','e'},0);
		 //int ar1[] = {1, 2, 3, 6,7};
		 //int ar2[] = {2,4, 6, 8, 10};
		countPalindromes("wowpurerocks");
		 //System.out.print(medianFinder(ar1, ar2, ar1.length));

	}

}
