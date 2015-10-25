package DFS;

public class Vertex {
	String name;
	Neighbor adjlink;

	Vertex(String tempname, Neighbor tempadjlink) {
		name = tempname;
		adjlink = tempadjlink;
	}
}
