package KMP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class testhacker {

	public String pattern;
	public int[][] dfa;

	testhacker(String p) {
		setPattern(p);
		dfa = new int[256][pattern.length()];
		computeDFA();
	}

	public void setPattern(String p) {
		pattern = p;
	}

	public ArrayList<Integer> search(String text) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		int n = text.length();
		int i, k = 0;
		int m = pattern.length();

		for (i = 0; i < n && k <= m; i++) {
			k = dfa[text.charAt(i)][k];

			if (k == m) {
				s.add(i - m + 1);
				k = 0;
			}
		}
		return s;
	}

	public void computeDFA() {

		int n = pattern.length();
		int r = 256;

		int x = 0;
		dfa[pattern.charAt(0)][0] = 1;

		for (int i = 1; i < n; i++) {
			for (int c = 0; c < r; c++) {
				dfa[c][i] = dfa[c][x];
			}
			dfa[pattern.charAt(i)][i] = i + 1;
			x = dfa[pattern.charAt(i)][x];
		}
	}

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		//String sentence = scanner.nextLine();
		boolean exists = false;
		while (scanner.hasNext()) {
			//String line = scanner.readLine();
			//if (line == null)
			//	break;

			String s = scanner.nextLine();
			KMP kmp1 = new KMP("/*");
			ArrayList<Integer> k1 = kmp1.search(s);
			KMP kmp2 = new KMP("*/");
			ArrayList<Integer> k2 = kmp2.search(s);
			if (k1.size() == k2.size() && !exists)
				for (int i = 0; i < k1.size() || i < k2.size(); i++) {
					int end = k2.get(i) != null ? k2.get(i) + 2 : 0;
					if (end == 0) {
						System.out.println(s.substring(k1.get(i)));
					} else
						System.out.println(s.substring(k1.get(i), end));
				}

			else if (k1.size() > k2.size())
				for (int i = 0; i < k1.size() || i < k2.size(); i++) {
					int end=0;
					if(k2.size()>0)
						end = k2.get(i) != null ? k2.get(i) + 2 : 0;
					if (end == 0) {
						System.out.println(s.substring(k1.get(i)));
						exists = true;
					} else
						System.out.println(s.substring(k1.get(i), end));
				}

			else if (k1.size() < k2.size())
				for (int i = 0; i < k1.size() || i < k2.size(); i++) {
					int end=0,start=0;
					if(k2.size()>0)
					 end = k2.get(i) != null ? k2.get(i) + 2 : 0;
					if(k1.size()>0)
					 start = k1.get(i) != null ? k1.get(i) : 0;

					System.out.println(s.substring(start, end));
					exists = false;
				}

			else if (exists && k1.size() == 0 && k2.size() == 0) {
				System.out.println(s.substring(0));
				if(k2.size()>0)
					exists = false;
			}

			//
			KMP kmp3 = new KMP("//");
			ArrayList<Integer> k3 = kmp3.search(s);
			for (int i = 0; i < k3.size(); i++) {
				System.out.println(s.substring(k3.get(i)));
			}
		}
	}
}
