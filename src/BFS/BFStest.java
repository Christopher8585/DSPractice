package BFS;

import java.util.Scanner;

public class BFStest {
	public static void main(String args[]) {

		Vertex[] v;
		Scanner a = new Scanner(System.in);

		System.out.println("Enter no of edges");
		int size = a.nextInt();

		v = new Vertex[size];

		for (int i = 0; i < size; i++) {
			v[i] = new Vertex(i, null);
		}

		/*
		 * for(int i=0;i<size;i++){ System.out.println("Enter edge for "+i);
		 * 
		 * while (a.nextInt()!=-1){ System.out.println("Enter edge no");
		 * v[i].adjlink=new Neighbor(a.nextInt(),v[i].adjlink);
		 * System.out.println("End?"); //a.nextInt(); }
		 * 
		 * }
		 */

		v[0].adjlink = new Neighbor(1, v[0].adjlink);
		//v[0].adjlink = new Neighbor(5, v[0].adjlink);
		v[0].adjlink = new Neighbor(2, v[0].adjlink);

		v[1].adjlink = new Neighbor(0, v[1].adjlink);
		v[1].adjlink = new Neighbor(2, v[1].adjlink);

		v[2].adjlink = new Neighbor(4, v[2].adjlink);
		v[2].adjlink = new Neighbor(0, v[2].adjlink);
		v[2].adjlink = new Neighbor(1, v[2].adjlink);
		v[2].adjlink = new Neighbor(3, v[2].adjlink);
		

		v[3].adjlink = new Neighbor(2, v[3].adjlink);
		v[3].adjlink = new Neighbor(4, v[3].adjlink);
		//v[3].adjlink = new Neighbor(5, v[3].adjlink);

		v[4].adjlink = new Neighbor(5, v[4].adjlink);
		v[4].adjlink = new Neighbor(2, v[4].adjlink);
		v[4].adjlink = new Neighbor(3, v[4].adjlink);
		

		v[5].adjlink = new Neighbor(3, v[5].adjlink);
		//v[5].adjlink = new Neighbor(3, v[5].adjlink);

		BFS bfs = new BFS();
		bfs.BFS(v, 0);
		bfs.print();

	}

}
