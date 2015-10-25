package BinaryOps;

public class bitManipulation {
	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; /* All 1�s */
		 System.out.println(Integer.toBinaryString(max));  
		// 1�s through position j, then 0�s
		 System.out.println(Integer.toBinaryString((1 << j)-1));
		int left = max - ((1 << j) - 1);
		System.out.println(Integer.toBinaryString(left));
		// 1�s after position i
		int right = ((1 << i) - 1);
		System.out.println(Integer.toBinaryString(right));
		// 1�s, with 0s between i and j
		int mask = left | right;
		
		System.out.println(Integer.toBinaryString((m << i)));
		System.out.println(Integer.toBinaryString((n & mask)));
		System.out.println(Integer.toBinaryString(((n & mask) | (m << i))));
		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}

	public static String printBinary(String n) {
		int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
		double decPart = Double.parseDouble(n.substring(n.indexOf('.'),
				n.length()));
		String int_string = "";
		while (intPart > 0) {
			int r = intPart % 2;
			// System.out.println(intPart +
			// ": "+Integer.toBinaryString(intPart));
			intPart >>= 1;
			// System.out.println(intPart +
			// " AfterShift: "+Integer.toBinaryString(intPart));
			int_string = r + int_string;
		}
		System.out.println(int_string);
		StringBuffer dec_string = new StringBuffer();
		while (decPart > 0) {
			if (dec_string.length() > 4)
				return int_string + "." + dec_string;
			if (decPart == 1) {
				dec_string.append((int) decPart);
				break;
			}
			double r = decPart * 2;
			if (r >= 1) {
				dec_string.append(1);
				decPart = r - 1;
			} else {
				dec_string.append(0);
				decPart = r;
			}
		}
		System.out.println(dec_string);
		return int_string + "." + dec_string;
	}
	
	public static boolean GetBit(int n, int index){
		return ((n & (1<<index))>0);
	}
	
	public static int SetBit(int n, int index, boolean type){
		if(type){
			n=n | (1<<index);
			return n;
		}
		else
		{
			int mask=~(1<<index);
			n=n&mask;
			return n;
		}
	}
	
	public static int GetNext_NP(int n){
		if(n<=0)
			return -1;
		int ones=0;
		int index=0;
		
		while(!GetBit(n, index))
			index++;
		
		while(GetBit(n, index)){
			index++;
			ones++;
		}
		
		n=SetBit(n, index, true);
		ones--;
		index--;
		n=SetBit(n, index, false);
		
		for(int i=index-1;i>=ones;i--){
			n=SetBit(n, i, false);
			//index--;
		}
		
		for(int i=ones-1;i>=0;i--){
			n=SetBit(n, i, true);
			//index--;
		}
		return n;
	}

	public static int GetPrevious_NP(int n) {
		if (n <= 0)
			return -1; // Error

		int index = 0;
		int countZeros = 0;

		// Find first zero.
		while (GetBit(n, index))
			index++;

		// Turn off next 1.
		while (!GetBit(n, index)) {
			index++;
			countZeros++;
		}
		n = SetBit(n, index, false);

		// Turn on previous zero
		index--;
		n = SetBit(n, index, true);
		countZeros--;

		// Set ones
		for (int i = index - 1; i >= countZeros; i--) {
			n = SetBit(n, i, true);
		}

		// Set zeros
		for (int i = countZeros - 1; i >= 0; i--) {
			n = SetBit(n, i, false);
		}

		return n;
	}
	
	public static int bitDiff(int a,int b){
		int count=0;
		for(int c=a^b;c!=0;c=c>>1){
			
			count+=c&1;
		}
		
		return count;
	}

	public static void main(String[] args) {
		int n = 1024;
		int m = 21;
		System.out.print(updateBits(n, m, 2, 6));
		//System.out.println(printBinary("305.68"));
		int x=2,y=1;
		int count=bitDiff(x,y);
		//System.out.println(GetPrevious_NP(10));
		//x=x<<count;
		//x=x>>count;
		y=y<<count;
		//y=y>>count;
		
		//System.out.print( count+":- "+ (x^y) +" x: " + x +" y: "+y);
	}
}
