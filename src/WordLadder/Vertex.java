package WordLadder;

public class Vertex {
	String name;
	Neighbor adjlink;
	
	Vertex(String name,Neighbor adj){
		this.name=name;
		this.adjlink=adj;
	}	
}
