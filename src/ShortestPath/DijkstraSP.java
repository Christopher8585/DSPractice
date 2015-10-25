package ShortestPath;

import java.util.ArrayList;
import java.util.Collections;

public class DijkstraSP {
	private Edge[] edgeTo;
	private double[] distTo;
	double[] pq;
	
	DijkstraSP(EdgeWeightedGraph G,int s){
		edgeTo=new Edge[G.size];
		distTo=new double[G.size];
		pq=new double[G.size];
		
		for(int v=0;v<G.size;v++){
			distTo[v]=Double.POSITIVE_INFINITY;
			pq[v]=Double.POSITIVE_INFINITY;
		}
		distTo[s]=0.0;

		pq[s]=0.0;
		//Collections.sort(pq);
		while (true){
			int vertex=0;
			double min=Double.MAX_VALUE;
			for(int i=0;i<G.size;i++)
				if(pq[i]<min){
					min=pq[i];
					vertex=i;
				}
			if(min==Double.MAX_VALUE)
				break;
			pq[vertex]=Double.MAX_VALUE;//Remove
			//pq.remove(vertex);	
			ArrayList<Edge>edges =G.getEdges(vertex);
			for(int i=0;i<edges.size();i++){
				Edge e=edges.get(i);
				int v=e.from();
				int w=e.to();
				if(distTo[w]>distTo[v]+e.weight()){
					distTo[w]=distTo[v]+e.weight();
					edgeTo[w]=e;
					pq[w]=distTo[w];
				}
			}
			
			//if(pq.size()>0)
				//Collections.sort(pq);
		}
	}
	
	
	public void SP(){
		for(Edge e:edgeTo)
			if(e!=null)
				System.out.println("From "+ e.from()+ " To "+e.to() +" Weight: "+e.weight() +" To Distance: "+distTo[e.to()]);
	}
	
/*
	@SuppressWarnings("unchecked")
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
	*/
}
