public class codechk {

	public static void main(String args[]) {
		// System.out.println(Puzzle(new int[][]{{1,1},{10,10},{1,8}},new
		// int[]{10,10}));
		// RomanNumeral("I");
		// System.out.println(converter(2784));

		//int x = 714;
		//int y = 0;
		//codechk c = new codechk();
		//System.out.println(Puzzle("AAAAAAAAAA", 11));
		// System.out.println(c.Puzzle("37*2/67++"));
		//if((x&y)==y)
		
		PuzzleNew(new int []{-1,0,0,1,2,0,4,5,1,5});
	}
	
	public static int[] PuzzleNew(int[] n) {
        int[] out=new int[n.length];
        int[] s=new int[n.length];
        int top=-1;
		while(true){
			int index=0;
			s[++top]=index;
			while(top<0){
				int j=s[top--];
				for(int searchIndex=1;searchIndex<n.length;searchIndex++){
					if(n[searchIndex]==j){
						s[++top]=searchIndex;
					}
				}
			}return out;
		}
        
    }

	public static String Puzzle(String s, int n) {

		if (n <= s.length())
			return s;

		int[] index = new int[n];
		int i = -1;
		int start = 0;
		while (true) {
			index[++i] = s.indexOf('.', start);
			if (index[i] == -1)
				break;
			int end = index[i] + 1;
			while (end!=s.length() )
				if(s.charAt(end) == '.')
					end++;
				else break;

			start = end + 1;
			if(start>=s.length()-1){
				index[++i]=-1;
				break;
			}
		}
		StringBuilder sb = new StringBuilder(n);
		int dots = n - s.length();
		if(i==0){
			sb.append(s.substring(0, s.length()));
			for (int x = 1; x <= dots; x++)
				sb.append(".");
		}
		else{
		int beginIndex = 0;
		int rem=i;
		for (int j = 0; j <= i; j++) {
			int d = 0;
			if(dots>0 )
				if(dots>i){
					d = dots / rem;
					dots -= d;
					rem--;
				}
				else{
					d=1;
					dots--;
				}
			

			if (index[j] != -1) {
				sb.append(s.substring(beginIndex, index[j]));
				for (int x = 1; x <= d; x++)
					sb.append(".");
			} else{
				sb.append(s.substring(beginIndex, s.length()));
				break;
			}
			beginIndex = index[j];
			
		}
		}
		return sb.toString();
	}

	public int Puzzle(String s) {

		int[] nosStack = new int[s.length()];
		char[] opsStack = new char[s.length()];
		int topnos = 0;
		int topops = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/'
					|| s.charAt(i) == '*')
				opsStack[topops++] = (s.charAt(i));
			else
				nosStack[topnos++] = Integer.parseInt(s.charAt(i) + "");
		}
		int res = 0;
		if (topnos > 2) {
			int first = nosStack[--topnos];
			res = calculate(nosStack[--topnos], first, opsStack[--topops]);
		} else
			res = nosStack[--topnos];
		while (topops != 0)
			res = calculate(res, nosStack[--topnos], opsStack[--topops]);

		return res;
	}

	private int calculate(int no1, int no2, char ops) {
		switch (ops) {
		case '+':
			return no1 + no2;
		case '-':
			return Math.abs(no1 - no2);
		case '/':
			return (no1 / no2);
		case '*':
			return no1 * no2;
		}
		return 0;
	}

	public static String converter(int n) {
		String alp = "";
		int step = n;
		int magnitude[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
				1 };
		String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		for (int x = 0; n > 0; x++) {
			step = n / magnitude[x];
			for (int i = 1; i <= step; i++) {
				alp = alp + symbol[x];
			}
			n = n % magnitude[x];
		}
		return alp;
	}

	private static int letterToNumber(char letter) {
		switch (letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new NumberFormatException("Illegal character \"" + letter
					+ "\" in Roman numeral");
		}
	}

	public static void RomanNumeral(String roman) {

		if (roman.length() == 0)
			throw new NumberFormatException(
					"An empty string does not define a Roman numeral.");

		roman = roman.toUpperCase(); // Convert to upper case letters.

		int i = 0; // A position in the string, roman;
		int arabic = 0; // Arabic numeral equivalent of the part of the string
						// that has
						// been converted so far.

		while (i < roman.length()) {

			char letter = roman.charAt(i); // Letter at current position in
											// string.
			int number = letterToNumber(letter); // Numerical equivalent of
													// letter.

			i++; // Move on to next position in the string

			if (i == roman.length()) {
				// There is no letter in the string following the one we have
				// just processed.
				// So just add the number corresponding to the single letter to
				// arabic.
				arabic += number;
			} else {
				// Look at the next letter in the string. If it has a larger
				// Roman numeral
				// equivalent than number, then the two letters are counted
				// together as
				// a Roman numeral with value (nextNumber - number).
				int nextNumber = letterToNumber(roman.charAt(i));
				if (nextNumber > number) {
					// Combine the two letters to get one value, and move on to
					// next position in string.
					arabic += (nextNumber - number);
					i++;
				} else {
					// Don't combine the letters. Just add the value of the one
					// letter onto the number.
					arabic += number;
				}
			}

		} // end while

		if (arabic > 3999)
			throw new NumberFormatException(
					"Roman numeral must have value 3999 or less.");

		System.out.println(arabic);

	} // end constructor

	public static int Puzzle(int[][] points, int[] p) {
		int i, j;
		int count = 0;
		int index = 0;
		boolean found = true;
		for (i = 0; i < points.length; i++) {
			found = true;
			for (j = 0; j < points[i].length; j++) {
				if (p[j] != points[i][j]) {
					found = false;
					break;
				}
			}
			if (found) {
				count++;
				index = i;
			}
		}

		return count == 1 ? index + 1 : 0;
	}

}
