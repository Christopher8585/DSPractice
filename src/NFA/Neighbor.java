package NFA;

public class Neighbor {
	int vertexno;
	Neighbor next;

	Neighbor(int tempvertexno, Neighbor tempnext) {
		vertexno = tempvertexno;
		next = tempnext;
	}
}
