package WordLadder;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public boolean visited[];
	public int edgeto[];
	public int level[];
	Vertex[] gv;
	
	public void BFS(Vertex[] g, int start,String end){
		visited=new boolean[g.length];
		edgeto=new int[g.length];
		level=new int[g.length];
		gv=g;
		
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		visited[start]=true;
		int levelno=1;
		while(!queue.isEmpty()){
			int vertex=queue.remove();
			//System.out.println(g[vertex].name);
			if(end==g[vertex].name){
               // return;
			}
			for(Neighbor n=g[vertex].adjlink;n!=null;n=n.next){
				if(!visited[n.nextvertexno]){
					//if(end==g[n.nextvertexno].name){
						System.out.println("-->"+g[n.nextvertexno].name);
		                //return true;
					//}
					queue.add(n.nextvertexno);
					//
					visited[n.nextvertexno]=true;
					edgeto[n.nextvertexno]=vertex;
					level[n.nextvertexno]=levelno;
				}
			}
			levelno++;
		}
		//return false;
	}
	
	public void print(String from,String to){
		
		for(int i=0;i<edgeto.length;i++){
			System.out.println();
			System.out.print(edgeto[i]+"   ");
			System.out.print(visited[i]+"   ");
			System.out.print(level[i]+"   ");
			
			
			System.out.print(gv[i].name);
			System.out.print("-"+i);
		}
		
		int index=0;
		for(int i=0;i<edgeto.length;i++){
			if(gv[i].name==to){
				index=i;
				break;
			}
				
		}
		for(int i=0;i<edgeto.length;i++){
			System.out.println(gv[index].name);
			if(gv[index].name==from)
				break;
			index=edgeto[index];
		}
	}
}
