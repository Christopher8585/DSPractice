package ShortestPath;


public class DijkstraImpl {
	public static void main(String arg[]){

		EdgeWeightedGraph ewg=new EdgeWeightedGraph(17);
		ewg.addEdge(new Edge(0,1,5.0));
		ewg.addEdge(new Edge(0,4,9.0));
		ewg.addEdge(new Edge(0,7,8.0));
		ewg.addEdge(new Edge(1,2,12.0));
		ewg.addEdge(new Edge(1,3,15.0));
		ewg.addEdge(new Edge(1,7,4.0));
		ewg.addEdge(new Edge(2,3,3.0));
		ewg.addEdge(new Edge(2,6,11.0));
		ewg.addEdge(new Edge(3,6,9.0));
		ewg.addEdge(new Edge(4,5,4.0));
		ewg.addEdge(new Edge(4,6,20.0));
		ewg.addEdge(new Edge(4,6,20.0));
		ewg.addEdge(new Edge(4,7,5.0));
		ewg.addEdge(new Edge(5,2,1.0));
		ewg.addEdge(new Edge(5,6,13.0));
		ewg.addEdge(new Edge(7,5,6.0));
		ewg.addEdge(new Edge(7,2,7.0));
		
		DijkstraSP d=new DijkstraSP(ewg,0);
		d.SP();
	}
}
