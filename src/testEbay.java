import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class testEbay {
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		// int t = Integer.parseInt(br.readLine());

		System.out.println(easyStrings("aab", "baa"));
		// System.out.println(countUneatenLeaves(10, new int[] { 2, 4, 5 }));
		// System.out.println(braces("()[[]()"));
	}

	static String swap(String str, int i, int j) {
		char[] s = str.toCharArray();

		char t = s[i];
		s[i] = s[j];
		s[j] = t;

		String finalString = "";
		for (char st : s)
			finalString += st;
		return finalString;
	}

	static int easyStrings(String a, String b) {

		int numMoves = 0;
		for(int i=0;i<a.length();i++){
			if (a.charAt(i) != b.charAt(i)) {
				
				int j=i+1;
				
				if(a.charAt(a.length()-1)==b.charAt(i)){
					a=swap(a,i,a.length()-1);
					numMoves++;
					continue;
				}
				
				while(b.charAt(i) != a.charAt(j) || b.charAt(j) == a.charAt(j))
					j++;
				

				//while(i!=j){
					a=swap(a,i,j);
					//j--;
					numMoves++;
				//}

			}
		}
		
		return numMoves;
	}

	static int easyStrings2(String a, String b) {
		if (a.equalsIgnoreCase(b))
			return 0;

		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
				for (int j = i; j < a.length(); j++) {
					if (a.charAt(j) == b.charAt(i)) {
						char t = a.charAt(i);
						a = a.substring(0, i) + b.charAt(i)
								+ a.substring(i + 1);
						a = a.substring(0, j) + t + a.substring(j + 1);
						break;
					}
				}
			}
		}
		return count;
	}

	private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
	static {
		brackets.put('[', ']');
		brackets.put('{', '}');
		brackets.put('(', ')');
	}

	static String braces(String value) {
		if (value.length() == 0) {
			return "YES";
		}
		// odd number would always result in false
		if ((value.length() % 2) != 0) {
			return "NO";
		}

		final Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < value.length(); i++) {
			if (brackets.containsKey(value.charAt(i))) {
				stack.push(value.charAt(i));
			} else if (stack.empty()
					|| (value.charAt(i) != brackets.get(stack.pop()))) {
				return "NO";
			}
		}
		return "YES";
	}

	public static int countUneatenLeaves2(int numberLeaves, int[] catArray) {
		int uneatenLeaves = 0;
		int catArraySize = catArray.length;
		int countEaten = 0;

		HashMap<Integer, Integer> positionEatenHash = new HashMap<Integer, Integer>();

		for (int i = 0; i < catArraySize; i++) {
			int catervalue = catArray[i];
			for (int j = 1; j * catervalue <= numberLeaves; j++) {
				if (!positionEatenHash.containsKey(catArray[i] * j)) {
					positionEatenHash.put(catArray[i] * j, 1);
					countEaten++;
				}
			}
		}
		uneatenLeaves = numberLeaves - countEaten;
		return uneatenLeaves;
	}

	static int countUneatenLeaves(int N, int[] A) {
		int count = 0;
		HashMap<Integer, Integer> positionEatenHash = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			int mult = A[i];
			int j = 2;
			while (mult < N && A[i] > 0) {
				if (!positionEatenHash.containsKey(A[i] * j)) {
					positionEatenHash.put(A[i] * j, 1);
					count++;
				}
				mult = A[i] * j++;
			}
		}

		count = N - 1 - count;
		return count;
	}

}
