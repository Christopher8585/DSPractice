package MST;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KruskalImpl {
	public static void main(String arg[]){

		EdgeWeightedGraph ewg=new EdgeWeightedGraph(5);
		ewg.addEdge(new Edge(1,2,1));
		ewg.addEdge(new Edge(1,3,8));
		ewg.addEdge(new Edge(2,3,4));
		ewg.addEdge(new Edge(2,4,5));
		ewg.addEdge(new Edge(3,4,1));
		
		Kruskal k=new Kruskal();
		k.krushalSolution(ewg);
		int sum=0;
		while (!k.mst.isEmpty()){
			Edge e=k.mst.remove();
			System.out.print(e.v+","+e.w+" weight:"+e.weight);
			System.out.println();
			sum+=e.weight;
		}
		
		System.out.println(sum);	
		
		PriorityQueue<Integer> pq=new PriorityQueue(5,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		pq.add(1);
		pq.add(3);
		pq.add(44);
		pq.add(5);
		pq.add(99);
		pq.add(122);
		pq.add(12);
		pq.add(166);
		for(int i=0;i<5;i++){
			System.out.println(pq.remove());
		}
	}
}
