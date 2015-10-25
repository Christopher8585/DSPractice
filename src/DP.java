
public class DP {
	public static void main(String[]arge){
		//System.out.print(lengthPalindrome(new char[] { 'g','e','e','k','s','d','f','o','r','s','k','e','e','g' }));
		//System.out.print(longestAP(new int[] {5, 10, 15, 20, 25, 30},6));
		int arr[] =  {1, 0, 1, 1, 0,0, 0};
	  
	    findSubArray(arr, arr.length);
		//System.out.println(findLengthOFEqualSum(new int[]{12,8,5,3,8,0,3,14}));
	}
	
	public static int lengthPalindrome(char[] str){
		int[][] n=new int[str.length][str.length];
		int i,j,k;
		
		for(i=0;i<str.length;i++)
			n[i][i]=1;
		
		//print(n);
		
		for(k=2;k<=str.length;k++)
			for(i=0;i<str.length-k+1;i++){
				j=i+k-1;	
				if(str[i]==str[j] && k==2)
					n[i][j]=2;
				else if(str[i]==str[j])
					n[i][j]=n[i+1][j-1] + 2;
				else
					n[i][j]=max(n[i+1][j],n[i][j-1]);
			}
		
		
		print(n);
		return n[0][str.length-1];
	}
	
	static void print(int[][] n){
		for(int i=0;i<n.length;i++){
			for(int j=0;j<n[0].length;j++)
				System.out.print(n[i][j]+" ");
			System.out.println();
		}
	}
	
	public static int max(int a, int b){
		return a>b?a:b;
	}
	
	//Print longest AP
	public static int longestAP(int a[],int size){
		if(size==2)return 2;
		int [][] n=new int [size][size];
		for(int i=0;i<size;i++)
			n[i][size-1]=2;
		
		int maxAP=2;

		for(int j=size-2;j>=0;j--){
			
			int i=j-1,k=j+1;
			while(i>=0 && k<=size-1){				
				if(a[i]+a[k]<2*a[j])
					k++;
				else if(a[i]+a[k]>2*a[j]){ 
					n[i][j]=2;
					i--;
				}
				else{
					
					n[i][j]=n[j][k]+1;
					maxAP=max(maxAP,n[i][j]);
					k++;
					i--;
				}
			}
			
			while(i>=0){
				n[i][j]=2;
				i--;
			}
		}
		print(n); 	
		return maxAP;
	}
	
	
	static int findLengthOFEqualSum(int[] nos){
		int n=nos.length;
		int maxSum=0;
		int[][] sum=new int[n][n];
		
		for(int x=0;x<n;x++)
			sum[x][x]=nos[x];
		
		for(int len=2;len<=n;len++){
			for(int i=0;i<n-len+1;i++){
				int j=i+len-1;
				int k=len/2;
				
				sum[i][j]=sum[i][j-k]+sum[j-k+1][j];
				
				if(sum[i][j-k]==sum[j-k+1][j] && len%2==0 && len>maxSum)
					maxSum=len;
			}
		}
		print(sum);
		return maxSum;
	}
	
	static int findSubArray(int arr[], int n)
	{
	    int maxsize = -1, startindex=0;  // variables to store result values
	  
	    // Create an auxiliary array sunmleft[]. sumleft[i] will be sum of array 
	    // elements from arr[0] to arr[i]
	    int sumleft[]=new int[n];
	    int min, max; // For min and max values in sumleft[]
	    int i;
	  
	    // Fill sumleft array and get min and max values in it. 
	    // Consider 0 values in arr[] as -1
	    sumleft[0] = ((arr[0] == 0)? -1: 1);
	    min = arr[0]; max = arr[0];
	    for (i=1; i<n; i++)
	    {      
	        sumleft[i] = sumleft[i-1] + ((arr[i] == 0)? -1: 1);
	        if (sumleft[i] < min)
	            min = sumleft[i];
	        if (sumleft[i] > max)
	            max = sumleft[i];
	    }
	  
	    // Now calculate the max value of j - i such that sumleft[i] = sumleft[j].   
	    // The idea is to create a hash table to store indexes of all visited values.   
	    // If you see a value again, that it is a case of sumleft[i] = sumleft[j]. Check 
	    // if this j-i is more than maxsize. 
	    // The optimum size of hash will be max-min+1 as these many different values 
	    // of sumleft[i] are possible. Since we use optimum size, we need to shift
	    // all values in sumleft[] by min before using them as an index in hash[].
	    int hash[]=new int [max-min+1];
	  
	    // Initialize hash table
	    for (i=0; i<max-min+1; i++)
	        hash[i] = -1;
	  
	    for (i=0; i<n; i++)
	    {
	        // Case 1: when the subarray starts from index 0
	        if (sumleft[i] == 0)
	        {
	           maxsize = i+1;
	           startindex = 0;
	        }
	  
	        // Case 2: fill hash table value. If already filled, then use it
	        if (hash[sumleft[i]-min] == -1)
	            hash[sumleft[i]-min] = i;
	        else
	        {
	            if ( (i - hash[sumleft[i]-min]) > maxsize )
	            {
	                maxsize = i - hash[sumleft[i]-min];
	                startindex = hash[sumleft[i]-min] + 1;
	            }
	        }
	    }    
	    if ( maxsize == -1 )
	        System.out.println("No such subarray");
	    else
	    	System.out.println( startindex+" to "+ (startindex+maxsize-1));
	  
	    return maxsize;
	}
	
}
