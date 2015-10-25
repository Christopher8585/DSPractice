package SortingSearching;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAnagrams implements Comparator<String>{

	public static String sortByAnagram(String word){
		Arrays.sort(word.toCharArray());
		return word;
	}

	@Override
	public int compare(String o1, String o2) {
		
		return sortByAnagram(o1).compareTo(sortByAnagram(o2));
	}

}
