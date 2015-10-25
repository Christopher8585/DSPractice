package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public boolean visited[];
	public int edgeto[];
	public int level[];
	
	public void BFS(Vertex[] g, int start){
		visited=new boolean[g.length];
		edgeto=new int[g.length];
		level=new int[g.length];
		
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		visited[start]=true;
		int levelno=1;
		while(!queue.isEmpty()){
			int vertex=queue.remove();
			
			for(Neighbor n=g[vertex].adjlink;n!=null;n=n.next){
				if(!visited[n.nextvertexno]){
					queue.add(n.nextvertexno);
					
					visited[n.nextvertexno]=true;
					edgeto[n.nextvertexno]=vertex;
					level[n.nextvertexno]=levelno;
				}
			}
			levelno++;
		}
	}
	
	public void print(){
		
		for(int i=0;i<edgeto.length;i++){
			System.out.println();
			System.out.print(i+"   ");
			System.out.print(edgeto[i]+"   ");
			System.out.print(visited[i]+"   ");
			System.out.print(level[i]+"   ");
			
		}
	}
}
