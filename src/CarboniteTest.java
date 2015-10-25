import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarboniteTest {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		suits s=suits.spades;
		System.out.println(s.getOpp());
		//System.out.println(solution(new int[] { 2,1 }, new int[] { 3,3 }));
		//System.out.println(solution(new int []{0,0,0,0,0,1,1,0,0,1,1,1}));
		//System.out.println(solution("This is a string"));
	}

	public enum suits{
		flowers, spades, diamonds;
		suits getOpp(){
			return flowers;
		}
	}
	
	
	
	

	public static int solution2(int[] A, int[] B) {
		// write your code in Java SE 8
		int min = Integer.MAX_VALUE;
		int n = A.length - 1;
		int m = B.length - 1;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (A[i] == B[j] && A[i] < min)
					min = A[i];
			}
		}

		//System.out.println(min);
		
		return min==Integer.MAX_VALUE?-1:min;
	}
	
	static int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            }
            else
                k = 0;
            i = i - 1;
        }
        if (A[i] == 1 && k + 1 >= maximal)
            result = 0;
        return result;
    }
	
	public static int Puzzle(int x) {
		int sum=0;
	      for(int i=x;i>=0;i--)
	        sum+=x;
	      
	      return (int)Math.pow(2,x)+sum;
	}
	
	public static String solution(String S) {
        // write your code in Java SE 8
		
        String[] words=S.toLowerCase().split(" ");
        StringBuilder sb=new StringBuilder();
        for(String word: words){
            sb.append(rev(word)+" ");
        }
		return sb.toString().trim();
    }
    
    private static String rev(String word){
        String res="";
        for(int i=word.length()-1;i>=0;i--)
            res+=word.charAt(i);
            
        return res;
    }
}
