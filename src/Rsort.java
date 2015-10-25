
public class Rsort {
	 public static void sort(char[] a){
	        int N=a.length;
	        int[] count=new int[256];
	        
	        char[] aux=new char[N];
	        
	        for(int i=0;i<N;i++)
	            count[a[i]+1-'a']++;
	        for(int i=0;i<4;i++)	
	            count[i+1]+=count[i];
	        for(int i=0;i<N;i++)
	            aux[count[a[i]-'a']++]=a[i];
	        for(int i=0;i<N;i++)
	            System.out.println(aux[i]+" " +a[i]);
	    }
	 
	 public static void RsortString(String[] a, int size){
	        int N=a.length;

	        String[] aux=new String[N];
	        for(int j=size-1;j>=0;j--){
	        	int[] count=new int[5];
	        	
		        for(int i=0;i<N;i++)
		            count[a[i].charAt(j)+1-'a']++;
		        for(int i=0;i<4;i++)
		            count[i+1]+=count[i];
		        for(int i=0;i<N;i++)
		            aux[count[a[i].charAt(j)-'a']++]=a[i];
		        for(int i=0;i<N;i++)
		            a[i]=aux[i];
	        }
	        for(int i=0;i<N;i++)
	        	System.out.println(a[i]);
	    }
	    
	    public static void main(String[] args){
	    	//Only ABCD size=4
	        //sort(new char[]{'a','d','c','c','a','c','d','a','c','b','a','b'});
	        RsortString(new String[]{"bcd","bad","abd","cab","cad","bbabcc","bbaabc"}, 3);
	    }
}
