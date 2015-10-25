import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PoolOfZeros {
	static int totalCount=0;
	public static void main(String args[]) throws NumberFormatException, IOException{

		int nos[][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int i=Integer.parseInt(br.readLine());
		int j=Integer.parseInt(br.readLine());
		nos=new int[i][j];
		
		
		for(int k=0;k<i;k++){
			String[] row=br.readLine().split(" ");
			for(int n=0;n<j;n++){
				nos[k][n]=Integer.parseInt(row[n]);
			}
		}
		countPool(nos);
	}
	
	public static void countPool(int [][] a){
		boolean [][] visited=new boolean[a.length][a[0].length];
	
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[i].length;j++){
				if(a[i][j]==1 && visited[i][j]==false){
					DFS(a,i,j,visited,1);
				}
			}
		
		System.out.println(totalCount);
	}

	private static void DFS(int[][] a, int i, int j, boolean[][] visited, int count) {
		
		if(totalCount<count && a[i][j]==1)
			totalCount=count;
		
		int[] rowValues={-1,-1,-1,0,0,1,1,1};
		int[] colValues={1,0,-1,1,-1,1,0,-1};
		boolean[][] temp=visited.clone();
		temp[i][j]=true;
		
		for(int k=0;k<8;k++){
			if(isSafe(a,i+rowValues[k],j+colValues[k],temp))
				DFS(a,i+rowValues[k],j+colValues[k],temp,count+1);
		}
	}

	private static boolean isSafe(int[][] a, int i, int j, boolean[][] visited) {
		if((i>=0 && i<a.length) && (j>=0 && j<a[0].length) && visited[i][j]!=true && a[i][j]==1)
			return true;
		
		return false;
	}
}
