package DFS;

import java.util.Scanner;

public class DFSAlgo {
	static Vertex[] nodeList;

	public static void main(String args[]) {

		Scanner a = new Scanner(System.in);

		boolean undirected = false;

		nodeList = new Vertex[6];
		nodeList[0] = new Vertex("PageA", null);
		nodeList[1] = new Vertex("PageB", null);
		nodeList[2] = new Vertex("PageC", null);
		nodeList[3] = new Vertex("PageD", null);
		nodeList[4] = new Vertex("PageE", null);
		nodeList[5] = new Vertex("PageF", null);

		nodeList[0].adjlink = new Neighbor(1, nodeList[0].adjlink);
		nodeList[0].adjlink = new Neighbor(3, nodeList[0].adjlink);
		nodeList[0].adjlink = new Neighbor(4, nodeList[0].adjlink);

		nodeList[1].adjlink = new Neighbor(3, nodeList[1].adjlink);

		nodeList[2].adjlink = new Neighbor(0, nodeList[2].adjlink);

		nodeList[3].adjlink = new Neighbor(1, nodeList[3].adjlink);

		nodeList[3].adjlink = new Neighbor(1, nodeList[3].adjlink);

		nodeList[4].adjlink = new Neighbor(5, nodeList[4].adjlink);

		nodeList[5].adjlink = new Neighbor(3, nodeList[5].adjlink);

		boolean[] visited = new boolean[6];

		driver(0, visited);
		//sprint();
	}

	public static void driver(int start, boolean[] visited) {
		dfs(start, visited);

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false)
				dfs(i, visited);
		}
	}

	private static void dfs(int vertexno, boolean[] visited) {
		visited[vertexno] = true;
		System.out.println("Visiting " + nodeList[vertexno].name);
		for (Neighbor nbr = nodeList[vertexno].adjlink; nbr != null; nbr = nbr.next) {
			if (visited[nbr.vertexno] == false) {
				System.out.println(nodeList[vertexno].name + "--"
						+ nodeList[nbr.vertexno].name);
				dfs(nbr.vertexno, visited);

			}
		}

	}

	private static void print() {
		System.out.println();
		for (int i = 0; i < nodeList.length; i++) {
			System.out.println(nodeList[i].name);
			for (Neighbor nbr = nodeList[i].adjlink; nbr != null; nbr = nbr.next) {
				System.out.println("-->" + nodeList[nbr.vertexno].name);
			}
		}
	}
}
