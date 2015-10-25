import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test123 {
	static int [][] nos;
	static long minAll=Long.MAX_VALUE;
	
	
	public static void main(String args[]) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//String[] size=br.readLine().split(" ");
		int i=Integer.parseInt(br.readLine());
		int j=Integer.parseInt(br.readLine());
		
		
		getKap(i,j);
		
		/*
		for(int k=0;k<i;k++){
			String[] row=br.readLine().split(" ");
			for(int n=0;n<j;n++){
				nos[k][n]=Integer.parseInt(row[n]);
			}
		}
		
		findMin();
		System.out.println(minAll);
		*/
		/*
		int count=0;
		for(String s:c){
			nos[count++]=Integer.parseInt(s);
		}

		int max=0,left=0,right=0;
		for(int i=0;i<size;i++){
			int l=i-1;
			boolean found=false;
			while(l>=0)
				if(nos[i]>=nos[l])
					l--;
				else{
					left=l+1;
					found=true;
					break;
				}
			
			if(!found)
				left=0;
			
			found=false;
			
			int r=i+1;
			while(r<size)
				if(nos[i]>=nos[r])
					r++;
				else{
					right=r+1;
					found=true;
					break;
				}
			
			if(!found)
				right=0;
			
			max=maxValue(max,left*right);
		}
		System.out.println(max);
		*/
	}
	
	private static void getKap(int i, int j) {
		List<Integer> res=new ArrayList<>();
		for(int x=i;x<=j;x++){
			long sqr=(long) Math.pow(x,2);
			int no1=0;
			int mul=0;
			while(sqr>0){
				int add;
				if(mul==0)
					add=1;
				else
					add=(int)Math.pow(10,mul);
				
				no1= (int) (sqr%10)*add+no1;						
				sqr/=10;
				mul++;
				if(no1+sqr==x && no1!=0){			
					System.out.print(x + " ");
				}
			}

		}
	}

	private static void findMin() {
		boolean[] visited=new boolean[nos.length];
		for(int x=0;x<visited.length;x++)
			findMers(visited, x, 0, 0);
	}
	
	private static void findMers(boolean[] visited,int i,int j,long min) {
			
		boolean temp[]=	visited.clone();

		temp[i]=true;
		if(min>minAll)
			return;
		if(i>=nos.length || j>=nos[0].length)
			return;
		
		if(j==nos[0].length-1){
			if(min+nos[i][j]<minAll)
				minAll=min+nos[i][j];
			return;
		}
		
		findMers(temp, i, j+1, min+nos[i][j]);
		for(int x=0;x<temp.length;x++)
			if(!temp[x]){
				findMers(temp, x, j+1, min+nos[i][j]);
			}
	}

	private static int maxValue(int max, int i) {
		return max>i?max:i;
	}




	/*
	if(fn2(0,1)==1) System.out.println("true "+fn2(0,1) +" 1");
	else
		System.out.println(fn2(0,1) +" 1");
	if(fn2(0,2)==0) 
		System.out.println("true "+fn2(0,2) +" 0");
	else
		System.out.println(fn2(0,2) +" 0");
	if(fn2(1,1)==3) System.out.println("true " +fn2(1,1) +" 3");
	else
		System.out.println(fn2(1,1) +" 3");
	if(fn2(0,5)==0) System.out.println("true");
	else
		System.out.println(fn2(0,5) +" 0");
	if(fn2(3,2)==3) System.out.println("true");
	else
		System.out.println(fn2(3,2) +" 3");
		*/
	//fn();
/*
 * int digitNumber = 1; int sum = 0; String binary = "11010"; String[]
 * hex=new String[binary.length()/4+1]; System.out.println(
 * Integer.parseInt(binary, 2));
 * 
 * int diff=4-binary.length()%4; for(int j=0;j<diff;j++){ binary="0"+binary;
 * } String res=""; for(int i = 0; i < binary.length(); i++){ if(digitNumber
 * == 1) sum+=Integer.parseInt(binary.charAt(i) + "")*8; else if(digitNumber
 * == 2) sum+=Integer.parseInt(binary.charAt(i) + "")*4; else if(digitNumber
 * == 3) sum+=Integer.parseInt(binary.charAt(i) + "")*2; else if(digitNumber
 * == 4 || i < binary.length()+1){ sum+=Integer.parseInt(binary.charAt(i) +
 * "")*1; digitNumber = 0; if(sum < 10) //System.out.print(sum); res+=sum;
 * else if(sum == 10) res+='A'; else if(sum == 11) res+='B'; else if(sum ==
 * 12) res+='C'; else if(sum == 13) res+='D'; else if(sum == 14) res+='E';
 * else if(sum == 15) res+='F'; sum=0; } digitNumber++; }
 * System.out.println(res);
 */
/*
 * String words="a b c"; String[] word=words.split(" "); String output="";
 * for(int i=0;i<word.length;i++){
 * 
 * output+=word[(i+5)%word.length]+" "; }
 * 
 * System.out.println(output.substring(0,output.length()-1));
 */

/*
 * int[] a={0,0,0,0}; boolean chk=true; for(int i=0;i<a.length;i++){ for(int
 * j=0;j<a.length;j++){ //chk=false; if(a[i]>0) if(a[i]==a[j]){ chk=true; }
 * } if(!chk) break; } System.out.println(chk);
 */

// System.out.println(Math.ceil(r/2)>=0?(int)Math.ceil(r/2):(int)Math.floor(r/2)+1);
	
	public static char[] reverse(char[] chars){
		int n=chars.length;
		char[] rev=new char[n];
		for(int i=0;i<n;i++)
			rev[n-i-1]=chars[i];

		return rev;
	}
	
	public static void funny() throws NumberFormatException, IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int test=Integer.parseInt(br.readLine());
	String res[]=new String [test];
	for(int i=0;i<test;i++){
		char[] characters=br.readLine().toCharArray();
		char[] rev=reverse(characters);
		
		
		for(int x=1;x<characters.length;x++){
			if(Math.abs(characters[x]-characters[x-1])==Math.abs(rev[x]-rev[x-1])){
				if(x==characters.length-1)
					res[i]="Funny";
			}
			else {
				res[i]="Not Funny";
				break;
			}
		}
		
	}
	for(String s: res)
		System.out.println(s);
	}
	
	public static void chk() throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nos;

			nos = br.readLine().split(" ");

		
		if(nos.length>2 || nos.length==0)
			return;
		double i,j;
		try {
			 j=Double.parseDouble(nos[0])-1;
			 i=Double.parseDouble(nos[1])-1;
		}
		catch(NumberFormatException nfe)  {
			return;
		}
		
		
		if(i+1>=5 || i+1<=0 || j+1<=0){
			//System.out.println(0);
			return;
		}
		if(j%2==0)
			System.out.println((int)(((5*(j))) + (2*i))); 
		else
			System.out.println((int)(((5*(j-1))+1) + (2*i))); 
		
	}
	
	static int fn2(int x,int y){
		//int div=(y*y)!=0?y*y:x-y;
		return (x*x + x*y + y*y )%4;
	}
	
	
	static void fn(){

		int[] a = { -5, -83};
		int p = 3;
		for (int i = 0; i < a.length; i++) {
			int sub = 0, add = 0;
			sub = a[i] % p;
			if (a.length == 1) {
				sub = a[i] % p;
				if (sub > 0) {
					add = p - sub;
					a[i] = a[i] + add;
				}
			}

			else if (p > 2) {
				// if(a[i]!=a[i+1<a.length?i+1:0]){

				if (a[i] > 0 && sub > 0) {
					if (p < Math.abs(a[i])) {
						add = p - Math.abs(sub);
						a[i] = a[i] + add;
					} else
						a[i] = p;

				} else if (a[i] < 0) {

					if (p < Math.abs(a[i]) && sub <=0) {
						if (Math.abs(sub) > 0) {
							if ((Math.abs(a[i]) / p) % 2 == 0) {
								if (Math.abs(sub) >= p / 2-1) {
									if(Math.abs(a[i])!=Math.abs(sub) + p  && (Math.abs(a[i])/p<2))
										sub -= p;
									//sub += p;
									add =  Math.abs(sub);
								} else
									add = p + Math.abs(sub);
									
							} else {
								if (Math.abs(sub) >= p / 2-1) {
									if(Math.abs(a[i])!=Math.abs(sub) + p && (Math.abs(a[i])/p<2))
										sub -= p;
									add =  Math.abs(sub);
								} else{
									//sub -= p;
									add = p + Math.abs(sub);
								}
							}

							a[i] = a[i] + add;
						} else {
							// if((Math.abs(a[i])/p)%2==0)
							add = p;
							a[i] = a[i] + add;
						}
						
						
					} else
						a[i] = 0;

				}
			}
			else if(p==2){

				if (a[i] > 0 && sub > 0) {
					if (p < Math.abs(a[i])) {
						add = p - Math.abs(sub);
						a[i] = a[i] + add;
					} else
						a[i] = p;

				} else if (a[i] < 0) {
	
					//sub += p;
					add = p - Math.abs(sub);
					a[i] = a[i] + add;	
				}
			}
			System.out.println(a[i]);
			}
	
		}
	
		}
