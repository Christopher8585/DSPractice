import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test456 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int[] res=new int[t];
		for (int test = 0; test < t; test++) {
	            
			String[] nosString = br.readLine().split(" ");
			int no1 = Integer.parseInt(nosString[0]);
			int no2 = Integer.parseInt(nosString[1]);
			
			if(no1<no2){
				int tno=no2;
				no2=no1;
				no1=tno;
			}
			
			int numOfSqrt = (int) (Math.floor(Math.sqrt(no1)) - Math.ceil(Math.sqrt(no2)) + 1);
			System.out.println(numOfSqrt);
			
        }
		
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int[] res=new int[t];
		for (int test = 0; test < t; test++) {
			String[] nosString = br.readLine().split(" ");
			int A = Integer.parseInt(nosString[0]);
			float N = Float.parseFloat(nosString[1]);
			float M = Float.parseFloat(nosString[2]);
			String X = "";
			for (int i = 0; i < N; i++) {
				X += nosString[0];
			}
			
			res[test]=(int)(double)(Float.parseFloat(X) % M);
		}

		for(int result:res)
			System.out.println(result);
		*/
		//System.out.println(212%17);
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in));
		 * 
		 * String[] nosString = br.readLine().split(" ");
		 * 
		 * int size = Integer.parseInt(nosString[0]); int r =
		 * Integer.parseInt(nosString[1]); int s =
		 * Integer.parseInt(nosString[2]);
		 * 
		 * String[] nos = br.readLine().split(" "); int count = 0; int[] values
		 * = new int[size]; for (String no : nos) { values[count++] =
		 * Integer.parseInt(no); }
		 * 
		 * print(values,r,s);
		 */
	}

	public static void print(int[] nos, int r, int s) {
		int max = 1 << nos.length;
		// int [][] values=new int[nos.length][max];

		HashMap<Integer, ArrayList<int[]>> map = new HashMap<Integer, ArrayList<int[]>>();
		for (int i = 0; i < max; i++) {
			int k = i;
			int index = 0;
			// String no = "";
			int no[] = new int[nos.length];
			int j = 0;
			while (k > 0) {
				if ((k & 1) > 0) {
					no[j] = nos[index];

					j++;
				}

				k >>= 1;
				index++;
			}

			ArrayList<int[]> a;
			if (!map.containsKey(j)) {
				a = new ArrayList<int[]>();
			} else
				a = map.get(j);

			a.add(no);
			map.put(j, a);
		}

		Iterator it = map.entrySet().iterator();
		int count = 0;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			// System.out.println(pair.getKey() + " = " + pair.getValue());
			ArrayList<int[]> list = map.get(pair.getKey());
			for (int i = 0; i < list.size(); i++)
				for (int j = 0; j < list.size(); j++) {
					int no1[] = list.get(i);
					int no2[] = list.get(j);
					boolean exists = false;
					for (int t = 0; t < (int) pair.getKey(); t++) {
						int x = no1[t], y = no2[t];
						if (x + y == r && x - y == s) {
							exists = true;
						} else {
							exists = false;
							break;
						}
					}
					if (exists)
						count++;
				}
		}
		System.out.println(count);
	}
}
