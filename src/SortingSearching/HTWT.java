package SortingSearching;

public class HTWT implements Comparable<HTWT>{

	int height;
	int weight;
	
	HTWT(int h,int w){
		height=h;
		weight=w;
	}
	
	public boolean isBefore(HTWT item){
		if(this.height-item.height >0)
			return  false;
		else
			return true;
			
	}

	@Override
	public int compareTo(HTWT o) {
		if(this.height==o.height)
			return Integer.valueOf(this.weight).compareTo(o.weight);;
		
		return Integer.valueOf(this.height).compareTo(o.height);
	}

}
