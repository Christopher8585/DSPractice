package NFA;

public class Vertex {
	char c;
	Neighbor adjlink;

	Vertex(char ch, Neighbor tempadjlink) {
		c = ch;
		adjlink = tempadjlink;
	}
}
