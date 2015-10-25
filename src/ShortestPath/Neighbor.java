 package ShortestPath;

public class Neighbor {
	int nextvertexno;
	Neighbor next;
	
	Neighbor(int nextvert,Neighbor nextver){
		this.nextvertexno=nextvert;
		this.next=nextver;
	}
}
