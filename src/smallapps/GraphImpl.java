package smallapps;

public class GraphImpl {
	public static void main(String args[]){
		int n=7;
		Vertex[] v=new Vertex[n];
		for(int i=0;i<n;i++)
			v[i]=new Vertex(i,null);
	
		v[0].adjlink = new Neighbor(1, v[0].adjlink);
		v[0].adjlink = new Neighbor(5, v[0].adjlink);
		v[0].adjlink = new Neighbor(2, v[0].adjlink);
		v[0].adjlink = new Neighbor(6, v[0].adjlink);

		v[1].adjlink = new Neighbor(0, v[1].adjlink);
		v[1].adjlink = new Neighbor(2, v[1].adjlink);

		v[2].adjlink = new Neighbor(0, v[2].adjlink);
		v[2].adjlink = new Neighbor(1, v[2].adjlink);
		v[2].adjlink = new Neighbor(3, v[2].adjlink);
		v[2].adjlink = new Neighbor(4, v[2].adjlink);

		v[3].adjlink = new Neighbor(2, v[3].adjlink);
		v[3].adjlink = new Neighbor(4, v[3].adjlink);
		v[3].adjlink = new Neighbor(5, v[3].adjlink);

		v[4].adjlink = new Neighbor(2, v[4].adjlink);
		v[4].adjlink = new Neighbor(3, v[4].adjlink);

		v[5].adjlink = new Neighbor(3, v[5].adjlink);
		
		//v[5].adjlink = new Neighbor(3, v[5].adjlink);
		
		GraphTraversal g=new GraphTraversal();
		System.out.print(g.isConnected(v, 2, 4));
		
		
	}
}
