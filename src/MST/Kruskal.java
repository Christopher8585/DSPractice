package MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {
	Queue<Edge> mst=new LinkedList<Edge>();

	public void krushalSolution(EdgeWeightedGraph g){
		// Queue<Edge> minEdges=createMinQ(g);
		PriorityQueue<Edge> minEdges=new PriorityQueue<Edge>(100,new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return Double.valueOf(o1.weight).compareTo(o2.weight);
			}
		});
		for(ArrayList<Edge> e : g.vertexEdges){
				minEdges.addAll(e);
		}
		
		
		
		UF uf=new UF(g.size);
		while(!minEdges.isEmpty() && mst.size()<g.size-1){
			Edge e=minEdges.remove();
			if(!uf.isConnected(e.either(),e.other(e.either()))){
				mst.add(e);
				uf.union(e.either(),e.other(e.either()));
			}
			
		}
	}
	
	//1,2 weight:1.0
	//3,4 weight:1.0
	//2,3 weight:4.0
	
	private Queue<Edge> createMinQ(EdgeWeightedGraph g) {
		Queue<Edge> q=new LinkedList<Edge>();
		ArrayList<Edge> sorted=new ArrayList<Edge>();
		for(ArrayList<Edge> e : g.vertexEdges){
			for(Edge edge : e){
				sorted.add(edge);
			}
		}
		Collections.sort(sorted);
		for(int i=0;i<sorted.size();i++)
			q.add(sorted.get(i));
		
		return q;
	}
}
