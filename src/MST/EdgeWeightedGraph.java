package MST;

import java.util.ArrayList;

public class EdgeWeightedGraph{
	int size;
	ArrayList<ArrayList<Edge>> vertexEdges;
	
	public EdgeWeightedGraph(int size) {
		this.size=size;
		vertexEdges=new ArrayList<ArrayList<Edge>>();
		for(int i=0;i<size;i++){
			vertexEdges.add(new ArrayList<Edge>());
		}
	}
	
	public void addEdge(Edge e){
		
		ArrayList<Edge> edges1= vertexEdges.get(e.either());
		ArrayList<Edge> edges2= vertexEdges.get(e.other(e.either()));
		edges1.add(e);
		edges2.add(e);
	}
	
	public ArrayList<Edge> getEdges(int v){
		return vertexEdges.get(v);
	}
}
