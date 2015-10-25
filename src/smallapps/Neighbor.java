package smallapps;

public class Neighbor {
	int nextvertex;
	Neighbor next;
	
	Neighbor(int v,Neighbor n){
		nextvertex=v;
		next=n;
	}
}
