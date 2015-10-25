import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution2 {
	
	
	 static boolean isPalindrome(String s) {
		  int n = s.length();
		  for (int i=0;i<(n / 2) + 1;++i) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }
		  return true;
		}

	    static int palindrome(String str) {
	        String s1 = "";
	        int N = str.length(), count = 0;
	        Set<String> palindromeArray = new HashSet<String>();
	        for (int i = 1; i <= N; i++) {
	            for (int j = 0; j <= N; j++) {
	                int k = i + j - 1;
	                if (k >= N)
	                    continue;
	                s1 = str.substring(j, i + j);
	                if (isPalindrome(s1)) {
	                    palindromeArray.add(s1);
	                }
	            }
	        }
	        return palindromeArray.size();
	        
	    }
	
	
	
    public static void main(String[] args) throws IOException{
    	//palindrome("aabaa");
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int testcases=Integer.parseInt(in.readLine());
    	int [][][]allnos=new int[testcases][][];
    	for(int test=0;test<testcases;test++){
	        int size=Integer.parseInt(in.readLine());
	        int[][]a=new int[size][];
	        
	        for(int i=0;i<size;i++){
	        	a[i]=new int[i+1];
	        	
	        	String[] nos=in.readLine().split(" ");
	        	
	        	for(int j=0;j<i+1;j++)
	        		a[i][j]=Integer.parseInt(nos[j]);
	        }
	        allnos[test]=a;
    	}
        //print(a);

    	for(int [][]a:allnos)
    		System.out.println(maxSumTriangle(a));
    }	
   
    
    public static void print(int[][] nos){
    	Map<String, List<String>> hm=new HashMap<String, List<String>>();
    	   // HashMap<String, String[]> hm=new HashMap<String, String[]>();
    	   List<String> valSetTwo = new ArrayList<String>();
    	   valSetTwo.add("Bat");
    	   valSetTwo.add("Banana");
    	   hm.put("asdkl",valSetTwo);
    	   
    	   Map<String, String[]> hm2=new HashMap<String, String[]>();
    	   
    	   hm2.put("asd", new String[]{"asdasd","sadasd"});
    	   
    	for(int i=0;i<nos.length;i++){
    		for(int j=0;j<nos[i].length;j++)
    			System.out.print(nos[i][j]);
    		System.out.println();
    	}
    }
    
    public static int maxSumTriangle(int[][]nos){
    	int sum=nos[0][0];
    	int[][] dp=new int[nos.length][nos.length];
    	dp[0][0]=sum;
    	for(int i=1;i<nos.length;i++){
    		for(int j=0;j<nos[i].length;j++){
    			if(j-1>=0)
    				dp[i][j]=max(dp[i-1][j], dp[i-1][j-1])+nos[i][j];
    			else
    				dp[i][j]=dp[i-1][j]+nos[i][j];
    			
	    		if(sum<dp[i][j])
	    			sum=dp[i][j];
    		}
    	}
    	return sum;
    }
    
    private static int max(int n1,int n2){
    	return n1>n2?n1:n2;
    }
    /*
    if(nos[i][j]>nos[i][j+1]){
		sum+=nos[i][j];
	}
	else{
		sum+=nos[i][j+1];
		j=j+1;
	}
    */
}
