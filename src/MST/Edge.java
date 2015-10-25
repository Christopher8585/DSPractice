package MST;

public class Edge implements Comparable<Edge> {
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
	int either(){
		return v;
	}
	
	int other(int one){
		if(one==v)
			return w;
		else
			return v;
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
	*/
	@Override
	public int compareTo(Edge e) {
		return Double.valueOf(this.weight).compareTo(e.weight);
		//return Double.compare(this.weight, e.weight);
		//return (int)(this.weight*100-e.weight*100);
	}
}
