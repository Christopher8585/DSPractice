package Heap;

public class Heap {

	int[] heap;
	int top;
	
	Heap(int size){
		heap=new int[size];
		top=-1;
	}
	
	public String toString(){
		String s="";
		for(int i=0;i<=top;i++)
			s+=" " + heap[i];
		return s;
	}
	
	public void add(int value){
		heap[++top]=value;
		siftUp();
	}
	
	public int remove(){
		if(top==-1)
			return -1;
		if( top==0)
			return heap[top--];
		
		int value=heap[0];
		heap[0]=heap[top];
		top--;
		siftDown();
		return value;
			
	}
	
	private void siftUp(){
		int k=top;
		
		while (k>0){
			int p=(k-1)/2;
			if(heap[p]<heap[k]){
				int temp=heap[p];
				heap[p]=heap[k];
				heap[k]=temp;
				k=p;
			}
			else
				break;
		}
	}
	
	private void siftDown(){
		int k=0;
		int l=2*k+1;
		while(l<=top){
			int max=l,r=l+1;
			
			if( r<=top )
				if(heap[r]>heap[l]){
					max++;
				}
			
			if(heap[max]>heap[k]){
				int temp=heap[max];
				heap[max]=heap[k];
				heap[k]=temp;
			}
			else
				break;
				
			k=max;
			l=2*k+1;
					
		}
	}
	
	
}
