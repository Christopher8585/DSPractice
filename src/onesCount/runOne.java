package onesCount;
	
public class runOne {
		
	
	static int test(int arr[]){
		int n=arr.length; 
		int prev0=arr[n-1]==1?1:0, cur0=0;
		int prev1=0,cur1=0;
		int max=0;
		for(int i=n-2;i>=0;i--){
			cur0=arr[i]==0? 0: 1+prev0;
			if(arr[i]==0)
				cur1=1+prev0;
			else
				cur1=1+prev1;
			
			if(max<cur1)
				max=cur1;
			
			prev0=cur0;
			prev1=cur1;
			
		}
		return max;
	}

static int SearchLongest1Sequence(int arr[]) {
    int pos = -1;
    int n=arr.length;
    if (n == 0) return 0;
    if (n == 1) {
        if (arr[0] == 0) pos = 0;
        return 1;
    }

    int prev0 = arr[n - 1] == 1 ? 1 : 0, cur0 = 0;
    int prev1 = 1, cur1 = 0;
   // int prevPos = arr[n - 1] == 1 ? -1 : (n - 1), curPos = 0;
    int longestLen = 0;
    for (int i = n - 2; i >= 0; --i) {
        cur0 = arr[i] == 0 ? 0 : 1 + prev0;
        if (arr[i] == 0) {
            cur1 = 1 + prev0;
            //curPos = i;
        }
        else {
            cur1 = 1 + prev1;
            //curPos = prevPos;
        }

        if (cur1 > longestLen) {
            longestLen = cur1;
            //pos = curPos;
        }

        prev0 = cur0; prev1 = cur1;// prevPos = curPos;
    }

    return longestLen;
}


	
	public static void main(String args[]){
		int[] nos={ 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0 };
		System.out.print(test(nos));
	}
}
