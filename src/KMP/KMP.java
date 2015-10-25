package KMP;

import java.util.ArrayList;

public class KMP {
	
	public  String pattern;
	public  int[][] dfa;
	
	KMP(String p){
		setPattern(p);
	}
	
	public void setPattern(String p){
		pattern=p;
		dfa=new int[256][pattern.length()];
		computeDFA();
	}
	
	public ArrayList<Integer> search(String text){
		ArrayList<Integer> s=new ArrayList<Integer>();
		int n= text.length();
		int i,k=0;
		int m=pattern.length();
		
		for (i=0; i<n && k<=m; i++){
			k=dfa[text.charAt(i)][k];
			
			if(k==m){
				s.add(i-m+1);
				k=0;
			}
		}
		return s;
	}
	
	public void computeDFA(){
		
		int n=pattern.length();
		int r=256;
		
		int x=0;
		dfa[pattern.charAt(0)][0]=1;
		
		for(int i=1;i<n;i++){
			for(int c=0;c<r;c++){
				dfa[c][i]=dfa[c][x];
			}
			dfa[pattern.charAt(i)][i]=i+1;
			x=dfa[pattern.charAt(i)][x];	
		}
	}
	
}
