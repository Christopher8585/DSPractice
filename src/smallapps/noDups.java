package smallapps;

//remove with buffer
public class noDups {
	public static String removeDuplicates(char[] str) {
		if (str == null)
			return "";
		int len = str.length;
		if (len < 2)
			return "";

		int tail = 1;
		// move thru all values
		for (int i = 1; i < len; ++i) {
			int j;
			// chk existing list
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			// if does not exist, add it
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;

		for (char s : str)
			System.out.print(s);
		return str.toString();
	}

	// non-contiguous duplicates
	public static void removeDuplicatesEff(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
		for (char s : str)
			System.out.print(s);
	}

	// anagrams
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int unique = 0;
		int completed = 0;
		int[] ch = new int[256];

		for (char c : s.toCharArray()) {
			if (ch[c] == 0)
				unique++;
			ch[c] += 1;
		}

		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (ch[c] == 0)
				return false;

			ch[c]--;

			if (ch[c] == 0)
				completed++;

		}
		
		return (completed == unique);
	}

	// replace space with '%20'
	public static void replace(char[] chars, int length) {
		int count = 0, newlength;
		for (char c : chars)
			if (c == ' ')
				count++;

		newlength = length + count * 2;
		// char[] chars=new char[newlength];
		chars[newlength] = '\0';
		for (int j = length - 1; j >= 0; j--) {
			if (chars[j] == ' ') {

				chars[newlength - 1] = '0';
				chars[newlength - 2] = '2';
				chars[newlength - 3] = '%';
				newlength -= 3;
			} else {
				chars[newlength - 1] = chars[j];
				newlength -= 1;
			}

		}
		// System.out.println(s[i]);
		for (int i = 0; i < chars.length; i++)
			System.out.println(chars[i]);
	}

	// replace space with '%20'
	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}

	// rotate a matrix by 90 degrees
	public static void rotate(int[][] matrix, int n) {
		printMatrix(matrix,n);
		System.out.println("Begin");
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
				//System.out.print("\n");
				//printMatrix(matrix,n);
			}
			//System.out.print("\n");
			//System.out.print("OuterCompleted");
		}
		System.out.print("\n");
		System.out.println("Output");
		printMatrix(matrix,n);
	}

	public static void printMatrix(int[][] matrix, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	


	public static void main(String args[]) {
		String s = "aaavvvabvvabvvabbbv";
		char[] sa = s.toCharArray();
		//removeDuplicatesEff(sa);
		// char[] s = { 'a', 'v', ' ', 'c', ' ' };

		// replace(s, s.length);
		 //System.out.print(anagram("abbcd","cbbad"));

		int[][] matrix = { { 0, 0, 1, 1 }, { 1, 0, 0, 1 }, { 0, 1, 0, 0 },{ 1, 1, 1, 1 } };
		rotate(matrix, 4);

	}
}
