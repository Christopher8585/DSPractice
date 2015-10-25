import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	/*
	 * public static void main(String[] args) throws NumberFormatException,
	 * IOException {
	 * 
	 * int numPackets = Integer.parseInt(in.readLine()); int numKids =
	 * Integer.parseInt(in.readLine()); int[] packets = new int[numPackets];
	 * 
	 * for (int i = 0; i < numPackets; i++) { packets[i] =
	 * Integer.parseInt(in.readLine()); }
	 * 
	 * int unfairness = Integer.MAX_VALUE;
	 * 
	 * // Write your code here, to process numPackets N, numKids K, and the //
	 * packets of candies // Compute the ideal value for unfairness over here
	 * unfairness = sort(packets,numKids); System.out.println(unfairness); }
	 */
	static int min(int no1, int no2) {
		return no1 < no2 ? no1 : no2;
	}

	private static int sort(int[] a, int k) {
		sort(a, 0, a.length - 1);
		int fair = Integer.MAX_VALUE;
		// Max and Min of subsequence
		for (int i = 0; i < a.length - k + 1; i++) {
			fair = min(fair, a[i + k - 1] - a[i]);
		}
		return fair;
	}

	// Quicksort
	private static void sort(int[] a, int low, int high) {
		if (high <= low)
			return;

		int l = low;
		int h = high;
		if (l + 1 == h) {
			if (a[h] < a[l]) {
				int t = a[h];
				a[h] = a[l];
				a[l] = t;
			}
			return;
		}
		int m = (l + h) / 2;
		int pivot = a[m];
		a[m] = a[h];
		a[h] = pivot;

		while (l < h) {
			while (pivot >= a[l] && l < h)
				l++;
			while (pivot <= a[h] && l < h)
				h--;

			if (l < h) {
				int t = a[h];
				a[h] = a[l];
				a[l] = t;
			}
		}

		a[high] = a[h];
		a[h] = pivot;

		sort(a, low, l - 1);
		sort(a, h + 1, high);
	}
	
	
	public static void test(int no){
	  int NUM=no;
	  long []pow=new long[NUM];
	  long val[]=new long[NUM];
	  int x,num,ten;
	    int i,j,count;
	    for(num=2; num<NUM; num++)
	    {
	        for(i=0; i<NUM; pow[i++]=0);
	        count=0;
	        for(ten=1,x=1; x<NUM; x++)
	        {
	            val[x]=ten;

	            for(j=0; j<NUM; j++)if(pow[j]!=0&&(pow[(j+ten)%num]==0)&&pow[j]!=x)pow[(j+ten)%num]=x;
	            if(pow[ten]==0)pow[ten]=x;
	            ten=(10*ten)%num;
	            if(pow[0]==0)break;
	        }

	        x=num;
	        System.out.println("%ld\tdivides\t"+x);
	        if(pow[0]!=0)
	        {
	            while(x!=0)
	            {
	                while(--count>pow[x%num]-1)
	                	System.out.println("0");
	                count=(int) (pow[x%num]-1);
	                System.out.println("1");
	                x=(int) ((num+x-val[(int) pow[x%num]])%num);
	            }
	            while(count-->0)System.out.println("0");
	        }
	        System.out.println("\n");
	    }
	}
	
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int temp = 0;
		boolean found = false;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						for (int m = 0; m < 2; m++) {
							for (int n = 0; n < 2; n++) {
								for (int o = 0; o < 2; o++) {
									temp = Integer.parseInt("" + i + j + k + l
											+ m + n + o);
									if (temp % size == 0 && temp != 0) {
										found = true;
										break;
									}
								}
								if (found)
									break;
							}
							if (found)
								break;
						}

						if (found)
							break;
					}

					if (found)
						break;
				}
				if (found)
					break;
			}
			if (found)
				break;
		}
		//System.out.println(found == false ? 0 : temp);
		test(size);
	}

	static int getNumberOfPrimes(int N) {
		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (i == 2 || i == 3) {
				count++;
				continue;
			}

			if (i % 2 == 0 || i % 3 == 0)
				continue;
			for (int j = 2; j <= i / 2; j++) {
				if (i == 2)
					count++;
				if (i % j == 0)
					break;
				else if (i == j * 2 + 1)
					count++;
			}
		}
		return count;
	}

	public static int getLongestSequence(int[] nos) {
		int max = 0;
		int[] l = new int[nos.length];
		// for(int i=0;i<l.length;i++)
		l[0] = 1;

		for (int i = 1; i < nos.length; i++) {
			l[i] = 1;
			for (int j = 0; j < i; j++)
				if (nos[i] > nos[j] && l[i] < l[j] + 1) {
					l[i] = l[j] + 1;
					max = max(max, l[i]);
				}
		}
		return max;
	}

	private static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
				System.out.print(a[i][j] + " ");

			System.out.println();
		}
	}

	private static int max(int no1, int no2) {
		return no1 > no2 ? no1 : no2;
	}
}