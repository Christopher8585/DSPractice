package MST;

public class UF {
	int x[];
	UF(int size){
		x=new int[size];
		for(int i=0;i<size;i++)
			x[i]=i;
	}
	
	public int root(int v){
		while(v!=x[v])
			v=x[v];	
		return v;
	}
	
	public boolean isConnected(int a,int b){
		return root(a)==root(b);
	}
	
	public void union(int a, int b){
		int rootA=root(a);
		int rootB=root(b);
		
		x[rootA]=rootB;
	}
}
