package Recursion;

import java.util.ArrayList;

public class RecursionExamples {
	public static int fibonacci(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		int a=1,b=1;
		for(int i=3;i<=n;i++){
			int c=a+b;
			a=b;
			b=c;
		}
		return b;
	}
	
	public static int fiboRecursive(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(n>1)
			return fiboRecursive(n-1)+fiboRecursive(n-2);
		else
			return -1;
	}
	
	static ArrayList<Point> soln=new ArrayList<Point>();
	public static boolean findPaths(int x,int y){
		Point p=new Point(x, y);
		soln.add(p);
		if(x==0 && y==0) return true;
		boolean success=false;
		if(x>0)
			success=findPaths(x-1,y);
		if(y>0 && !success)
			success=findPaths(x, y-1);
		
		if(!success)
			soln.remove(p);
		
		return success;
	}
	

	public static ArrayList<String> allPermutations(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null)
			return null;
		if (s.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char item = s.charAt(0);
		String remaining = s.substring(1);
		ArrayList<String> words = allPermutations(remaining);
		for (String word : words)
			for (int j = 0; j <= word.length(); j++)
				permutations.add(createWord(word, item, j));

		return permutations;
	}

	private static String createWord(String word, char item, int j) {
		String start = word.substring(0, j);
		String end = word.substring(j);
		return start + item + end;
	}

	public static void printPar(int l, int r, char[] str, int count) {
		if (l < 0 || r < l)
			return; // invalid state
		if (l == 0 && r == 0) {
			System.out.println(str); // found one, so print it
		} else {
			if (l > 0) { // try a left paren, if there are some available
				str[count] = '(';
				printPar(l - 1, r, str, count + 1);
			}
			if (r > l) { // try a right paren, if there�s a matching left
				str[count] = ')';
				printPar(l, r - 1, str, count + 1);
			}
		}
	}

	public static void printPar(int count) {
		char[] str = new char[count * 2];
		printPar(count, count, str, 0);
	}
	

	public static int makeChangeNew(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChangeNew(n - i * denom, next_denom);
		}
		return ways;
	}
	
	//Not working Dime,nickle change problem
	public static void makeChange(int amt, ArrayList<Integer> nos) {
		ArrayList<Integer> sums = new ArrayList<Integer>();
		sums.addAll(nos);

		while (amt > 0) {
			if (amt >= 25) {
				sums.add(25);
				makeChange(amt - 25, sums);
				amt = amt - 25;
			}
			if (amt >= 10) {
				sums.add(10);
				makeChange(amt - 10, sums);
				amt = amt - 10;
			}
			if (amt >= 5) {
				sums.add(5);
				makeChange(amt - 5, sums);
				amt = amt - 5;
			}
		}
		if (amt == 0) {
			for (int n : sums)
				System.out.print(" " + n);
			System.out.println();
		}
	}
	
	public static void test(int p[],int value){
		p[0]=1;
		p[1]=2;
		value=7;
	}

	
	
	public static void main(String args[]){
		//System.out.println(fibonacci(2));
		//System.out.print(fiboRecursive(4));
		//System.out.println(findPaths(5, 4));
		//for(Point p: soln)
		//	System.out.println(p.x+","+p.y);
		int[] p=new int []{3,4};
		int value=1;
		//test(p,value);
		//for(int p1: p)
			//System.out.print(" "+p1);
		//System.out.print(value);
		//nQueens q=new nQueens(8);
		//q.runNQuees();
		System.out.println(makeChangeNew(15,5));
		//printPar(4);
		ArrayList<String> s=allPermutations("abc");
		//for(String st:s)
			//System.out.println(st);
	}
}
