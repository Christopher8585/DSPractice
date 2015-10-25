import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test567 {
	static long[] C;
	static long[] F;
	static int k;
	static int n;

	static String single[] = new String[]{ "", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"};

	static String tentotwenty[] = new String[]{"", "ten", "eleven", "twelve", "thirteen", "fourteen",
       "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	static String tens[] = new String[]{"", "", "twenty", "thirty", "forty", "fifty",
               "sixty", "seventy", "eighty", "ninety"};
	public static void main(String[] args) throws NumberFormatException,
			IOException {
/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int no=  Integer.parseInt(br.readLine());
		int temp=no;
		int val1=0;
		int div=2;
		while(temp>1){
			if(temp==div){
				while(div>0){
					val1+=div%10;
					div/=10;
				}
				break;
			}
			if(temp%div==0){
				val1+=div;
				temp/=div;
			}
			else{
				if(div!=2)
					div=div+2;
				else
					div++;
			}
		}
		
		int val2=0;
		while(no>0){
			val2+=no%10;
			no/=10;
		}

		System.out.println(val1==val2?1:0);*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int hour=  Integer.parseInt(br.readLine());
		int min=  Integer.parseInt(br.readLine());
		
		if(min==0){
			if(hour>9)
				System.out.print(tentotwenty[(hour%10)+1] + " o' clock");
			else
				System.out.print(single[hour] + " o' clock");
		}
		else if(min<30){
			if(min<10)
				System.out.print(single[min]+" minutes");
			else if(min==15)
				System.out.print("quarter");
			else if(min>=10 && min <20)
				System.out.print(tentotwenty[min-9]+" minutes");
			else
				System.out.print(tens[min/10]+" "+single[min%10]+" minutes");
			
			System.out.print(" past ");
			if(hour>9)
				System.out.print(tentotwenty[(hour%10)+1]);
			else
				System.out.print(single[hour]);
		}
		else if (min==30){
			System.out.print("half past ");
			if(hour>9)
				System.out.print(tentotwenty[(hour%10)+1]);
			else
				System.out.print(single[hour]);
		}
		else if(min>30 && min <60){
			min=60-min;
			hour++;
			if(min<10)
				System.out.print(single[min]+" minutes");
			else if(min==15)
				System.out.print("quarter");
			else if(min>=10 && min <20)
				System.out.print(tentotwenty[min-9]+" minutes");
			else
				System.out.print(tens[min/10]+" "+single[min%10]+" minutes");
			
			System.out.print(" to ");
			if(hour>9)
				System.out.print(tentotwenty[(hour%10)+1]);
			else
				System.out.print(single[hour]);
		}
			*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		k = Integer.parseInt(size[1]);
		C = new long[n];
		F = new long[k + 1];

		String[] Fvalues = br.readLine().split(" ");
		for (int i = 0; i < Fvalues.length; i++)
			F[k - i] = Long.parseLong(Fvalues[i]);

		String[] Cvalues = br.readLine().split(" ");
		for (int i = 0; i < Cvalues.length; i++)
			C[i] = Long.parseLong(Cvalues[i]);

		solve();

		for (int i = n - 1; i >= 0; i--)
			System.out.print(F[i] + " ");
	 
	}

	private static void solve() {
		for (int i = k - n; i >= 0; i--) {
			for (int j = 0; j < n - 1; j++)
				F[i]=(F[i]+C[j]*F[i+n-(j+1)])%(long)(Math.pow(10, 9)+7);

			F[i] = F[i + n] - F[i];
			F[i] /= C[n - 1];

		}

	}
}