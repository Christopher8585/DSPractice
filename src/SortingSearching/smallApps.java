package SortingSearching;

import java.util.Arrays;
import java.util.Comparator;

public class smallApps {
	
	public static void mergeArrays(int[] a, int[] b, int n, int m) {
		int k = n + m - 1;
		int i = n - 1;
		int j = m - 1;

		while (i >= 0 && j >= 0) {
			if (a[i] > b[j])
				a[k--] = a[i--];
			else
				a[k--] = b[j--];
		}
		while (j >= 0)
			a[k--] = b[j--];

		print(a);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);
	}
	
	public static int binarySearch(int[] a, int low, int high, int item){
		while (low<=high){
			int mid=(high+low)/2;
			if(a[mid]==item)
				return mid;
			else if(a[low]<=a[mid]){
				if(item>a[mid])
					low=mid+1;
				else if(item>=a[low])
					high=mid-1;
				else
					low=mid+1;
			}
			else if(item<a[mid])
				high=mid-1;
			else if(item<=a[high])
				low=mid+1;
			else
				high=mid-1;	
		}
		return -1;
	}
	
	public static int search(int a[], int x) {
		return binarySearch(a, 0, a.length - 1, x);
	}

	public static void main(String[] args) {
		
		String[] s = { "gfe", "abc", "acb", "efg", "vas", "bac" };
		//Arrays.sort(s, new SortingAnagrams());
		Arrays.sort(s,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return sortByAnagram(o1).compareTo(sortByAnagram(o2));
			}

			public String sortByAnagram(String word){
				Arrays.sort(word.toCharArray());
				return word;
			}


		});
		for (int i = 0; i < s.length; i++)
			System.out.print(s[i] + " ");
		
		 mergeArrays(new int[] { 1, 2, 3, 5,0,0,0,0}, new int[] { 4, 6, 7,8 },4, 4);
		
		//System.out.print(search(new int []{15 ,16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14},	5));
	}

}
