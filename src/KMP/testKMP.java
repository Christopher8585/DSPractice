package KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class testKMP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean exists = false;
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			String s = line;
			KMP kmp1 = new KMP("/*");
			ArrayList<Integer> k1 = kmp1.search(s);
			KMP kmp2 = new KMP("*/");
			ArrayList<Integer> k2 = kmp2.search(s);
			if(k1.size()==k2.size() && !exists)
				for (int i = 0; i < k1.size() || i < k2.size(); i++) {
					int end = k2.get(i) != null ? k2.get(i) + 2 : 0;
					if (end == 0) {
						System.out.println(s.substring(k1.get(i)));
					} else
						System.out.println(s.substring(k1.get(i), end));
				}
			
			else if(k1.size()>k2.size())
				for (int i = 0; i < k1.size() || i < k2.size(); i++) {
					int end = k2.get(i) != null ? k2.get(i) + 2 : 0;
					if (end == 0) {
						System.out.println(s.substring(k1.get(i)));
						exists = true;
					} else
						System.out.println(s.substring(k1.get(i), end));
				}
			
			else if(k1.size()<k2.size())
				for (int i = 0; i < k1.size() || i < k2.size(); i++) {
					int end = k2.get(i) != null ? k2.get(i) + 2 : 0;
					int start=k1.get(i) !=null ? k1.get(i):0;

					System.out.println(s.substring(start,end));

				}
			
			else if(exists && k1.size()==0 && k2.size()==0){
				System.out.println(s.substring(0));
				exists=false;
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
