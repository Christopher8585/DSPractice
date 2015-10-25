package ShortestPath;

public class Edge  {//implements Comparable {
	int v;
	int w;
	double weight;
	
	Edge(){
		
	}
	Edge(int v,int w,double weight){
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public int from(){
		return this.v;
	}
	
	public int to(){
		return this.w;
	}
	
	public double weight(){
		return this.weight;
	}
	
/*
	public int compareWeight(Edge e2){
		if(e2.weight>this.weight)
			return -1;
		else if(e2.weight<this.weight)
			return 1;
		else 
			return 0;
		
	}

	@Override
	public int compareTo(Object e) {
		double weightOfOtherEdge=((Edge)e).weight;
		return (int)(this.weight*100-weightOfOtherEdge*100);
	}
	*/
}
