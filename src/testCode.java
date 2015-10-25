import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;


public class testCode {

    static int maxXor(int l, int r) {
        int max=0;
        for(int i=l;i<=r;i++)
            for(int j=l;j<=r;j++){
                if(max<(i^j))
                    max=(i^j);
            }
        
        return max;
    }
    /*
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
      
        x=new int[N];
        value=new int[N];
		for(int i=0;i<N;i++){
			x[i]=i;
			value[i]=0;
		}
        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
          // Store a and b in an appropriate data structure of your choice
            union(a,b);
        }

   
        long combinations = 0;
        
        
        
        for(int i=0;i<N;i++)
        	add(x[i]);
        
        
        int size=N;
        for(int i=0;i<N;i++){
        	//System.out.println(value[i]+" "+i);
        	if(size<0)
        		break;
        	combinations+=value[i]*(size-value[i]);
        	size-=value[i];
        }
        
        // Compute the final answer - the number of combinations
       
        System.out.println(combinations);

            
    }
    */
   // static HashMap<K, V> value=new HashMap<>(initialCapacity);
    //static HashMap map=new HashMap();
    static int[] x;
    static int[] value;
    static public void add(int value1){
    	value[value1]+=1;
    }
    
    static public int root(int v){
		while(v!=x[v])
			v=x[v];	
		return v;
	}
    
    
	static public boolean isConnected(int a,int b){
		return root(a)==root(b);
	}
	
	static public void union(int a, int b){
		int rootA=root(a);
		int rootB=root(b);
		value[rootB]+=1;
		x[rootA]=rootB;
		//x[a]=x[b];
	}
	
	static HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
	private static void hm1() {
		//hm.put(1, "hi");
		hm.put(2, 1);
		//hm.put(1,  1);
		
		//hm.put(1, "hiasd");
		if(hm.containsKey(1)){
			hm.put(1, hm.get(1) + 1);
		}
		System.out.print(hm.keySet());
		System.out.print(hm.values());
	}
	/*
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     String line=br.readLine();
	     int length=Integer.parseInt(line);
	     long values[]=new long[length];
	     for(int i=0;i<length;i++){
	    	 String val=br.readLine();
	    	 values[i]=Long.parseLong(val);
	     }
	     //4294967295
	     //v = (v * 2) & 0xffffffff;
	     for(int i=0;i<length;i++){
	    	 
	    	// values[i]=~values[i];
	    	// values[i]=(values[i] * 2) & 0xffffffff;
	    	// System.out.println(values[i]);
	    	 //values[i] = values[i] & 0xffffffff;
	    	 
	    	 int test=1;
	    	 long test2=~test & 0xffffffffL;
	    	 System.out.println((int)test2);
	     }
     
	}
	*/
	/*
	public static void main(String[] args) throws IOException{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     String line=br.readLine();
	     int size=Integer.parseInt(line);
	     int[][] values=new int [size][];
	     
	     for(int i=0;i<size;i++){
	    	 String length=br.readLine();
	    	 values[i]=new int[Integer.parseInt(length)];
	    	 
	    	 String seq[]=br.readLine().split(" ");
	    	 int j=0;
	    	 for(String s: seq){
	    		 values[i][j]=Integer.parseInt(s);
	    		 j++;
	    	 }
	     }
	     
	     HashMap<Integer, Integer>hm=new HashMap<Integer, Integer>();
	     
	     for(int i=0;i<size;i++)
	    	 for(int j=0;j<values[i].length;j++)
	    		 //if(!hm.containsKey(values[i][j]))
	    			 hm.put(values[i][j], values[i][j]);
	     
	     
	     Iterator it=hm.keySet().iterator();
	     while(it.hasNext()){
		     System.out.print(it.next()+" ");
		     it.remove();
	     }
	}
	*/
	public static void main (String args[])
	{
	  int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
	  int n = arr.length;
	  //System.out.print("Length of LBS is "+ lbs( arr, n ) );
	  FMState state=FMState.Member;
	  System.out.println(state.values());
	}
	
	 public enum FMState {
			Member, Candidate, Leader
		}
	  
	static int  lbs( int arr[], int n )
	{
	   int i, j;
	 
	   /* Allocate memory for LIS[] and initialize LIS values as 1 for
	      all indexes */
	   int[] lis = new int[n];
	   for ( i = 0; i < n; i++ )
	      lis[i] = 1;
	 
	   /* Compute LIS values from left to right */
	   for ( i = 1; i < n; i++ )
	      for ( j = 0; j < i; j++ )
	         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
	            lis[i] = lis[j] + 1;
	 
	   /* Allocate memory for lds and initialize LDS values for
	      all indexes */
	   int[] lds = new int [n];
	   for ( i = 0; i < n; i++ )
	      lds[i] = 1;
	 
	   /* Compute LDS values from right to left */
	   for ( i = n-2; i >= 0; i-- )
	      for ( j = n-1; j > i; j-- )
	         if ( arr[i] > arr[j] && lds[i] < lds[j] + 1)
	            lds[i] = lds[j] + 1;
	 
	 
	   /* Return the maximum value of lis[i] + lds[i] - 1*/
	   int max = lis[0] + lds[0] - 1;
	   for (i = 1; i < n; i++)
	     if (lis[i] + lds[i] - 1 > max)
	         max = lis[i] + lds[i] - 1;
	   return max;
	}
}




