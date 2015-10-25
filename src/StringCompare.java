import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class StringCompare {
	public static void main(String[] args){
		//matchStrings("cbaaaa","caaaab",0);
		//System.out.println(minMoves);
		//test("abcd","acdb");
		

		
		
		int i=6;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString((i-1)));
		System.out.println(Integer.toBinaryString(~(i-1)));
		System.out.println(Integer.toBinaryString(i&~(i-1)));
	}
	
	public static String swap(String s, int i, int j){
		char[] c = s.toCharArray();
		
		// Replace with a "swap" function, if desired:
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
		
		return new String(c);
	}
	
	static int minMoves=Integer.MAX_VALUE;
	public static void matchStrings(String s1,String s2,int moves){
		if(s1.equals(s2)){
			minMoves=min(minMoves,moves);
			return;
		}
		if(moves>20)
			return;
		int i=0;
		while(s1.charAt(i)==s2.charAt(i))
			i++;

		StringBuilder stemp = new StringBuilder ();
		stemp.append(s1);
		int countLeft=moveLeft(stemp,s2,i);
		
		StringBuilder stemp2 = new StringBuilder ();
		stemp2.append(s1);
		int countRight=moveRight(stemp2,s2,i);
		if(countLeft>countRight)
			matchStrings(stemp2.toString(),s2,moves+countRight);
		else
			matchStrings(stemp.toString(),s2,moves+countLeft);
			
	}
			
	private static int moveRight(StringBuilder stemp2, String s2, int i) {
		String s1=stemp2.toString();
		int count=0;
		int j=i;

		int round=0;
		while(round<s2.length()){
			if(s1.charAt(j)==s2.charAt(i)){
			//	String s=swap(stemp2.toString(),j,j+1>=s2.length()?0:j+1);
			//	stemp2.setLength(0);
			//	stemp2.append(s);
			//	count++;
				break;
			}
			else{
				String s=swap(stemp2.toString(),j,j+1>=s2.length()?0:j+1);
				stemp2.setLength(0);
				stemp2.append(s);
				count++;
				if(i+1>=s2.length())
					j=0;
				else
					j++;
			}
		}
		return count;
	}

	private static int moveLeft(StringBuilder zText, String s2, int i) {
		String s1=zText.toString();
		int count=0;
		int j=i;
		
		int round=0;
		while(round<s2.length()){
			if(s1.charAt(j)==s2.charAt(i)){
			//	String s=swap(zText.toString(),j,j-1<0?s2.length()-1:j-1);
			//	zText.setLength(0);
			//	zText.append(s);
			//	count++;
				break;
			}
			else{
				String s=swap(zText.toString(),j,j-1<0?s2.length()-1:j);
				zText.setLength(0);
				zText.append(s);
				count++;
				if(j<=0)
					j=s2.length()-1;
				else
					j--;
			}
		}
		return count;
	}
	
	private static int min(int val1, int val2) {
		return val1<val2?val1:val2;
	}
	static ArrayList<ArrayList<Integer>> myList= new ArrayList<ArrayList<Integer>>();
	
	public static void test(String s1test, String s2test){

		char[] s1=s1test.toCharArray();
		char[] s2=s2test.toCharArray();
		int[][] Q=new int[100][s1test.length()+2];
		
		for ( int i = 0; i < s1.length; ++i )
		    Q[ s2[i] ][i]=i; // basically, Q is a vector [0 .. 25] of lists

		int[] temp=new int[25];
		//[0 .. 25] = {0}
		int P[]=new int[s1.length];
		for ( int i = 0; i < s1.length; ++i )
		    P[i + 1] = 1 + Q[ s1[i] ][temp[ s1[i] ]++ ];
		
		for(int i:P)
			System.out.println(i);
	}
}
