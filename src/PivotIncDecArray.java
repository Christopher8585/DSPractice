
public class PivotIncDecArray {
	public static void main(String args[]){
		System.out.println(SearchElement(new int[] {5,6,7,8,10,12,1,2,3,4}, 12));
	}
	
	public static int BinarySearch(int a[],int low,int high,int no){
		if(high<low)
			return -1;
		
		int mid=(high+low)/2;
		
		if(a[mid]==no)
			return mid;
		
		if(a[mid]>no)
			return BinarySearch(a, low, mid-1, no);
		else
			return BinarySearch(a, mid+1, high, no);
	}
	
	public static int SearchElement(int a[],int no){
		int pivot=findPivot(a,0,a.length);
		if(pivot==-1)
			return BinarySearch(a, 0, a.length, no);
		
		if(a[pivot]==no)
			return pivot;
		
		if(a[0]<=no)
			return  BinarySearch(a, 0, pivot-1, no);
		else
			return BinarySearch(a, pivot+1, a.length, no);
		
	}
	
	//5 6 7 8 1 2 3 
	public static int findPivot(int a[],int low,int high){
		if(high<low)
			return -1;
		
		if(high==low)
			return low;
		
		int mid=(low+high)/2;
		
		if(low<mid && a[mid]<a[mid-1])
			return mid-1;
		
		if(high>mid && a[mid]>a[mid+1])
			return mid;
		
		if(a[low]>=a[mid])
			return findPivot(a, low, mid-1);
		else
			return findPivot(a, mid+1, high);
			
			
	}
}
