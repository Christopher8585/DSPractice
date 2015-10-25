package ShortestPath;

public class Vertex {
	int vertexno;
	Neighbor adjlink;
	
	Vertex(int vert,Neighbor adj){
		this.vertexno=vert;
		this.adjlink=adj;
	}
	
}
