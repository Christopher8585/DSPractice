import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class test345 {
		public static void main(String[] args) throws NumberFormatException,
		IOException {
			
	
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int test = Integer.parseInt(br.readLine());
		int [] pi=new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,3};
		boolean [] res=new boolean[test];
		
		for(int testcases=0;testcases<test;testcases++){
			String[] c=br.readLine().split(" ");
			int count=0;
			boolean piCount=true; 
			for(String s:c){
				if(pi[count++]!=s.length()){
					piCount=false;
					break;
				}
			}
			res[testcases]=piCount;

			//System.out.println(a[0]+" "+a[1]);
		}
		
		for(boolean a:res)
			if(a)
				System.out.println("It's a pi song.");
			else
				System.out.println("It's not a pi song.");
		
	}
	
	
	
	static int nos[];
	
	private static int[] findAll(int[] nos) {
		// TODO Auto-generated method stub
		int[] a=new int [2];
		int min=Integer.MAX_VALUE;	
		int max=0;
		for(int i=1;i<=3;i++){
			a=All(0,i,0,0,0,0);
			min=min(min,a[0]);
			max=max(max,a[1]);
		}
		
		return a;
	}

	private static int[] All(int i, int lane, int unhappy, int max1, int max2, int max3) {
		if(i==nos.length)
			return new int[]{unhappy,unhappy};

		if(lane==1){
			if(nos[i]<=max1 || max1==0){
				max1=nos[i];
			}
			else if(max1<nos[i])
				unhappy++;
		}
		
		if(lane==2){
			if(nos[i]<=max2 || max2==0){
				max2=nos[i];
			}
			else if(max2<nos[i])
				unhappy++;
		}
		
		if(lane==3){
			if(nos[i]<=max3 || max3==0){
				max3=nos[i];
			}
			else if(max3<nos[i])
				unhappy++;
		}
		
		int a[]=new int[2];
		int min=Integer.MAX_VALUE;	
		int max=0;
		for(int x=1;x<=3;x++){
			a=All(i+1,x,unhappy,max1,max2,max3);
			min=min(min,a[0]);
			max=max(max,a[1]);
		}

		return new int[]{min,max};
	}
	

	private static int min(int min, int min2) {
		return min<min2?min:min2;
	}
	
	private static int max(int min, int min2) {
		return min>min2?min:min2;
	}


	
	
	/*
	private static int findMax(int[] nos) {
		// TODO Auto-generated method stub
		int max=0;	
		for(int i=1;i<=3;i++)
			max=max(maxAll(0,i,0,0,0,0),max);
		
		return max;
	}

	private static int maxAll(int i, int lane, int unhappy, int max1, int max2, int max3) {
		if(i==nos.length)
			return unhappy;

		if(lane==1)
			if(nos[i]<=max1 || max1==0){
				max1=nos[i];
			}
			else if(max1<nos[i])
				unhappy++;
		
		if(lane==2)
			if(nos[i]<=max2 || max2==0){
				max2=nos[i];
			}
			else if(max2<nos[i])
				unhappy++;
		
		if(lane==3)
			if(nos[i]<=max3 || max3==0){
				max3=nos[i];
			}
			else if(max3<nos[i])
				unhappy++;
		
		int max=0;
		for(int x=1;x<=3;x++)
			max=max(maxAll(i+1,x,unhappy,max1,max2,max3),max);	

		return max;
	}
	
	
	*/
	
/*
	private static int findMax(int[] nos) {
		// TODO Auto-generated method stub
				int n=nos.length;
				 maxLane1=0;
				 maxLane2=0;
				 maxLane3=0;
				if(n<3)
					return 0;
				lane1=new int[n];
				lane2=new int[n];
				lane3=new int[n];
				int unhappy=0;
				
				for(int x=0;x<n;x++){
					
					int lane=selectBadLane(nos[x]);
					if(lane==1){
						lane1[x]=nos[x];
						if(maxLane1>=nos[x])
							maxLane1=nos[x];
						else unhappy++;
					}
					else if(lane==2){
						lane2[x]=nos[x];
						if(maxLane2>=nos[x])
							maxLane2=nos[x];
						else unhappy++;
					}
					else if(lane==3){
						lane3[x]=nos[x];
						if(maxLane3>=nos[x])
							maxLane3=nos[x];
						else unhappy++;
					}
				}
				return unhappy;
	}
	
	private static int selectBadLane(int i) {
		if((maxLane1-i)<0 && ((maxLane1-i)>=(maxLane2-i)  && (maxLane1-i)>=(maxLane3-i))){
			if(maxLane1==0)
				maxLane1=Math.abs(maxLane1-i);
			return 1;
		}
		if((maxLane2-i)<0 && ((maxLane2-i)>=(maxLane1-i)  && (maxLane2-i)>=(maxLane3-i))){
			if(maxLane2==0)
				maxLane2=Math.abs(maxLane2-i);
			return 2;
		}
		if((maxLane3-i)<0 && ((maxLane3-i)>=(maxLane1-i)  && (maxLane3-i)>=(maxLane2-i))){
			if(maxLane3==0)
				maxLane3=Math.abs(maxLane3-i);
			return 3;
		}
		
		
		if(maxLane1!=0)
			return 1;
		else if( maxLane2!=0)
			return 2;
		else if( maxLane3!=0)
			return 3;

		
		return 1;
	}

	static int []lane1;
	static int []lane2;
	static int []lane3;
	static int maxLane1,maxLane2,maxLane3;
	private static int findMin(int[] nos) {
		// TODO Auto-generated method stub
		 maxLane1=Integer.MAX_VALUE;
		 maxLane2=Integer.MAX_VALUE;
		 maxLane3=Integer.MAX_VALUE;
		int n=nos.length;
		
		if(n<3)
			return 0;
		//lane1=new int[n];
		//lane2=new int[n];
		//lane3=new int[n];
		int unhappy=0;
		
		for(int x=0;x<n;x++){
			
			int lane=selectLane(nos[x]);
			if(lane==1){
				//lane1[x]=nos[x];
				if(maxLane1>=nos[x])
					maxLane1=nos[x];
				else unhappy++;
			}
			else if(lane==2){
				//lane2[x]=nos[x];
				if(maxLane2>=nos[x])
					maxLane2=nos[x];
				else unhappy++;
			}
			else if(lane==3){
				//lane3[x]=nos[x];
				if(maxLane3>=nos[x])
					maxLane3=nos[x];
				else unhappy++;
			}
		}
		return unhappy;
	}

	private static int selectLane(int i) {
		if((maxLane1-i)>=0 && ((maxLane1-i)<=(maxLane2-i)  && (maxLane1-i)<=(maxLane3-i)))
			return 1;
		if((maxLane2-i)>=0 && ((maxLane2-i)<=(maxLane1-i)  && (maxLane2-i)<=(maxLane3-i)))
			return 2;
		if((maxLane3-i)>=0 && ((maxLane3-i)<=(maxLane1-i)  && (maxLane3-i)<=(maxLane2-i)))
			return 3;
		
		
		if(maxLane1==Integer.MAX_VALUE)
			return 1;
		else if( maxLane2==Integer.MAX_VALUE)
			return 2;
		else if( maxLane3==Integer.MAX_VALUE)
			return 3;
		
		if((Math.abs(maxLane1-i)<=Math.abs(maxLane2-i)  && Math.abs(maxLane1-i)<=Math.abs(maxLane3-i)))
			return 1;
		if((Math.abs(maxLane2-i)<=Math.abs(maxLane1-i)  && Math.abs(maxLane2-i)<=Math.abs(maxLane3-i)))
			return 2;
		if((Math.abs(maxLane3-i)<=Math.abs(maxLane1-i)  && Math.abs(maxLane3-i)<=Math.abs(maxLane2-i)))
			return 3;
		
		return 1;
	}
	*/
}

