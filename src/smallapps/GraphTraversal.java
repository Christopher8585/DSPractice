package smallapps;

import java.util.Queue;
import java.util.LinkedList;

public class GraphTraversal {

	// enum States{VISITED,VISITING,UNVISITED};

	public boolean isConnected(Vertex[] graph, int start, int end) {

		boolean[] visited = new boolean[graph.length];
		//for (boolean v : visited)
			//v = false;

		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int vertex = q.remove();

			for (Neighbor n = graph[vertex].adjlink; n != null; n = n.next) {
				if (!visited[n.nextvertex]) {
					if (n.nextvertex == end)
						return true;
					else {
						q.add(n.nextvertex);
						visited[n.nextvertex] = true;
					}
				}
			}
		}

		return false;
	}
}
